CREATE TABLE relatorio_semanal (
    semana_inicio DATE PRIMARY KEY,
    total_pedidos INTEGER NOT NULL,
    lucro_total NUMERIC(10,2) NOT NULL,
    despesas_total NUMERIC(10,2) NOT NULL
);

CREATE OR REPLACE FUNCTION pagamentos_into_semanal()
RETURNS TRIGGER AS $$

DECLARE
v_semana_inicio DATE;

BEGIN
    v_semana_inicio := date_trunc('week', CURRENT_TIMESTAMP - INTERVAL '7 hours')::DATE;

    IF (
        (TG_OP = 'INSERT' AND NEW.status::text = 'PAGO')
        OR
        (TG_OP = 'UPDATE' AND NEW.status::text = 'PAGO' AND OLD.status::text <> 'PAGO')
    ) THEN

        INSERT INTO relatorio_semanal
        (semana_inicio, total_pedidos, lucro_total, despesas_total)
        VALUES
        (v_semana_inicio, 1, NEW.valor_original, 0)

        ON CONFLICT (semana_inicio)
        DO UPDATE SET
    total_pedidos = relatorio_semanal.total_pedidos + 1,
                                          lucro_total = relatorio_semanal.lucro_total + EXCLUDED.lucro_total;

END IF;

RETURN NEW;
END;

$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION despesas_into_semanal()
RETURNS TRIGGER AS $$

DECLARE
v_semana_inicio DATE;

BEGIN
    v_semana_inicio := date_trunc('week', CURRENT_TIMESTAMP - INTERVAL '7 hours')::DATE;

INSERT INTO relatorio_semanal
(semana_inicio, total_pedidos, lucro_total, despesas_total)
VALUES
    (v_semana_inicio, 0, 0, NEW.valor_despesa)

    ON CONFLICT (semana_inicio)
    DO UPDATE SET
    despesas_total = relatorio_semanal.despesas_total + EXCLUDED.despesas_total;

RETURN NEW;
END;

$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_pagamentos_semanal
    AFTER INSERT OR UPDATE ON tb_pagamentos
    FOR EACH ROW
    EXECUTE FUNCTION pagamentos_into_semanal();

CREATE TRIGGER trg_despesas_semanal
    AFTER INSERT ON despesas
    FOR EACH ROW
    EXECUTE FUNCTION despesas_into_semanal();

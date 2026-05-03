CREATE TABLE relatorio_semanal (
    semana_inicio DATE PRIMARY KEY,
    total_pedidos INTEGER NOT NULL,
    lucro_total NUMERIC(10,2) NOT NULL,
    despesas_total NUMERIC(10,2) NOT NULL
);

CREATE OR REPLACE FUNCTION pagamentos_into_semanal()
RETURNS TRIGGER AS $$

DECLARE
semana_inicio DATE;

BEGIN

    -- pega início da semana (segunda)
    semana_inicio := date_trunc('week', CURRENT_TIMESTAMP - INTERVAL '7 hours')::DATE;

    -- quando pagamento for aprovado
    IF (
        (TG_OP = 'INSERT' AND NEW.status = 'APROVADO')
        OR
        (TG_OP = 'UPDATE' AND NEW.status = 'APROVADO' AND OLD.status <> 'APROVADO')
    ) THEN

        INSERT INTO relatorio_semanal
        (data, quantidade_pedidos, lucro_total, despesas)

        VALUES
        (semana_inicio, 1, NEW.valor_original, 0)

        ON CONFLICT (data)

        DO UPDATE SET
    quantidade_pedidos = relatorio_semanal.quantidade_pedidos + 1,
                                        lucro_total = relatorio_semanal.lucro_total + EXCLUDED.lucro_total;

END IF;

RETURN NEW;

END;

$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION despesas_into_semanal()
RETURNS TRIGGER AS $$

DECLARE
semana_inicio DATE;

BEGIN

    semana_inicio := date_trunc('week', CURRENT_TIMESTAMP - INTERVAL '7 hours')::DATE;

INSERT INTO relatorio_semanal
(data, quantidade_pedidos, lucro_total, despesas)

VALUES
    (semana_inicio, 0, 0, NEW.valor_despesa)

    ON CONFLICT (data)

    DO UPDATE SET
    despesas = relatorio_semanal.despesas + EXCLUDED.despesas;

RETURN NEW;

END;

$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_pedidos_semanal
AFTER INSERT OR UPDATE ON pedidos
    FOR EACH ROW
    EXECUTE FUNCTION pedidos_into_semanal();

CREATE TRIGGER trg_despesas_semanal
    AFTER INSERT ON despesas
    FOR EACH ROW
    EXECUTE FUNCTION despesas_into_semanal();

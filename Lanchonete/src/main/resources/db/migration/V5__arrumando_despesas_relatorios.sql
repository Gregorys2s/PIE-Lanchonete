CREATE TABLE despesas (
    id SERIAL PRIMARY KEY,
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor_despesa numeric(10, 2) NOT NULL
);

CREATE OR REPLACE FUNCTION despesas_into_diario()
RETURNS TRIGGER AS $$
DECLARE
data_faturamento DATE;
BEGIN
    -- Usa a mesma lógica de turno (7 horas de recuo)
    data_faturamento := (CURRENT_TIMESTAMP - INTERVAL '7 hours')::DATE;

INSERT INTO relatorio_diario (data, quantidade_pedidos, lucro_total, despesas)
VALUES (data_faturamento, 0, 0.00, NEW.valor_despesa)
    ON CONFLICT (data) --esse aqui cria ou atualiza a tabela, depende da data
    DO UPDATE SET
    despesas = relatorio_diario.despesas + EXCLUDED.despesas;

RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_diario_despesas
    AFTER INSERT ON despesas
    FOR EACH ROW
    EXECUTE FUNCTION despesas_into_diario();
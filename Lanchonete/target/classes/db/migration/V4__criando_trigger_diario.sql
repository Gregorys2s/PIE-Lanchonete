CREATE OR REPLACE FUNCTION pedidos_into_diario()
RETURNS TRIGGER AS $$
DECLARE
data_faturamento DATE;
BEGIN
   data_faturamento := (CURRENT_TIMESTAMP - INTERVAL '7 hours')::DATE;

   IF (
       (TG_OP = 'INSERT' AND NEW.status = TRUE)
       OR
       (TG_OP = 'UPDATE' AND NEW.status = TRUE AND OLD.status = FALSE)
   ) THEN

       INSERT INTO relatorio_diario (data, quantidade_pedidos, lucro_total)
       VALUES (data_faturamento, 1, NEW.valor_total)
       ON CONFLICT (data)
       DO UPDATE SET
    quantidade_pedidos = relatorio_diario.quantidade_pedidos + 1,
    lucro_total = relatorio_diario.lucro_total + EXCLUDED.lucro_total;

END IF;

RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER trigger_diario_pedidos
    AFTER INSERT OR UPDATE ON pedidos
    FOR EACH ROW
    EXECUTE FUNCTION pedidos_into_diario();


ALTER TABLE relatorio_diario ADD CONSTRAINT unique_data_relatorio UNIQUE (data);
CREATE TABLE relatorio_diario (
        id              SERIAL PRIMARY KEY,
        data            DATE NOT NULL DEFAULT CURRENT_DATE,
        quantidade_pedidos INTEGER NOT NULL DEFAULT 0,
        despesas        NUMERIC(10, 2) NOT NULL DEFAULT 0.00,
        lucro_total     NUMERIC(10, 2) NOT NULL DEFAULT 0.00,
        estoque_final   NUMERIC(10, 2)
);

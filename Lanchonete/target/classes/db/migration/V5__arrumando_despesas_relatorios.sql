CREATE TABLE despesas (
    id SERIAL PRIMARY KEY,
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor_despesa numeric(10, 2) NOT NULL
)


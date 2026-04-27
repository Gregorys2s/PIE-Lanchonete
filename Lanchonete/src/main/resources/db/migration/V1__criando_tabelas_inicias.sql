CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco NUMERIC(10,2) NOT NULL,
    tipo VARCHAR(100) NOT NULL
);

CREATE TABLE ingredientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    estoque INTEGER NOT NULL
);

CREATE TABLE pedidos (
    id SERIAL PRIMARY KEY,
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor_total NUMERIC(10,2) NOT NULL
);

CREATE TABLE item_pedidos (
    id SERIAL PRIMARY KEY,

    fk_pedido_id BIGINT NOT NULL,
    fk_produto_id BIGINT NOT NULL,

    quantidade INTEGER NOT NULL,

    CONSTRAINT fk_item_pedido
    FOREIGN KEY (fk_pedido_id)
    REFERENCES pedidos (id)
    ON DELETE CASCADE,

    CONSTRAINT fk_item_produto
    FOREIGN KEY (fk_produto_id)
    REFERENCES produtos (id)
);
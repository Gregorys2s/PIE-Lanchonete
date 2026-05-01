CREATE TABLE cardapio (
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

CREATE TABLE item_cardapio (
    id SERIAL PRIMARY KEY,
    fk_ingredientes_id INTEGER NOT NULL,
    fk_cardapio_id INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,

    FOREIGN KEY (fk_ingredientes_id) REFERENCES ingredientes(id),
    FOREIGN KEY (fk_cardapio_id) REFERENCES cardapio(id)
);

CREATE TABLE pedidos (
    id SERIAL PRIMARY KEY,
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor_total NUMERIC(10,2) NOT NULL
);

CREATE TABLE itempedido (
    id SERIAL PRIMARY KEY,
    fk_pedido_id INTEGER NOT NULL,
    fk_cardapio_id INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,

    CONSTRAINT fk_item_pedido
    FOREIGN KEY (fk_pedido_id)
    REFERENCES pedidos (id)
    ON DELETE CASCADE,

    CONSTRAINT fk_item_cardapio
    FOREIGN KEY (fk_cardapio_id)
    REFERENCES cardapio (id)
);
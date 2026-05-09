INSERT INTO ingredientes (nome, estoque) VALUES
    ('Pão', 100),
    ('Carne', 50),
    ('Queijo', 80),
    ('Alface', 60),
    ('Tomate', 60),
    ('Bacon', 40);

INSERT INTO cardapio (nome, preco, tipo) VALUES
    ('X-Burguer', 15.00, 'Lanche'),
    ('X-Salada', 18.00, 'Lanche'),
    ('X-Bacon', 20.00, 'Lanche');

INSERT INTO item_cardapio (fk_ingredientes_id, fk_cardapio_id, quantidade) VALUES
    (1, 1, 1),
    (2, 1, 1),
    (3, 1, 1);

INSERT INTO item_cardapio (fk_ingredientes_id, fk_cardapio_id, quantidade) VALUES
    (1, 2, 1),
    (2, 2, 1),
    (4, 2, 1),
    (5, 2, 1);

INSERT INTO item_cardapio (fk_ingredientes_id, fk_cardapio_id, quantidade) VALUES
    (1, 3, 1),
    (2, 3, 1),
    (3, 3, 1),
    (6, 3, 1);
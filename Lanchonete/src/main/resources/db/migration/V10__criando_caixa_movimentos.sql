CREATE TABLE caixa_movimentos (
                                  id SERIAL PRIMARY KEY,
                                  data_hora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  tipo VARCHAR(30) NOT NULL,
                                  valor NUMERIC(10,2) NOT NULL,
                                  saldo_apos NUMERIC(10,2) NOT NULL
);
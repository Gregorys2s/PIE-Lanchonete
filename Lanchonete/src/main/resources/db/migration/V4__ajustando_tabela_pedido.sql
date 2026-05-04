create type status_enum as enum ('aprovado','pendente','cancelado');


alter table pedidos
alter column status type status_enum
using status ::status_enum;
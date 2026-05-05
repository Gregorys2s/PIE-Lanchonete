create type status_enum as enum ('PENDENTE','PAGO','CANCELADO');

alter table pedidos
alter column status drop default;

alter table pedidos
alter column status type status_enum
using (
      case
        when status = true then 'PAGO'::status_enum
        when status = false then 'PENDENTE'::status_enum
      end
);

      alter table pedidos
      alter column status set default 'PENDENTE';
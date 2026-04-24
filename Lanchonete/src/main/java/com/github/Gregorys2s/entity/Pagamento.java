package com.github.Gregorys2s.entity;

import jakarta.persistence.*;
import com.github.Gregorys2s.dto.PagamentoDto;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @


}

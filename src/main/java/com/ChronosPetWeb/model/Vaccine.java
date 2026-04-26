package com.ChronosPetWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "vaccine")
class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatorio")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @NotNull(message = "Intervalos de doses sao obrigatorios")
    @Size(min = 1, message = "Precisa de no minimo 1 dose")
    @Column(name = "doseIntervalDays")
    private Integer doseIntervalDays;
}

package com.ChronosPetWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDoseIntervalDays() {
        return doseIntervalDays;
    }

    public void setDoseIntervalDays(Integer doseIntervalDays) {
        this.doseIntervalDays = doseIntervalDays;
    }
}

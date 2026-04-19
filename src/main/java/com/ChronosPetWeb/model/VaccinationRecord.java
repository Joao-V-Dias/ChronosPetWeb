package com.ChronosPetWeb.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vaccination_record")
class VaccinationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    private Vaccine vaccine;

    @Column(name = "application_date")
    private LocalDate applicationDate;

    @Column(name = "next_dose_date")
    private LocalDate nextDoseDate;

    @Column(name = "status")
    private Boolean status;

    public Vaccine getVaccine() {
        return vaccine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public LocalDate getNextDoseDate() {
        return nextDoseDate;
    }

    public void setNextDoseDate(LocalDate nextDoseDate) {
        this.nextDoseDate = nextDoseDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
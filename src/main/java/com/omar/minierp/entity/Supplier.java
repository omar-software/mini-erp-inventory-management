package com.omar.minierp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name des Lieferanten, z.B. Tech Supplier GmbH
    @NotBlank(message = "Lieferantenname darf nicht leer sein")
    @Column(nullable = false)
    private String name;

    // Ansprechpartner beim Lieferanten
    private String contactPerson;

    // E-Mail-Adresse des Lieferanten
    @Email(message = "E-Mail-Adresse ist nicht gültig")
    private String email;

    // Telefonnummer des Lieferanten
    private String phone;

    // Stadt des Lieferanten
    private String city;

    // Datum der Erstellung
    private LocalDateTime createdAt;

    // Datum der letzten Änderung
    private LocalDateTime updatedAt;

    public Supplier() {
    }

    public Supplier(String name, String contactPerson, String email, String phone, String city) {
        this.name = name;
        this.contactPerson = contactPerson;
        this.email = email;
        this.phone = phone;
        this.city = city;
    }

    @PrePersist
    public void onCreate() {
        // Wird automatisch beim ersten Speichern gesetzt
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        // Wird automatisch beim Aktualisieren gesetzt
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
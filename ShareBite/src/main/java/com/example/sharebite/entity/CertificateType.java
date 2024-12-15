package com.example.sharebite.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "certificate_types")
public class CertificateType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer certificateTypeId;

    @Column(name = "name", nullable = false, unique = true, length = 80)
    private String name;

    @OneToMany(mappedBy = "certificateType", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Certificate> certificates;

    // Default Constructor
    public CertificateType() {
    }

    // All-args Constructor
    public CertificateType(Integer certificateTypeId, String name, List<Certificate> certificates) {
        this.certificateTypeId = certificateTypeId;
        this.name = name;
        this.certificates = certificates;
    }

    // Getters and Setters
    public Integer getCertificateTypeId() {
        return certificateTypeId;
    }

    public void setCertificateTypeId(Integer certificateTypeId) {
        this.certificateTypeId = certificateTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}

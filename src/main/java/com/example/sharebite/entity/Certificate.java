package com.example.sharebite.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "certificates")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer certificateId;

    @Column(name = "certificate_path", nullable = false, unique = true, length = 255)
    private String certificatePath;

    @ManyToOne
    @JoinColumn(name = "certificate_type_id", nullable = false)
    @JsonBackReference
    private CertificateType certificateType;

    // Default Constructor
    public Certificate() {
    }

    // All-args Constructor
    public Certificate(Integer certificateId, String certificatePath, CertificateType certificateType) {
        this.certificateId = certificateId;
        this.certificatePath = certificatePath;
        this.certificateType = certificateType;
    }

    // Getters and Setters
    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificatePath() {
        return certificatePath;
    }

    public void setCertificatePath(String certificatePath) {
        this.certificatePath = certificatePath;
    }

    public CertificateType getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(CertificateType certificateType) {
        this.certificateType = certificateType;
    }
}

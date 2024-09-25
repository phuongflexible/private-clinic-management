/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Linh
 */
@Entity
@Table(name = "prescription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescription.findAll", query = "SELECT p FROM Prescription p"),
    @NamedQuery(name = "Prescription.findById", query = "SELECT p FROM Prescription p WHERE p.id = :id"),
    @NamedQuery(name = "Prescription.findBySymptoms", query = "SELECT p FROM Prescription p WHERE p.symptoms = :symptoms"),
    @NamedQuery(name = "Prescription.findByDiagnosis", query = "SELECT p FROM Prescription p WHERE p.diagnosis = :diagnosis"),
    @NamedQuery(name = "Prescription.findByNote", query = "SELECT p FROM Prescription p WHERE p.note = :note"),
    @NamedQuery(name = "Prescription.findByCreatedDate", query = "SELECT p FROM Prescription p WHERE p.createdDate = :createdDate")})
public class Prescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "symptoms")
    private String symptoms;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "diagnosis")
    private String diagnosis;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prescriptionId")
    private Set<MedicinesInPrescription> medicinesInPrescriptionSet;
    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Appointment appointmentId;

    public Prescription() {
    }

    public Prescription(Integer id) {
        this.id = id;
    }

    public Prescription(Integer id, String symptoms, String diagnosis, Date createdDate) {
        this.id = id;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlTransient
    public Set<MedicinesInPrescription> getMedicinesInPrescriptionSet() {
        return medicinesInPrescriptionSet;
    }

    public void setMedicinesInPrescriptionSet(Set<MedicinesInPrescription> medicinesInPrescriptionSet) {
        this.medicinesInPrescriptionSet = medicinesInPrescriptionSet;
    }

    public Appointment getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Appointment appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescription)) {
            return false;
        }
        Prescription other = (Prescription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pthtw.pojo.Prescription[ id=" + id + " ]";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Linh
 */
@Entity
@Table(name = "medicines_in_prescription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicinesInPrescription.findAll", query = "SELECT m FROM MedicinesInPrescription m"),
    @NamedQuery(name = "MedicinesInPrescription.findById", query = "SELECT m FROM MedicinesInPrescription m WHERE m.id = :id"),
    @NamedQuery(name = "MedicinesInPrescription.findByQuantity", query = "SELECT m FROM MedicinesInPrescription m WHERE m.quantity = :quantity"),
    @NamedQuery(name = "MedicinesInPrescription.findByDosage", query = "SELECT m FROM MedicinesInPrescription m WHERE m.dosage = :dosage"),
    @NamedQuery(name = "MedicinesInPrescription.findByNote", query = "SELECT m FROM MedicinesInPrescription m WHERE m.note = :note")})
public class MedicinesInPrescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @Size(max = 255)
    @Column(name = "dosage")
    private String dosage;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Medicine medicineId;
    @JoinColumn(name = "prescription_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Prescription prescriptionId;

    public MedicinesInPrescription() {
    }

    public MedicinesInPrescription(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Medicine getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Medicine medicineId) {
        this.medicineId = medicineId;
    }

    public Prescription getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Prescription prescriptionId) {
        this.prescriptionId = prescriptionId;
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
        if (!(object instanceof MedicinesInPrescription)) {
            return false;
        }
        MedicinesInPrescription other = (MedicinesInPrescription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pthtw.pojo.MedicinesInPrescription[ id=" + id + " ]";
    }
    
}

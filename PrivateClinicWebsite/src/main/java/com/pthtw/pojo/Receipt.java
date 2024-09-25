/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Linh
 */
@Entity
@Table(name = "receipt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receipt.findAll", query = "SELECT r FROM Receipt r"),
    @NamedQuery(name = "Receipt.findById", query = "SELECT r FROM Receipt r WHERE r.id = :id"),
    @NamedQuery(name = "Receipt.findByMedicalCost", query = "SELECT r FROM Receipt r WHERE r.medicalCost = :medicalCost"),
    @NamedQuery(name = "Receipt.findByMedicineCost", query = "SELECT r FROM Receipt r WHERE r.medicineCost = :medicineCost"),
    @NamedQuery(name = "Receipt.findByPaymentTime", query = "SELECT r FROM Receipt r WHERE r.paymentTime = :paymentTime")})
public class Receipt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "medical_cost")
    private Double medicalCost;
    @Column(name = "medicine_cost")
    private Double medicineCost;
    @Column(name = "payment_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentTime;
    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Appointment appointmentId;
    @JoinColumn(name = "nurse_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nurse nurseId;
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id")
    @ManyToOne
    private PaymentMethod paymentMethodId;

    public Receipt() {
    }

    public Receipt(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMedicalCost() {
        return medicalCost;
    }

    public void setMedicalCost(Double medicalCost) {
        this.medicalCost = medicalCost;
    }

    public Double getMedicineCost() {
        return medicineCost;
    }

    public void setMedicineCost(Double medicineCost) {
        this.medicineCost = medicineCost;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Appointment getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Appointment appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Nurse getNurseId() {
        return nurseId;
    }

    public void setNurseId(Nurse nurseId) {
        this.nurseId = nurseId;
    }

    public PaymentMethod getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(PaymentMethod paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
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
        if (!(object instanceof Receipt)) {
            return false;
        }
        Receipt other = (Receipt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pthtw.pojo.Receipt[ id=" + id + " ]";
    }
    
}

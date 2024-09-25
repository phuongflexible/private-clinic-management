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
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findById", query = "SELECT s FROM Schedule s WHERE s.id = :id"),
    @NamedQuery(name = "Schedule.findByWorkDate", query = "SELECT s FROM Schedule s WHERE s.workDate = :workDate"),
    @NamedQuery(name = "Schedule.findByShift", query = "SELECT s FROM Schedule s WHERE s.shift = :shift"),
    @NamedQuery(name = "Schedule.findByNote", query = "SELECT s FROM Schedule s WHERE s.note = :note")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "work_date")
    @Temporal(TemporalType.DATE)
    private Date workDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "shift")
    private String shift;
    @Size(max = 100)
    @Column(name = "note")
    private String note;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduleId")
    private Set<ScheduleDoctor> scheduleDoctorSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduleId")
    private Set<ScheduleNurse> scheduleNurseSet;
    

    public Schedule() {
    }

    public Schedule(Integer id) {
        this.id = id;
    }

    public Schedule(Integer id, Date workDate, String shift) {
        this.id = id;
        this.workDate = workDate;
        this.shift = shift;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @XmlTransient
    public Set<ScheduleDoctor> getScheduleDoctorSet() {
        return scheduleDoctorSet;
    }

    public void setScheduleDoctorSet(Set<ScheduleDoctor> scheduleDoctorSet) {
        this.scheduleDoctorSet = scheduleDoctorSet;
    }

    @XmlTransient
    public Set<ScheduleNurse> getScheduleNurseSet() {
        return scheduleNurseSet;
    }

    public void setScheduleNurseSet(Set<ScheduleNurse> scheduleNurseSet) {
        this.scheduleNurseSet = scheduleNurseSet;
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
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pthtw.pojo.Schedule[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
 * @author os_hoangpn
 */
@Entity
@Table(name = "employee_workschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeWorkschedule.findAll", query = "SELECT e FROM EmployeeWorkschedule e"),
    @NamedQuery(name = "EmployeeWorkschedule.findById", query = "SELECT e FROM EmployeeWorkschedule e WHERE e.id = :id"),
    @NamedQuery(name = "EmployeeWorkschedule.findByShift", query = "SELECT e FROM EmployeeWorkschedule e WHERE e.shift = :shift"),
    @NamedQuery(name = "EmployeeWorkschedule.findByDate", query = "SELECT e FROM EmployeeWorkschedule e WHERE e.date = :date")})
public class EmployeeWorkschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Shift")
    private String shift;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "EmployeePersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Employee employeePersonID;
    @JoinColumn(name = "WorkScheduleID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Workschedule workScheduleID;

    public EmployeeWorkschedule() {
    }

    public EmployeeWorkschedule(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployeePersonID() {
        return employeePersonID;
    }

    public void setEmployeePersonID(Employee employeePersonID) {
        this.employeePersonID = employeePersonID;
    }

    public Workschedule getWorkScheduleID() {
        return workScheduleID;
    }

    public void setWorkScheduleID(Workschedule workScheduleID) {
        this.workScheduleID = workScheduleID;
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
        if (!(object instanceof EmployeeWorkschedule)) {
            return false;
        }
        EmployeeWorkschedule other = (EmployeeWorkschedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EmployeeWorkschedule[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author os_hoangpn
 */
@Entity
@Table(name = "workschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workschedule.findAll", query = "SELECT w FROM Workschedule w"),
    @NamedQuery(name = "Workschedule.findById", query = "SELECT w FROM Workschedule w WHERE w.id = :id"),
    @NamedQuery(name = "Workschedule.findByMonth", query = "SELECT w FROM Workschedule w WHERE w.month = :month"),
    @NamedQuery(name = "Workschedule.findByYear", query = "SELECT w FROM Workschedule w WHERE w.year = :year"),
    @NamedQuery(name = "Workschedule.findByEmployeeWorkSchedules", query = "SELECT w FROM Workschedule w WHERE w.employeeWorkSchedules = :employeeWorkSchedules")})
public class Workschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Month")
    private String month;
    @Column(name = "Year")
    private String year;
    @Column(name = "Employee_WorkSchedules")
    private Integer employeeWorkSchedules;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workScheduleID")
    private List<EmployeeWorkschedule> employeeWorkscheduleList;

    public Workschedule() {
    }

    public Workschedule(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getEmployeeWorkSchedules() {
        return employeeWorkSchedules;
    }

    public void setEmployeeWorkSchedules(Integer employeeWorkSchedules) {
        this.employeeWorkSchedules = employeeWorkSchedules;
    }

    @XmlTransient
    public List<EmployeeWorkschedule> getEmployeeWorkscheduleList() {
        return employeeWorkscheduleList;
    }

    public void setEmployeeWorkscheduleList(List<EmployeeWorkschedule> employeeWorkscheduleList) {
        this.employeeWorkscheduleList = employeeWorkscheduleList;
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
        if (!(object instanceof Workschedule)) {
            return false;
        }
        Workschedule other = (Workschedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Workschedule[ id=" + id + " ]";
    }
    
}

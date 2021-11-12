/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author os_hoangpn
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByPosition", query = "SELECT e FROM Employee e WHERE e.position = :position"),
    @NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM Employee e WHERE e.salary = :salary"),
    @NamedQuery(name = "Employee.findByStartDate", query = "SELECT e FROM Employee e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "Employee.findByPersonID", query = "SELECT e FROM Employee e WHERE e.personID = :personID")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "Position")
    private String position;
    @Column(name = "Salary")
    private BigInteger salary;
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Id
    @Basic(optional = false)
    @Column(name = "PersonID")
    private Integer personID;
    @JoinColumn(name = "BranchStoreID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Branchstore branchStoreID;
    @JoinColumn(name = "PersonID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeePersonID")
    private List<EmployeeWorkschedule> employeeWorkscheduleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeePersonID")
    private List<Allowance> allowanceList;

    public Employee() {
    }

    public Employee(Integer personID) {
        this.personID = personID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public Branchstore getBranchStoreID() {
        return branchStoreID;
    }

    public void setBranchStoreID(Branchstore branchStoreID) {
        this.branchStoreID = branchStoreID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @XmlTransient
    public List<EmployeeWorkschedule> getEmployeeWorkscheduleList() {
        return employeeWorkscheduleList;
    }

    public void setEmployeeWorkscheduleList(List<EmployeeWorkschedule> employeeWorkscheduleList) {
        this.employeeWorkscheduleList = employeeWorkscheduleList;
    }

    @XmlTransient
    public List<Allowance> getAllowanceList() {
        return allowanceList;
    }

    public void setAllowanceList(List<Allowance> allowanceList) {
        this.allowanceList = allowanceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personID != null ? personID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Employee[ personID=" + personID + " ]";
    }
    
}

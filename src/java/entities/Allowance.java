/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author os_hoangpn
 */
@Entity
@Table(name = "allowance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Allowance.findAll", query = "SELECT a FROM Allowance a"),
    @NamedQuery(name = "Allowance.findById", query = "SELECT a FROM Allowance a WHERE a.id = :id"),
    @NamedQuery(name = "Allowance.findByName", query = "SELECT a FROM Allowance a WHERE a.name = :name"),
    @NamedQuery(name = "Allowance.findByAmount", query = "SELECT a FROM Allowance a WHERE a.amount = :amount"),
    @NamedQuery(name = "Allowance.findByDescription", query = "SELECT a FROM Allowance a WHERE a.description = :description")})
public class Allowance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Amount")
    private BigInteger amount;
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "EmployeePersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Employee employeePersonID;

    public Allowance() {
    }

    public Allowance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployeePersonID() {
        return employeePersonID;
    }

    public void setEmployeePersonID(Employee employeePersonID) {
        this.employeePersonID = employeePersonID;
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
        if (!(object instanceof Allowance)) {
            return false;
        }
        Allowance other = (Allowance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Allowance[ id=" + id + " ]";
    }
    
}

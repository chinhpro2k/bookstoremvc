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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "branchstore")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branchstore.findAll", query = "SELECT b FROM Branchstore b"),
    @NamedQuery(name = "Branchstore.findById", query = "SELECT b FROM Branchstore b WHERE b.id = :id"),
    @NamedQuery(name = "Branchstore.findByName", query = "SELECT b FROM Branchstore b WHERE b.name = :name"),
    @NamedQuery(name = "Branchstore.findByDescription", query = "SELECT b FROM Branchstore b WHERE b.description = :description")})
public class Branchstore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "AddressID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Address addressID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchStoreID")
    private List<Employee> employeeList;

    public Branchstore() {
    }

    public Branchstore(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddressID() {
        return addressID;
    }

    public void setAddressID(Address addressID) {
        this.addressID = addressID;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
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
        if (!(object instanceof Branchstore)) {
            return false;
        }
        Branchstore other = (Branchstore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Branchstore[ id=" + id + " ]";
    }
    
}

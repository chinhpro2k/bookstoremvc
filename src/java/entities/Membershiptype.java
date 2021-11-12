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
@Table(name = "membershiptype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membershiptype.findAll", query = "SELECT m FROM Membershiptype m"),
    @NamedQuery(name = "Membershiptype.findById", query = "SELECT m FROM Membershiptype m WHERE m.id = :id"),
    @NamedQuery(name = "Membershiptype.findByName", query = "SELECT m FROM Membershiptype m WHERE m.name = :name"),
    @NamedQuery(name = "Membershiptype.findByDescription", query = "SELECT m FROM Membershiptype m WHERE m.description = :description"),
    @NamedQuery(name = "Membershiptype.findByCondition", query = "SELECT m FROM Membershiptype m WHERE m.condition = :condition")})
public class Membershiptype implements Serializable {

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
    @Column(name = "Condition")
    private String condition;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membershipTypeID")
    private List<Customer> customerList;

    public Membershiptype() {
    }

    public Membershiptype(Integer id) {
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
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
        if (!(object instanceof Membershiptype)) {
            return false;
        }
        Membershiptype other = (Membershiptype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Membershiptype[ id=" + id + " ]";
    }
    
}

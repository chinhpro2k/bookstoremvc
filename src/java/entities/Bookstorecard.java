/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "bookstorecard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookstorecard.findAll", query = "SELECT b FROM Bookstorecard b"),
    @NamedQuery(name = "Bookstorecard.findById", query = "SELECT b FROM Bookstorecard b WHERE b.id = :id"),
    @NamedQuery(name = "Bookstorecard.findByPoint", query = "SELECT b FROM Bookstorecard b WHERE b.point = :point"),
    @NamedQuery(name = "Bookstorecard.findByUsedPoint", query = "SELECT b FROM Bookstorecard b WHERE b.usedPoint = :usedPoint")})
public class Bookstorecard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Point")
    private BigInteger point;
    @Column(name = "UsedPoint")
    private BigInteger usedPoint;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookStoreCardID")
    private List<Customer> customerList;

    public Bookstorecard() {
    }

    public Bookstorecard(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getPoint() {
        return point;
    }

    public void setPoint(BigInteger point) {
        this.point = point;
    }

    public BigInteger getUsedPoint() {
        return usedPoint;
    }

    public void setUsedPoint(BigInteger usedPoint) {
        this.usedPoint = usedPoint;
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
        if (!(object instanceof Bookstorecard)) {
            return false;
        }
        Bookstorecard other = (Bookstorecard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bookstorecard[ id=" + id + " ]";
    }
    
}

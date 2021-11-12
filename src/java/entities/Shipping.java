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
@Table(name = "shipping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shipping.findAll", query = "SELECT s FROM Shipping s"),
    @NamedQuery(name = "Shipping.findById", query = "SELECT s FROM Shipping s WHERE s.id = :id"),
    @NamedQuery(name = "Shipping.findByRegion", query = "SELECT s FROM Shipping s WHERE s.region = :region"),
    @NamedQuery(name = "Shipping.findByCost", query = "SELECT s FROM Shipping s WHERE s.cost = :cost"),
    @NamedQuery(name = "Shipping.findByDelayDate", query = "SELECT s FROM Shipping s WHERE s.delayDate = :delayDate")})
public class Shipping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Region")
    private String region;
    @Column(name = "Cost")
    private String cost;
    @Column(name = "DelayDate")
    private Integer delayDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shippingID")
    private List<Onlineorder> onlineorderList;

    public Shipping() {
    }

    public Shipping(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Integer getDelayDate() {
        return delayDate;
    }

    public void setDelayDate(Integer delayDate) {
        this.delayDate = delayDate;
    }

    @XmlTransient
    public List<Onlineorder> getOnlineorderList() {
        return onlineorderList;
    }

    public void setOnlineorderList(List<Onlineorder> onlineorderList) {
        this.onlineorderList = onlineorderList;
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
        if (!(object instanceof Shipping)) {
            return false;
        }
        Shipping other = (Shipping) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Shipping[ id=" + id + " ]";
    }
    
}

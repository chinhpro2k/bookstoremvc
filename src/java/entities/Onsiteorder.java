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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author os_hoangpn
 */
@Entity
@Table(name = "onsiteorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onsiteorder.findAll", query = "SELECT o FROM Onsiteorder o"),
    @NamedQuery(name = "Onsiteorder.findByOrderID", query = "SELECT o FROM Onsiteorder o WHERE o.orderID = :orderID")})
public class Onsiteorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "OrderID")
    private Integer orderID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "onSiteOrderOrderID")
    private List<Onlinebill> onlinebillList;
    @JoinColumn(name = "OnSiteSellerPersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Onsiteseller onSiteSellerPersonID;
    @JoinColumn(name = "OrderID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Order1 order1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "onSiteOrderOrderID")
    private List<Onsitebill> onsitebillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "onSiteOrderOrderID")
    private List<Orderline> orderlineList;

    public Onsiteorder() {
    }

    public Onsiteorder(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    @XmlTransient
    public List<Onlinebill> getOnlinebillList() {
        return onlinebillList;
    }

    public void setOnlinebillList(List<Onlinebill> onlinebillList) {
        this.onlinebillList = onlinebillList;
    }

    public Onsiteseller getOnSiteSellerPersonID() {
        return onSiteSellerPersonID;
    }

    public void setOnSiteSellerPersonID(Onsiteseller onSiteSellerPersonID) {
        this.onSiteSellerPersonID = onSiteSellerPersonID;
    }

    public Order1 getOrder1() {
        return order1;
    }

    public void setOrder1(Order1 order1) {
        this.order1 = order1;
    }

    @XmlTransient
    public List<Onsitebill> getOnsitebillList() {
        return onsitebillList;
    }

    public void setOnsitebillList(List<Onsitebill> onsitebillList) {
        this.onsitebillList = onsitebillList;
    }

    @XmlTransient
    public List<Orderline> getOrderlineList() {
        return orderlineList;
    }

    public void setOrderlineList(List<Orderline> orderlineList) {
        this.orderlineList = orderlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Onsiteorder)) {
            return false;
        }
        Onsiteorder other = (Onsiteorder) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Onsiteorder[ orderID=" + orderID + " ]";
    }
    
}

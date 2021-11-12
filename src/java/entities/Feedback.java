/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
@Table(name = "feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f"),
    @NamedQuery(name = "Feedback.findById", query = "SELECT f FROM Feedback f WHERE f.id = :id"),
    @NamedQuery(name = "Feedback.findByContent", query = "SELECT f FROM Feedback f WHERE f.content = :content"),
    @NamedQuery(name = "Feedback.findByRate", query = "SELECT f FROM Feedback f WHERE f.rate = :rate"),
    @NamedQuery(name = "Feedback.findByCustomerName", query = "SELECT f FROM Feedback f WHERE f.customerName = :customerName")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Content")
    private String content;
    @Column(name = "Rate")
    private Integer rate;
    @Basic(optional = false)
    @Column(name = "CustomerName")
    private String customerName;
    @JoinColumn(name = "CustomerPersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Customer customerPersonID;
    @JoinColumn(name = "ItemID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Item itemID;

    public Feedback() {
    }

    public Feedback(Integer id) {
        this.id = id;
    }

    public Feedback(Integer id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Customer getCustomerPersonID() {
        return customerPersonID;
    }

    public void setCustomerPersonID(Customer customerPersonID) {
        this.customerPersonID = customerPersonID;
    }

    public Item getItemID() {
        return itemID;
    }

    public void setItemID(Item itemID) {
        this.itemID = itemID;
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
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Feedback[ id=" + id + " ]";
    }
    
}

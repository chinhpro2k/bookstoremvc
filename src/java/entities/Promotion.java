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
@Table(name = "promotion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p"),
    @NamedQuery(name = "Promotion.findById", query = "SELECT p FROM Promotion p WHERE p.id = :id"),
    @NamedQuery(name = "Promotion.findByName", query = "SELECT p FROM Promotion p WHERE p.name = :name"),
    @NamedQuery(name = "Promotion.findByPercent", query = "SELECT p FROM Promotion p WHERE p.percent = :percent"),
    @NamedQuery(name = "Promotion.findByExpiredDate", query = "SELECT p FROM Promotion p WHERE p.expiredDate = :expiredDate")})
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Percent")
    private Double percent;
    @Column(name = "ExpiredDate")
    private Integer expiredDate;
    @JoinColumn(name = "ItemID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Item itemID;

    public Promotion() {
    }

    public Promotion(Integer id) {
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

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Integer getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Integer expiredDate) {
        this.expiredDate = expiredDate;
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
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Promotion[ id=" + id + " ]";
    }
    
}

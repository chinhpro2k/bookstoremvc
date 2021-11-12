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
@Table(name = "orderline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderline.findAll", query = "SELECT o FROM Orderline o"),
    @NamedQuery(name = "Orderline.findById", query = "SELECT o FROM Orderline o WHERE o.id = :id"),
    @NamedQuery(name = "Orderline.findByQuantity", query = "SELECT o FROM Orderline o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "Orderline.findByCutomerID", query = "SELECT o FROM Orderline o WHERE o.cutomerID = :cutomerID")})
public class Orderline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Quantity")
    private Integer quantity;
    @Column(name = "CutomerID")
    private Integer cutomerID;
    @JoinColumn(name = "ItemID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Item itemID;
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    @ManyToOne(optional = false)
    private Onlineorder orderID;

    public Orderline() {
    }

    public Orderline(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCutomerID() {
        return cutomerID;
    }

    public void setCutomerID(Integer cutomerID) {
        this.cutomerID = cutomerID;
    }

    public Item getItemID() {
        return itemID;
    }

    public void setItemID(Item itemID) {
        this.itemID = itemID;
    }

    public Onlineorder getOrderID() {
        return orderID;
    }

    public void setOrderID(Onlineorder orderID) {
        this.orderID = orderID;
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
        if (!(object instanceof Orderline)) {
            return false;
        }
        Orderline other = (Orderline) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Orderline{" + "id=" + id + ", quantity=" + quantity + ", cutomerID=" + cutomerID + ", itemID=" + itemID + ", orderID=" + orderID + '}';
    }


    
}

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
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"),
    @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"),
    @NamedQuery(name = "Item.findBySalePrice", query = "SELECT i FROM Item i WHERE i.salePrice = :salePrice"),
    @NamedQuery(name = "Item.findByDescription", query = "SELECT i FROM Item i WHERE i.description = :description"),
    @NamedQuery(name = "Item.findByPromotions", query = "SELECT i FROM Item i WHERE i.promotions = :promotions"),
    @NamedQuery(name = "Item.findByFeedbacks", query = "SELECT i FROM Item i WHERE i.feedbacks = :feedbacks"),
    @NamedQuery(name = "Item.findByBooks", query = "SELECT i FROM Item i WHERE i.books = :books"),
    @NamedQuery(name = "Item.findByUrl", query = "SELECT i FROM Item i WHERE i.url = :url")})
public class Item implements Serializable {

    @OneToMany(mappedBy = "itemID")
    private List<Cart> cartList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemID")
    private List<Orderline> orderlineList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "SalePrice")
    private BigInteger salePrice;
    @Column(name = "Description")
    private String description;
    @Column(name = "Promotions")
    private Integer promotions;
    @Column(name = "Feedbacks")
    private Integer feedbacks;
    @Column(name = "Books")
    private Integer books;
    @Column(name = "Url")
    private String url;

    public Item() {
    }

    public Item(Integer id) {
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

    public BigInteger getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigInteger salePrice) {
        this.salePrice = salePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPromotions() {
        return promotions;
    }

    public void setPromotions(Integer promotions) {
        this.promotions = promotions;
    }

    public Integer getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Integer feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Integer getBooks() {
        return books;
    }

    public void setBooks(Integer books) {
        this.books = books;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Item[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    @XmlTransient
    public List<Orderline> getOrderlineList() {
        return orderlineList;
    }

    public void setOrderlineList(List<Orderline> orderlineList) {
        this.orderlineList = orderlineList;
    }
    
}

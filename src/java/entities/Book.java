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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id"),
    @NamedQuery(name = "Book.findByName", query = "SELECT b FROM Book b WHERE b.name = :name"),
    @NamedQuery(name = "Book.findByPublishYear", query = "SELECT b FROM Book b WHERE b.publishYear = :publishYear"),
    @NamedQuery(name = "Book.findByQuantity", query = "SELECT b FROM Book b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "Book.findByPurchasePrice", query = "SELECT b FROM Book b WHERE b.purchasePrice = :purchasePrice"),
    @NamedQuery(name = "Book.findByCategories", query = "SELECT b FROM Book b WHERE b.categories = :categories")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "PublishYear")
    private String publishYear;
    @Column(name = "Quantity")
    private Integer quantity;
    @Column(name = "PurchasePrice")
    private BigInteger purchasePrice;
    @Basic(optional = false)
    @Column(name = "Categories")
    private int categories;
    @ManyToMany(mappedBy = "bookList")
    private List<Item> itemList;
    @ManyToMany(mappedBy = "bookList")
    private List<Category> categoryList;
    @JoinTable(name = "wishlist_book", joinColumns = {
        @JoinColumn(name = "BookID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "WishlistID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Wishlist> wishlistList;
    @JoinColumn(name = "AuthorID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Author authorID;
    @JoinColumn(name = "PublisherID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Publisher publisherID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookID")
    private List<Importingrecord> importingrecordList;

    public Book() {
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Book(Integer id, int categories) {
        this.id = id;
        this.categories = categories;
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

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigInteger getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigInteger purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getCategories() {
        return categories;
    }

    public void setCategories(int categories) {
        this.categories = categories;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @XmlTransient
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @XmlTransient
    public List<Wishlist> getWishlistList() {
        return wishlistList;
    }

    public void setWishlistList(List<Wishlist> wishlistList) {
        this.wishlistList = wishlistList;
    }

    public Author getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Author authorID) {
        this.authorID = authorID;
    }

    public Publisher getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(Publisher publisherID) {
        this.publisherID = publisherID;
    }

    @XmlTransient
    public List<Importingrecord> getImportingrecordList() {
        return importingrecordList;
    }

    public void setImportingrecordList(List<Importingrecord> importingrecordList) {
        this.importingrecordList = importingrecordList;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Book[ id=" + id + " ]";
    }
    
}

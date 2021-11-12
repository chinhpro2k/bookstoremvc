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
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByPersonID", query = "SELECT c FROM Customer c WHERE c.personID = :personID")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PersonID")
    private Integer personID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerPersonID")
    private List<Feedback> feedbackList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerPersonID")
    private List<Notification> notificationList;
    @JoinColumn(name = "BookStoreCardID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Bookstorecard bookStoreCardID;
    @JoinColumn(name = "CartID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cart cartID;
    @JoinColumn(name = "MembershipTypeID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Membershiptype membershipTypeID;
    @JoinColumn(name = "PersonID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;
    @JoinColumn(name = "WishlistID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Wishlist wishlistID;

    public Customer() {
    }

    public Customer(Integer personID) {
        this.personID = personID;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    @XmlTransient
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    @XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    public Bookstorecard getBookStoreCardID() {
        return bookStoreCardID;
    }

    public void setBookStoreCardID(Bookstorecard bookStoreCardID) {
        this.bookStoreCardID = bookStoreCardID;
    }

    public Cart getCartID() {
        return cartID;
    }

    public void setCartID(Cart cartID) {
        this.cartID = cartID;
    }

    public Membershiptype getMembershipTypeID() {
        return membershipTypeID;
    }

    public void setMembershipTypeID(Membershiptype membershipTypeID) {
        this.membershipTypeID = membershipTypeID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Wishlist getWishlistID() {
        return wishlistID;
    }

    public void setWishlistID(Wishlist wishlistID) {
        this.wishlistID = wishlistID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personID != null ? personID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Customer[ personID=" + personID + " ]";
    }
    
}

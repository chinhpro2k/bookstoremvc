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
import javax.persistence.JoinColumn;
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
@Table(name = "shippingaddress")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shippingaddress.findAll", query = "SELECT s FROM Shippingaddress s"),
    @NamedQuery(name = "Shippingaddress.findById", query = "SELECT s FROM Shippingaddress s WHERE s.id = :id"),
    @NamedQuery(name = "Shippingaddress.findByNote", query = "SELECT s FROM Shippingaddress s WHERE s.note = :note")})
public class Shippingaddress implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shippingAddressID")
    private List<Onlineorder> onlineorderList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Note")
    private String note;
    @JoinColumn(name = "addressID", referencedColumnName = "ID")
    @ManyToOne
    private Address addressID;

    public Shippingaddress() {
    }

    public Shippingaddress(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Address getAddressID() {
        return addressID;
    }

    public void setAddressID(Address addressID) {
        this.addressID = addressID;
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
        if (!(object instanceof Shippingaddress)) {
            return false;
        }
        Shippingaddress other = (Shippingaddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Shippingaddress{" + "onlineorderList=" + onlineorderList + ", id=" + id + ", note=" + note + ", addressID=" + addressID + '}';
    }



    @XmlTransient
    public List<Onlineorder> getOnlineorderList() {
        return onlineorderList;
    }

    public void setOnlineorderList(List<Onlineorder> onlineorderList) {
        this.onlineorderList = onlineorderList;
    }
    
}

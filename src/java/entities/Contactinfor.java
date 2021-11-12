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
@Table(name = "contactinfor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactinfor.findAll", query = "SELECT c FROM Contactinfor c"),
    @NamedQuery(name = "Contactinfor.findById", query = "SELECT c FROM Contactinfor c WHERE c.id = :id"),
    @NamedQuery(name = "Contactinfor.findByPhoneNumber", query = "SELECT c FROM Contactinfor c WHERE c.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Contactinfor.findByEmail", query = "SELECT c FROM Contactinfor c WHERE c.email = :email")})
public class Contactinfor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "Email")
    private String email;
    @JoinColumn(name = "AddressID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Address addressID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactInforID")
    private List<Person> personList;

    public Contactinfor() {
    }

    public Contactinfor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddressID() {
        return addressID;
    }

    public void setAddressID(Address addressID) {
        this.addressID = addressID;
    }

    @XmlTransient
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
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
        if (!(object instanceof Contactinfor)) {
            return false;
        }
        Contactinfor other = (Contactinfor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Contactinfor[ id=" + id + " ]";
    }
    
}

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
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id"),
    @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
    @NamedQuery(name = "Address.findByDistrict", query = "SELECT a FROM Address a WHERE a.district = :district"),
    @NamedQuery(name = "Address.findByTown", query = "SELECT a FROM Address a WHERE a.town = :town"),
    @NamedQuery(name = "Address.findByDescription", query = "SELECT a FROM Address a WHERE a.description = :description")})
public class Address implements Serializable {

    @OneToMany(mappedBy = "addressID")
    private List<Shippingaddress> shippingaddressList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "City")
    private String city;
    @Column(name = "District")
    private String district;
    @Column(name = "Town")
    private String town;
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressID")
    private List<Branchstore> branchstoreList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressID")
    private List<Contactinfor> contactinforList;

    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Branchstore> getBranchstoreList() {
        return branchstoreList;
    }

    public void setBranchstoreList(List<Branchstore> branchstoreList) {
        this.branchstoreList = branchstoreList;
    }

    @XmlTransient
    public List<Contactinfor> getContactinforList() {
        return contactinforList;
    }

    public void setContactinforList(List<Contactinfor> contactinforList) {
        this.contactinforList = contactinforList;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Address{" + "shippingaddressList=" + shippingaddressList + ", id=" + id + ", city=" + city + ", district=" + district + ", town=" + town + ", description=" + description + ", branchstoreList=" + branchstoreList + ", contactinforList=" + contactinforList + '}';
    }


    @XmlTransient
    public List<Shippingaddress> getShippingaddressList() {
        return shippingaddressList;
    }

    public void setShippingaddressList(List<Shippingaddress> shippingaddressList) {
        this.shippingaddressList = shippingaddressList;
    }
    
}

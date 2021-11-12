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
@Table(name = "onsiteseller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onsiteseller.findAll", query = "SELECT o FROM Onsiteseller o"),
    @NamedQuery(name = "Onsiteseller.findByPersonID", query = "SELECT o FROM Onsiteseller o WHERE o.personID = :personID")})
public class Onsiteseller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PersonID")
    private Integer personID;
    @JoinColumn(name = "PersonID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "onSiteSellerPersonID")
    private List<Onsiteorder> onsiteorderList;

    public Onsiteseller() {
    }

    public Onsiteseller(Integer personID) {
        this.personID = personID;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @XmlTransient
    public List<Onsiteorder> getOnsiteorderList() {
        return onsiteorderList;
    }

    public void setOnsiteorderList(List<Onsiteorder> onsiteorderList) {
        this.onsiteorderList = onsiteorderList;
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
        if (!(object instanceof Onsiteseller)) {
            return false;
        }
        Onsiteseller other = (Onsiteseller) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Onsiteseller[ personID=" + personID + " ]";
    }
    
}

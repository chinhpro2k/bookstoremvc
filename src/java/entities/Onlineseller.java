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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author os_hoangpn
 */
@Entity
@Table(name = "onlineseller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onlineseller.findAll", query = "SELECT o FROM Onlineseller o"),
    @NamedQuery(name = "Onlineseller.findByPersonID", query = "SELECT o FROM Onlineseller o WHERE o.personID = :personID")})
public class Onlineseller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PersonID")
    private Integer personID;
    @JoinColumn(name = "OnlineOrderOrderID", referencedColumnName = "OrderID")
    @ManyToOne(optional = false)
    private Onlineorder onlineOrderOrderID;
    @JoinColumn(name = "PersonID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Onlineseller() {
    }

    public Onlineseller(Integer personID) {
        this.personID = personID;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public Onlineorder getOnlineOrderOrderID() {
        return onlineOrderOrderID;
    }

    public void setOnlineOrderOrderID(Onlineorder onlineOrderOrderID) {
        this.onlineOrderOrderID = onlineOrderOrderID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        if (!(object instanceof Onlineseller)) {
            return false;
        }
        Onlineseller other = (Onlineseller) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Onlineseller[ personID=" + personID + " ]";
    }
    
}

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
@Table(name = "importingstaff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Importingstaff.findAll", query = "SELECT i FROM Importingstaff i"),
    @NamedQuery(name = "Importingstaff.findByPersonID", query = "SELECT i FROM Importingstaff i WHERE i.personID = :personID")})
public class Importingstaff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PersonID")
    private Integer personID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "importingStaffPersonID")
    private List<Importingrecord> importingrecordList;
    @JoinColumn(name = "PersonID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Importingstaff() {
    }

    public Importingstaff(Integer personID) {
        this.personID = personID;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    @XmlTransient
    public List<Importingrecord> getImportingrecordList() {
        return importingrecordList;
    }

    public void setImportingrecordList(List<Importingrecord> importingrecordList) {
        this.importingrecordList = importingrecordList;
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
        if (!(object instanceof Importingstaff)) {
            return false;
        }
        Importingstaff other = (Importingstaff) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Importingstaff[ personID=" + personID + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author os_hoangpn
 */
@Entity
@Table(name = "importingrecord")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Importingrecord.findAll", query = "SELECT i FROM Importingrecord i"),
    @NamedQuery(name = "Importingrecord.findById", query = "SELECT i FROM Importingrecord i WHERE i.id = :id"),
    @NamedQuery(name = "Importingrecord.findByDate", query = "SELECT i FROM Importingrecord i WHERE i.date = :date")})
public class Importingrecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "BookID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Book bookID;
    @JoinColumn(name = "ImportingStaffPersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Importingstaff importingStaffPersonID;
    @JoinColumn(name = "SupplierID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Supplier supplierID;

    public Importingrecord() {
    }

    public Importingrecord(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book getBookID() {
        return bookID;
    }

    public void setBookID(Book bookID) {
        this.bookID = bookID;
    }

    public Importingstaff getImportingStaffPersonID() {
        return importingStaffPersonID;
    }

    public void setImportingStaffPersonID(Importingstaff importingStaffPersonID) {
        this.importingStaffPersonID = importingStaffPersonID;
    }

    public Supplier getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Supplier supplierID) {
        this.supplierID = supplierID;
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
        if (!(object instanceof Importingrecord)) {
            return false;
        }
        Importingrecord other = (Importingrecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Importingrecord[ id=" + id + " ]";
    }
    
}

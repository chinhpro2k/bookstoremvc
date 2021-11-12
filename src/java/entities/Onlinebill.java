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
@Table(name = "onlinebill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onlinebill.findAll", query = "SELECT o FROM Onlinebill o"),
    @NamedQuery(name = "Onlinebill.findByPaymentState", query = "SELECT o FROM Onlinebill o WHERE o.paymentState = :paymentState"),
    @NamedQuery(name = "Onlinebill.findByBillID", query = "SELECT o FROM Onlinebill o WHERE o.billID = :billID")})
public class Onlinebill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "PaymentState")
    private String paymentState;
    @Id
    @Basic(optional = false)
    @Column(name = "BillID")
    private Integer billID;
    @JoinColumn(name = "BillID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Bill bill;
    @JoinColumn(name = "OnSiteOrderOrderID", referencedColumnName = "OrderID")
    @ManyToOne(optional = false)
    private Onsiteorder onSiteOrderOrderID;

    public Onlinebill() {
    }

    public Onlinebill(Integer billID) {
        this.billID = billID;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    public Integer getBillID() {
        return billID;
    }

    public void setBillID(Integer billID) {
        this.billID = billID;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Onsiteorder getOnSiteOrderOrderID() {
        return onSiteOrderOrderID;
    }

    public void setOnSiteOrderOrderID(Onsiteorder onSiteOrderOrderID) {
        this.onSiteOrderOrderID = onSiteOrderOrderID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billID != null ? billID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Onlinebill)) {
            return false;
        }
        Onlinebill other = (Onlinebill) object;
        if ((this.billID == null && other.billID != null) || (this.billID != null && !this.billID.equals(other.billID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Onlinebill[ billID=" + billID + " ]";
    }
    
}

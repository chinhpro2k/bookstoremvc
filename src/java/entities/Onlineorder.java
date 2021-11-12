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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author os_hoangpn
 */
@Entity
@Table(name = "onlineorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onlineorder.findAll", query = "SELECT o FROM Onlineorder o"),
    @NamedQuery(name = "Onlineorder.findByState", query = "SELECT o FROM Onlineorder o WHERE o.state = :state"),
    @NamedQuery(name = "Onlineorder.findByCustomerID", query = "SELECT o FROM Onlineorder o WHERE o.customerID = :customerID"),
    @NamedQuery(name = "Onlineorder.findByOrderID", query = "SELECT o FROM Onlineorder o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "Onlineorder.findByShippingID", query = "SELECT o FROM Onlineorder o WHERE o.shippingID = :shippingID"),
    @NamedQuery(name = "Onlineorder.findByPaymentmethod", query = "SELECT o FROM Onlineorder o WHERE o.paymentmethod = :paymentmethod")})
public class Onlineorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "State")
    private String state;
    @Basic(optional = false)
    @Column(name = "CustomerID")
    private int customerID;
    @Id
    @Basic(optional = false)
    @Column(name = "OrderID")
    private Integer orderID;
    @Column(name = "ShippingID")
    private Integer shippingID;
    @Column(name = "paymentmethod")
    private String paymentmethod;
    @JoinColumn(name = "ShippingAddressID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Shippingaddress shippingAddressID;
    @JoinColumn(name = "VoucherID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Voucher voucherID;

    public Onlineorder() {
    }

    public Onlineorder(Integer orderID) {
        this.orderID = orderID;
    }

    public Onlineorder(Integer orderID, int customerID) {
        this.orderID = orderID;
        this.customerID = customerID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getShippingID() {
        return shippingID;
    }

    public void setShippingID(Integer shippingID) {
        this.shippingID = shippingID;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public Shippingaddress getShippingAddressID() {
        return shippingAddressID;
    }

    public void setShippingAddressID(Shippingaddress shippingAddressID) {
        this.shippingAddressID = shippingAddressID;
    }

    public Voucher getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(Voucher voucherID) {
        this.voucherID = voucherID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Onlineorder)) {
            return false;
        }
        Onlineorder other = (Onlineorder) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Onlineorder{" + "state=" + state + ", customerID=" + customerID + ", orderID=" + orderID + ", shippingID=" + shippingID + ", paymentmethod=" + paymentmethod + ", shippingAddressID=" + shippingAddressID + ", voucherID=" + voucherID + '}';
    }


    
}

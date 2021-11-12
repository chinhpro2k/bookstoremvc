/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author os_hoangpn
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "Person.findByDateOfBirth", query = "SELECT p FROM Person p WHERE p.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Person.findByGender", query = "SELECT p FROM Person p WHERE p.gender = :gender"),
    @NamedQuery(name = "Person.findByIdCard", query = "SELECT p FROM Person p WHERE p.idCard = :idCard")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DateOfBirth")
    private String dateOfBirth;
    @Column(name = "Gender")
    private String gender;
    @Column(name = "IdCard")
    private String idCard;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Seller seller;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Employee employee;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Customercarestaff customercarestaff;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Onsiteseller onsiteseller;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Importingstaff importingstaff;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Manager manager;
    @JoinColumn(name = "AccountID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Account accountID;
    @JoinColumn(name = "ContactInforID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Contactinfor contactInforID;
    @JoinColumn(name = "FullNameID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Fullname fullNameID;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Onlineseller onlineseller;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Customer customer;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customercarestaff getCustomercarestaff() {
        return customercarestaff;
    }

    public void setCustomercarestaff(Customercarestaff customercarestaff) {
        this.customercarestaff = customercarestaff;
    }

    public Onsiteseller getOnsiteseller() {
        return onsiteseller;
    }

    public void setOnsiteseller(Onsiteseller onsiteseller) {
        this.onsiteseller = onsiteseller;
    }

    public Importingstaff getImportingstaff() {
        return importingstaff;
    }

    public void setImportingstaff(Importingstaff importingstaff) {
        this.importingstaff = importingstaff;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Account getAccountID() {
        return accountID;
    }

    public void setAccountID(Account accountID) {
        this.accountID = accountID;
    }

    public Contactinfor getContactInforID() {
        return contactInforID;
    }

    public void setContactInforID(Contactinfor contactInforID) {
        this.contactInforID = contactInforID;
    }

    public Fullname getFullNameID() {
        return fullNameID;
    }

    public void setFullNameID(Fullname fullNameID) {
        this.fullNameID = fullNameID;
    }

    public Onlineseller getOnlineseller() {
        return onlineseller;
    }

    public void setOnlineseller(Onlineseller onlineseller) {
        this.onlineseller = onlineseller;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", idCard=" + idCard + ", seller=" + seller + ", employee=" + employee + ", customercarestaff=" + customercarestaff + ", onsiteseller=" + onsiteseller + ", importingstaff=" + importingstaff + ", manager=" + manager + ", accountID=" + accountID + ", contactInforID=" + contactInforID + ", fullNameID=" + fullNameID + ", onlineseller=" + onlineseller + ", customer=" + customer + '}';
    }

    
    
}

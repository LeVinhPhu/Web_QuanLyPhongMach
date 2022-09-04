/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author phamt
 */
@Entity
@Table(name = "admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findById", query = "SELECT a FROM Admin a WHERE a.id = :id"),
    @NamedQuery(name = "Admin.findByFirstName", query = "SELECT a FROM Admin a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Admin.findByLastName", query = "SELECT a FROM Admin a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "Admin.findByDateOfBirth", query = "SELECT a FROM Admin a WHERE a.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Admin.findBySex", query = "SELECT a FROM Admin a WHERE a.sex = :sex"),
    @NamedQuery(name = "Admin.findByAddress", query = "SELECT a FROM Admin a WHERE a.address = :address"),
    @NamedQuery(name = "Admin.findByEmail", query = "SELECT a FROM Admin a WHERE a.email = :email"),
    @NamedQuery(name = "Admin.findByPhone", query = "SELECT a FROM Admin a WHERE a.phone = :phone"),
    @NamedQuery(name = "Admin.findByTypeOfAdmin", query = "SELECT a FROM Admin a WHERE a.typeOfAdmin = :typeOfAdmin"),
    @NamedQuery(name = "Admin.findByImage", query = "SELECT a FROM Admin a WHERE a.image = :image"),
    @NamedQuery(name = "Admin.findByUsername", query = "SELECT a FROM Admin a WHERE a.username = :username"),
    @NamedQuery(name = "Admin.findByPassword", query = "SELECT a FROM Admin a WHERE a.password = :password"),
    @NamedQuery(name = "Admin.findByNote", query = "SELECT a FROM Admin a WHERE a.note = :note")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    
    @Size(max = 45)
    @Column(name = "sex")
    private String sex;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type_of_admin")
    private String typeOfAdmin;
    @Size(max = 300)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Size(max = 200)
    @Column(name = "note")
    private String note;
    @OneToMany(mappedBy = "adminId")
    @JsonIgnore//
    private Collection<Admin> adminCollection;
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore //
    private Admin adminId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminId")
    @JsonIgnore //
    private Collection<OnCall> onCallCollection;

    public Admin() {
    }

    public Admin(Integer id) {
        this.id = id;
    }

    public Admin(Integer id, String firstName, String lastName, String typeOfAdmin, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.typeOfAdmin = typeOfAdmin;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTypeOfAdmin() {
        return typeOfAdmin;
    }

    public void setTypeOfAdmin(String typeOfAdmin) {
        this.typeOfAdmin = typeOfAdmin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @XmlTransient
    public Collection<Admin> getAdminCollection() {
        return adminCollection;
    }

    public void setAdminCollection(Collection<Admin> adminCollection) {
        this.adminCollection = adminCollection;
    }

    public Admin getAdminId() {
        return adminId;
    }

    public void setAdminId(Admin adminId) {
        this.adminId = adminId;
    }

    @XmlTransient
    public Collection<OnCall> getOnCallCollection() {
        return onCallCollection;
    }

    public void setOnCallCollection(Collection<OnCall> onCallCollection) {
        this.onCallCollection = onCallCollection;
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
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vpdq.pojo.Admin[ id=" + id + " ]";
    }
    
}

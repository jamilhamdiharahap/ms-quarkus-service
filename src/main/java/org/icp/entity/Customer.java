package org.icp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.icp.entity.enums.LocationType;

import java.sql.Timestamp;

@Entity
@Table(name = "ms_customers")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "location")
    private LocationType location;

    @Column(name = "user_id")
    private String userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private User user;
    
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Customer() {}

    public Customer(String fullName, String phoneNumber, String address, LocationType location, User user) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.location = location;
        this.user = user;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public LocationType getLocation() {
        return location;
    }

    public User getUser() {
        return user;
    }

    public String getUserId() {
        return userId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLocation(LocationType location) {
        this.location = location;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

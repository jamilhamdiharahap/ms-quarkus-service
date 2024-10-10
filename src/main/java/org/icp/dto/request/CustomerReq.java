package org.icp.dto.request;

import org.icp.entity.Customer;
import org.icp.entity.User;
import org.icp.entity.enums.LocationType;

public class CustomerReq {
     private String fullName;
     private String phoneNumber;
     private String address;
     private LocationType location;
     private String userId;

    public String getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location.name();
    }

    public void setLocation(LocationType location) {
        this.location = location;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Customer toCustomerReq(User user) {
        return new Customer(this.fullName.toUpperCase(), this.phoneNumber, this.address, this.location, user);
    }
}

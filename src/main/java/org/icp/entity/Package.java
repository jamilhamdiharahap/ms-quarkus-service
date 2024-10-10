package org.icp.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "ms_packages")
public class Package {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "number_kit")
    private String numberKit;

    @Column(name = "package_type")
    private String packageType;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;


    public Package() {
    }

    public Package(String packageName, String code, String numberKit, String serialNumber, String packageType, Timestamp timestamp) {
        this.name = packageName;
        this.packageType = packageType;
        this.code = code;
        this.numberKit = numberKit;
        this.serialNumber = serialNumber;
        this.createdAt = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getNumberKit() {
        return numberKit;
    }

    public String getPackageType() {
        return packageType;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setNumberKit(String numberKit) {
        this.numberKit = numberKit;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

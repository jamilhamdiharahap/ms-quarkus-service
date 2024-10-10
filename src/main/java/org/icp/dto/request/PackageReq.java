package org.icp.dto.request;

import org.icp.entity.Package;

import java.sql.Timestamp;

public class PackageReq {
    private String packageName;
    private String code;
    private String numberKit;
    private String serialNumber;
    private String packageType;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumberKit() {
        return numberKit;
    }

    public void setNumberKit(String numberKit) {
        this.numberKit = numberKit;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public Package toPackageReq() {
        return new Package(this.packageName, this.code, this.numberKit, this.serialNumber, this.packageType, new Timestamp(System.currentTimeMillis()));
    }

}

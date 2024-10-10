package org.icp.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.icp.entity.Package;

import java.util.Optional;

@ApplicationScoped
public class PackageRepository implements PanacheRepositoryBase<Package, String> {
    public Optional<Package> findByNumberKitAndSerialNumber(String numberKit, String serialNumber) {
        return find("numberKit = ?1 OR serialNumber = ?2", numberKit, serialNumber).firstResultOptional();
    }
}

package org.icp.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.icp.dto.request.PackageReq;
import org.icp.entity.Package;
import org.icp.repository.PackageRepository;

import java.util.List;


@ApplicationScoped
public class PackageService {
    @Inject
    PackageRepository packageRepository;

    @Transactional
    public String doAddPackage(PackageReq pkg) {
        if (packageRepository.findByNumberKitAndSerialNumber(pkg.getNumberKit(), pkg.getSerialNumber()).isPresent()) throw new WebApplicationException("already exist package");

        Package newPackage = pkg.toPackageReq();
        packageRepository.persist(newPackage);

        return "Package berhasil ditambahkan";
    }

    public List<Package> doGetPackages() {
        return packageRepository.listAll();
    }

    public Package doGetPackage(String id) {
        return packageRepository.findById(id);
    }

    @Transactional
    public String doDeletePackage(String id) {
        if(id == null) throw new WebApplicationException("Package ID "+ id + " tidak ditemukan");

        if(!packageRepository.deleteById(id)) throw new WebApplicationException("Package ID "+ id + " gagal dihapus");

        return "Package berhasil dihapus";
    }
}

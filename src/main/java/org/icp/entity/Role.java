package org.icp.entity;

import jakarta.persistence.*;
import org.icp.entity.enums.RoleType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ms_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

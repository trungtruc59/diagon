package com.kt.diagon.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tbl_roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL,orphanRemoval = true)
    List<User> users;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String roleStatus;
    @Setter
    @Getter
    private Integer numb;

    public Roles(Integer id, String name, String roleStatus, Integer numb) {
        this.id = id;
        this.name = name;
        this.roleStatus = roleStatus;
        this.numb = numb;
    }

    public Roles() {
    }

    public Integer getRoleId() {
        return id;
    }

    public void setRoleId(Integer id) {
        this.id = id;
    }

}
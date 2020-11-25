package com.board.entity;

import com.board.entity.enums.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String login;

    @Column(columnDefinition = "VARCHAR(20)")
    private String password;

    @Column(name = "first_name", columnDefinition = "VARCHAR(30)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(50)")
    private String lastName;

    @OneToMany(orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    @JoinTable(name = "user_phone",
            joinColumns = @JoinColumn(name = "user_fk_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_fk_id"))
    private List<Phone> phones = new ArrayList<>();

    @OneToOne(orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "email_fk_id")
    private Email email;

    @OneToOne(orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "address_fk_id")
    private Address address;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "FK_users_roles_users"))
    private Set<Role> roles = new HashSet<>();

}

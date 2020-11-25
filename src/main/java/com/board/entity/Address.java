package com.board.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "addresses")
@ToString(exclude = {"user"})
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int id;

    private String city;

    private String street;

    private  String region;

    @Column(name = "post_code")
    private int postCode;

    @OneToOne(mappedBy = "address")
    private User user;

}

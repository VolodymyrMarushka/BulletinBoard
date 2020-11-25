package com.board.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private int id;

    private String operator;

    private String number;

}

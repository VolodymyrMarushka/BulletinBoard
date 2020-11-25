package com.board.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "emails")
@ToString(exclude = {"user"})
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_id")
    private int id;

    private String email;

    @OneToOne(mappedBy = "email")
    private User user;

}

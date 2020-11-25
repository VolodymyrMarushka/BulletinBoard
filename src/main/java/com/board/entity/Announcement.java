package com.board.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "announcements")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcement_id")
    private int id;

    private String title;

    private String text;

    private BigDecimal price;

    //private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "category_fk_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_fk_id")
    private User user;

}

package com.example.sbhibernatemysql.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}

package com.example.auction_service_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "voievodeship")
    private String voievodeship;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @Column(name = "account_creation_date")
    private Date accountCreationDate;
   /* @OneToMany(mappedBy = "User")
    private List<Auction> auctions;*/
}

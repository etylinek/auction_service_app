package com.example.auction_service_app.model;

import com.example.auction_service_app.types.AccountStatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserModel {
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date accountCreationDate;

    @Column(name = "account_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatusType accountStatusType = AccountStatusType.INACTIVE; // domyślny status konta usera

}

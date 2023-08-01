package com.example.auction_service_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class PurchaseRatingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "buyerRating")
    private Integer buyerRating;

    @Column(name = "buyerComment")
    private String buyerComment;

    @Column(name = "sellerRating")
    private Integer sellerRating;

    @Column(name = "sellerComment")
    private String sellerComment;

}

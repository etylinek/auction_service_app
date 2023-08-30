package com.example.auction_service_app.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuctionObservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "observer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AuctionModel> observedAuctionList = new ArrayList<>();

    @OneToOne
    private UserModel userModel;



}

package com.example.auction_service_app.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany//(mappedBy = "auctionObservationModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AuctionModel> observedAuctionList;

    @OneToOne
    private UserModel userModel;
     // pomysl jest taki, zeby kazda aukcja miala swoja obserwacje, natomiast wielu userow moze byc polaczonych z dana obserwacja
    //   @JoinColumn(name = "user_id")//, nullable = false


}

package com.example.auction_service_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AuctionObservation")
public class AuctionObservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne // pomysl jest taki, zeby kazda aukcja miala swoja obserwacje, natomiast wielu userow moze byc polaczonych z dana obserwacja
    @JoinColumn(name = "auction_id", nullable = false)
    private AuctionModel auction;

    @ManyToOne // pomysl jest taki, zeby kazda aukcja miala swoja obserwacje, natomiast wielu userow moze byc polaczonych z dana obserwacja
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;
}

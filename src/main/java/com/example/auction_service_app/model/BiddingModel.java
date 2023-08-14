package com.example.auction_service_app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BiddingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bidding_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "auction_id", nullable = false)
    private AuctionModel auction;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userModel;

    @Column(name = "bidding_value")
    @NotNull // walidacja, nie może być zerowe
    @NumberFormat
    private BigDecimal value;

    @Column(name = "bid_time")
    private LocalDateTime bidTime;

}
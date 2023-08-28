package com.example.auction_service_app.model;

import javax.persistence.*;

import com.example.auction_service_app.types.AuctionStatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class AuctionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CategoryModel categoryModel;

    @OneToOne
    private UserModel userModel;

    @OneToOne
    private UserModel buyer;

    @ManyToOne
    private AuctionObservationModel auctionObservationModel;


    //List<STring> images czy wrzucić do innej tabeli?

    @Column(name = "name")
    private String name;


    @Column(name = "description")
    private String description;

    @Column(name = "min_value")
    private BigDecimal minValue;

    @Column(name = "buy_now_value")
    private BigDecimal buyNowValue;

    @Column(name = "is_promoted")
    boolean isPromoted;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate = LocalDate.now();

    @Column(name = "end_date")

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;


    @Column(name = "views")
    private Integer views;

    @Column(name = "auction_status")
    @Enumerated(EnumType.STRING)
    private AuctionStatusType auctionStatusType = AuctionStatusType.ACTIVE;

}

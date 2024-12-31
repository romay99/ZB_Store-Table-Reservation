package com.zerobase.Store_Table_Reservation.review.entity;

import com.zerobase.Store_Table_Reservation.reservation.entity.Reservation;
import com.zerobase.Store_Table_Reservation.store.entity.Store;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewCode;

    private String content;

    private double rating;

    @ManyToOne
    private Store store;

    @OneToOne
    private Reservation reservation;
}
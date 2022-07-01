package com.example.demo.club;

import com.example.demo.reservation.Reservation;

import javax.persistence.*;
import java.util.List;

/**
 * @author Karolina Krommelova
 *
 * Class for Court.
 *
 * Class consists of attributes for the table and two constructors.
 */
@Entity
@Table(name = "courts")
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 50, nullable = false, unique = true)
    private Long id;

    @Column(name = "type", length = 50, nullable = false)
    private String surfaceType;

    @Column(name = "price", nullable = false)
    private double pricePerMinute;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "court_id")
    @Column(name = "reservations", unique = true)
    private List<Reservation> reservation;

    /**
     * Constructor for the class.
     */
    public Court() {
    }

    /**
     * Constructor for the class which takes the type of the surface and price for the surface.
     */
    public Court(String surfaceType, double pricePerMinute) {
        this.surfaceType = surfaceType;
        this.pricePerMinute = pricePerMinute;
    }

    public Long getId() {
        return id;
    }

    public String getSurfaceType() {
        return surfaceType;
    }

    public double getPricePerMinute() {
        return pricePerMinute;
    }
}

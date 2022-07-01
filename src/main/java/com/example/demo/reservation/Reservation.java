package com.example.demo.reservation;

import com.example.demo.club.Court;
import com.example.demo.customer.Customer;

import javax.persistence.*;

/**
 * @author Karolina Krommelova
 *
 * Class for Reservations.
 *
 * Class consists of attributes for the table, two constructors and methods to operate with the attributes.
 */
@Entity
@Table(name="reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="gameType", nullable=false)
    private GameType gameType;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "court_id", nullable=false)
    private Court court_id;

    @Column(name="time", nullable=false)
    private int time;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable=false)
    private Customer customer_id;

    /**
     * Constructor for the class.
     */
    public Reservation(){}

    /**
     * Constructor for the class which takes the game type, court, time to play and the customer.
     */
    public Reservation(GameType gameType, Court court, int time, Customer customer) {
        this.gameType = gameType;
        this.court_id = court;
        this.time = time;
        this.customer_id = customer;
    }

    /**
     * Method to calculate the price for the reservation.
     *
     * @return double price
     */
    public double getPrice() {
        return time * gameType.getNumVal();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public void setCourt_id(Court court_id) {
        this.court_id = court_id;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Long getId() {
        return id;
    }

    public GameType getGameType() {
        return gameType;
    }

    public Court getCourt_id() {
        return court_id;
    }

    public int getTime() {
        return time;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }
}

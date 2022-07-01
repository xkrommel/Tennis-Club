package com.example.demo.customer;

import com.example.demo.reservation.Reservation;

import javax.persistence.*;
import java.util.List;

/**
 * @author Karolina Krommelova
 *
 * Class for Customers.
 *
 * Class consists of attributes for the table, two constructors and methods to operate with the attributes.
 */
@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="number", length=50, nullable=false, unique=true)
    private String phoneNumber;

    @Column(name="name", length=50, nullable=false, unique=false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer_id")
    @Column(name="reservations", unique=true)
    private List<Reservation> reservation;

    /**
     * Constructor for the class.
     */
    public Customer(){}

    /**
     * Constructor for the class which takes the phone number and name of the customer.
     */
    public Customer(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }
}

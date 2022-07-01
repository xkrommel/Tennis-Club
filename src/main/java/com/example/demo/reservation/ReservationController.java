package com.example.demo.reservation;

import com.example.demo.club.Court;
import com.example.demo.club.CourtRepository;
import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Karolina Krommelova
 *
 * Class for operating with the Reservation repository.
 */
@Controller
@RequestMapping(path = "/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CourtRepository courtRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Method to get all reservations with given court id.
     *
     * @param id - id of the court
     * @return Iterable<Reservation> - all reservations with given court id
     */
    @GetMapping(path = "/allbycourtid")
    public @ResponseBody Iterable<Reservation> getAllReservationsByCourt(@RequestParam Long id) {
        return reservationRepository.findAllByCourtId(id);
    }

    /**
     * Method to get all reservations with given number of the customer.
     *
     * @param number - number of the customer
     * @return Iterable<Reservation> - all reservations with given number of the customer
     */
    @GetMapping(path = "/allbyphonenumber")
    public @ResponseBody Iterable<Reservation> getAllReservationsByCustomer(@RequestParam String number) {
        return reservationRepository.findAllByPhoneNumber(number);
    }

    /**
     * Method to create reservation with given court id, type of game,
     * phone number and name of the customer and time to play and calculates its price.
     *
     * @param court_id - id of the court
     * @param gameType - type of game
     * @param number - phone number of the customer
     * @param name - name of the customer
     * @param time - time to play
     * @return double - price of the reservation
     */
    @RequestMapping(path = "/create")
    public @ResponseBody double createReservation(@RequestParam Long court_id, @RequestParam GameType gameType,
                                                  @RequestParam String number, @RequestParam String name,
                                                  @RequestParam int time) {
        if (time/5 != 0){
            throw new IllegalArgumentException("Wrong time interval.");
        }
        if (name.length() > 100){
            throw new IllegalArgumentException("Name is too long.");
        }
        Customer customer;
        Court court = courtRepository.findCourtById(court_id);
        if (court == null){
            throw new IllegalArgumentException("Court does not exist.");
        }
        if (customerRepository.findCustomerByNumber(number) == null) {
            customer = new Customer(number, name);
        } else {
            customer = customerRepository.findCustomerByNumber(number);
        }
        Reservation reservation = new Reservation(gameType, court, time, customer);
        reservationRepository.save(reservation);
        return reservation.getPrice();
    }

}

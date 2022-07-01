package com.example.demo.reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Karolina Krommelova
 *
 * Interface for Reservations repository.
 *
 * Includes functions with queries to operate with Reservation table.
 */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    /**
     * Method to find reservations by the id of the court in the database.
     *
     * @param id - id of the court
     * @return Reservations with given court id
     */
    @Query(value = "SELECT ug, u FROM Reservation ug INNER JOIN ug.court_id u WHERE u.id = :id")
    List<Reservation> findAllByCourtId(Long id);

    /**
     * Method to find reservations by the phone number of the customer in the database.
     *
     * @param phoneNumber - phone number of the customer
     * @return Reservations with given phone number
     */
    @Query(value = "SELECT ug, u FROM Reservation ug INNER JOIN ug.customer_id u WHERE u.phoneNumber = :phoneNumber")
    List<Reservation> findAllByPhoneNumber(String phoneNumber);

}

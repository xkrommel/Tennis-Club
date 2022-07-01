package com.example.demo.club;

import com.example.demo.reservation.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.club.Court;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Karolina Krommelova
 *
 * Interface for Court repository.
 *
 * Includes functions with queries to operate with Court table.
 */
@Repository
public interface CourtRepository extends CrudRepository<Court, Integer> {

    /**
     * Method to find a court its id in the database.
     *
     * @param id - id of the court
     * @return Court with given id
     */
    @Query(value = "SELECT u FROM Court u WHERE u.id = :id")
    Court findCourtById(Long id);

}

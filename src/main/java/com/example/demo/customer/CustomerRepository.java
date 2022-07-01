package com.example.demo.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Karolina Krommelova
 *
 * Interface for Customer repository.
 *
 * Includes functions with queries to operate with Customer table.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    /**
     * Method to find aa customer by his number in the database.
     *
     * @param number - phone number of the customer
     * @return Customer with given phone number
     */
    @Query(value = "SELECT u FROM Customer u WHERE u.phoneNumber = :number")
    Customer findCustomerByNumber(String number);

}

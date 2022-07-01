package com.example.demo.club;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Karolina Krommelova
 *
 * Class for operating with the Court repository.
 */
@Controller
@RequestMapping(path="/courts")
public class CourtsController {
    @Autowired
    private CourtRepository courtRepository;

    /**
     * Method to get all courts from thne database.
     *
     * @return Iterable<Court> - all courts
     */
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Court> getAllCourts() {
        return courtRepository.findAll();
    }
}

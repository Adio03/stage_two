package com.example.zuri_stage_two.controllers;

import com.example.zuri_stage_two.data.models.Person;
import com.example.zuri_stage_two.dtos.request.PersonRequest;
import com.example.zuri_stage_two.dtos.response.PersonResponse;
import com.example.zuri_stage_two.dtos.response.UpdateResponse;
import com.example.zuri_stage_two.exceptions.EmailAlreadyExistException;
import com.example.zuri_stage_two.exceptions.EmailNotFoundException;
import com.example.zuri_stage_two.exceptions.PersonNotFoundException;
import com.example.zuri_stage_two.service.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PersonController {

    private PersonServiceImpl service;

    public PersonController(PersonServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "/api", method = RequestMethod.POST)
    public ResponseEntity<?> createPerson(@RequestBody PersonRequest request) {
        try {
            PersonResponse response = service.createPerson(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EmailAlreadyExistException exception) {
            var message = "Email Already Exist";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @RequestMapping(value = "/api/{email}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePerson(@PathVariable String email, @RequestBody PersonRequest request) {
        try {
            UpdateResponse response = service.updatedPerson(email, request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EmailNotFoundException exception) {
            var message = "The Email Does Not Exsit";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @RequestMapping(value = "/api/{firstName}", method = RequestMethod.GET)
    public ResponseEntity<?> findByFirstName(@PathVariable String firstName) {
        try {
            List<Person> person = service.findByFirstName(firstName);
            return ResponseEntity.ok(person);
        } catch (PersonNotFoundException exception) {
            var message = "This " + firstName + " Not Found, Kindly Try Another Name";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @RequestMapping(value = "/api/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<?> findByLastName(@PathVariable String lastName) {
        try {
            List<Person> person = service.findByLastName(lastName);
            return ResponseEntity.ok(person);
        } catch (PersonNotFoundException exception) {
                    var message = "person with this " + lastName + " not found, kindly try other name.";
               return      ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

        }
    }

    @RequestMapping(value = "/api/{email}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteByEmail(@PathVariable String email) {
        try {
            service.deletePersonByEmail(email);
            return ResponseEntity.ok("Person with email " + email + " deleted successfully.");
        } catch (PersonNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Person with email " + email + " not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while deleting the person with email " + email + ".");
        }
        }

    }

package com.example.zuri_stage_two.service;

import com.example.zuri_stage_two.data.models.Person;
import com.example.zuri_stage_two.dtos.request.PersonRequest;
import com.example.zuri_stage_two.dtos.response.PersonResponse;
import com.example.zuri_stage_two.dtos.response.UpdateResponse;

import java.util.List;
import java.util.Optional;
public interface PersonService {
    PersonResponse createPerson(PersonRequest request);
    UpdateResponse updatedPerson(String email,PersonRequest request);
    List<Person> findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);

    void deletePersonByEmail(String email);
}

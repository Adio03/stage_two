package com.example.zuri_stage_two.service;

import com.example.zuri_stage_two.data.models.Person;
import com.example.zuri_stage_two.data.repositries.PersonRepository;
import com.example.zuri_stage_two.dtos.request.PersonRequest;
import com.example.zuri_stage_two.dtos.response.PersonResponse;
import com.example.zuri_stage_two.dtos.response.UpdateResponse;
import com.example.zuri_stage_two.exceptions.EmailAlreadyExistException;
import com.example.zuri_stage_two.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements  PersonService {
    @Autowired
    private PersonRepository repository;

    @Override
    public PersonResponse createPerson(PersonRequest request) {
        boolean personExist = repository.findByEmail(request.getEmail()).
                isPresent();
        if (personExist)
            throw new EmailAlreadyExistException("the email already exist");
        Person newPerson = Person.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .gender(request.getGender())
                .build();
        repository.save(newPerson);
        PersonResponse response = new PersonResponse();
                response.setMessage(" Person is Successfully Created");
        return response;
    }

    @Override
    public UpdateResponse updatedPerson(String email, PersonRequest request) {
        Optional<Person> personExist = repository.findByEmail(email);
        if (personExist.isPresent()) {
            Person person = personExist.get();
            person.setFirstName(request.getFirstName());
            person.setLastName(request.getLastName());
            person.setEmail(request.getEmail());
            person.setPhoneNumber(request.getPhoneNumber());
            person.setGender(request.getGender());
            repository.save(person);

            UpdateResponse response;
            response = UpdateResponse.builder()
                    .firstName(person.getFirstName())
                    .lastName(person.getLastName())
                    .email(person.getEmail())
                    .phoneNumber(person.getPhoneNumber())
                    .message("Successfully Updated").build();
            return response;
        } else {
            throw new PersonNotFoundException("Person with " + email + " email not found");
        }

    }

    @Override
    public List<Person> findByFirstName(String firstName) {
        List<Person> findPerson = repository.findPersonByFirstName(firstName);
        if (findPerson.isEmpty())
            throw new PersonNotFoundException("person the with " + firstName + " not found");
        return findPerson;
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        List<Person> personFound = repository.findPersonByLastName(lastName);
        if (personFound.isEmpty())
            throw new PersonNotFoundException("person with " + lastName + " not found");
        return personFound;
    }
    @Override
    public void deletePersonByEmail(String email) {
        Optional<Person> personFound = repository.findByEmail(email);
        if (personFound.isPresent()) {
            repository.delete(personFound.get());
        } else {
            throw new PersonNotFoundException("Person with email " + email + " not found");
        }
    }
}
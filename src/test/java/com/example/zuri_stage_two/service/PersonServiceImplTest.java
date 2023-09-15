package com.example.zuri_stage_two.service;

import com.example.zuri_stage_two.data.models.Gender;
import com.example.zuri_stage_two.data.models.Person;
import com.example.zuri_stage_two.data.repositries.PersonRepository;
import com.example.zuri_stage_two.dtos.request.PersonRequest;
import com.example.zuri_stage_two.dtos.response.PersonResponse;
import com.example.zuri_stage_two.dtos.response.UpdateResponse;
import com.example.zuri_stage_two.exceptions.PersonNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonServiceImplTest {
    @Autowired
    private  PersonService personService;
    @Test
    public void test_To_Create_Person(){
        PersonRequest request = PersonRequest.builder().
            firstName("Maven").
            lastName("Miracle").
            email("maven123456@gmail.com").
            phoneNumber("07011223344").
            gender(Gender.FEMALE).build();
    PersonResponse person =  personService.createPerson(request);
    String message = " Person is Successfully Created";
    assertEquals(message,person.getMessage());
}
    @Test
    public void test_to_Update(){
        String email = "maven123456@gmail.com";
        PersonRequest requestPerson = PersonRequest.builder().
                firstName("Adewale").
                lastName("Miracle").
                email("Adewale@gmail.com").
                phoneNumber("07011223344").
                gender(Gender.FEMALE).build();
        UpdateResponse response = personService.updatedPerson(email,requestPerson);
        String expected = "Successfully Updated";
        assertEquals(expected,response.getMessage());
    }
    @Test
    public void test_To_Find_Person_with_FirstName(){
        String firstName = "Adewale";
        List<Person> personFound = personService.findByFirstName(firstName);
        assertNotNull(personFound);
    }
    @Test
    public void test_to_find_Person_With_Lastname(){
        String lastName = "Miracle";
        List<Person> personFound = personService.findByLastName(lastName);
        assertNotNull(personFound);
    }
    @Test
    public void test_to_delete_person_with_email(){
        String email = "Adewale@gmail.com";
        assertThrows(PersonNotFoundException.class, () -> personService.deletePersonByEmail(email));

    }

}
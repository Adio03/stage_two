package com.example.zuri_stage_two.data.repositries;


import com.example.zuri_stage_two.data.models.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonRepositoryImplTest {
    @Autowired
    private PersonRepository repository;


    @Test
    public void test_To_Save_Persson(){
        Person person = new Person();
        Person savedPerson = repository.save(person);
        assertNotNull(savedPerson);
    }
}
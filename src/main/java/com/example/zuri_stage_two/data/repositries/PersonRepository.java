package com.example.zuri_stage_two.data.repositries;

import com.example.zuri_stage_two.data.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person,Long> {
   Optional <Person> findByEmail(String email);
   List<Person> findPersonByFirstName(String FirstName);
   List<Person>  findPersonByLastName(String lastName);



}

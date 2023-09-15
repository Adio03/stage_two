package com.example.zuri_stage_two.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;


@NoArgsConstructor
@AllArgsConstructor
@Setter@Getter
@Builder
@Entity
@Table(name ="Person")

public class Person {
   @jakarta.persistence.Id
    @Id
    @JsonIgnore()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;


}

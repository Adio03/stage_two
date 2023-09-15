package com.example.zuri_stage_two.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String sex;
}

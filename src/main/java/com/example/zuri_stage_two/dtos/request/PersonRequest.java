package com.example.zuri_stage_two.dtos.request;

import com.example.zuri_stage_two.data.models.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PersonRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Gender gender;
}

package com.example.zuri_stage_two.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UpdateResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String message;




}

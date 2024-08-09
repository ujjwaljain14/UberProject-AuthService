package com.example.uberprojectauthservice.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DriverSignUpDto {
    private String name;

    private String phoneNumber;

    private String email;

    private String password;

    private String licenseNumber;
}

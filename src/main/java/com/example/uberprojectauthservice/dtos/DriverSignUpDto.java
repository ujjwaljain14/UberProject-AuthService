package com.example.uberprojectauthservice.dtos;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component

public class DriverSignUpDto {
    private String name;

    private String phoneNumber;

    private String email;

    private String password;

    private String licenseNumber;
}

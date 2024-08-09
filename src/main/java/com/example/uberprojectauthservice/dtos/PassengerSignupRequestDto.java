package com.example.uberprojectauthservice.dtos;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerSignupRequestDto {

    private String email;

    private String password;

    private String phoneNumber;

    private String name;
}

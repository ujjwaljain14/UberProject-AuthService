package com.example.uberprojectauthservice.dtos;

import lombok.AllArgsConstructor;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component

public class PassengerDto {

    private String id;

    private String name;

    private String email;

    private String password; //encrypted password

    private String phoneNumber;

    private Date createdAt;

}

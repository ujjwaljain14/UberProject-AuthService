package com.example.uberprojectauthservice.dtos;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component

public class DriverDto {

    private String id;

    private String name;

    private String email;

    private String password; //encrypted password

    private String phoneNumber;

    private String licenseNumber;

    private Date createdAt;

}

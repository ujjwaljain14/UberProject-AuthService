package com.example.uberprojectauthservice.dtos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthRequestDto {

    private String email;
    private String password;

}

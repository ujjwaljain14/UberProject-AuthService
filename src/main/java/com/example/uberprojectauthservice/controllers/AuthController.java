package com.example.uberprojectauthservice.controllers;

import com.example.uberprojectauthservice.adapters.PassengerSignupRequestDtoToPassengerAdapter;
import com.example.uberprojectauthservice.adapters.PassengerToPassengerDtoAdapterImpl;
import com.example.uberprojectauthservice.dtos.DriverSignUpDto;
import com.example.uberprojectauthservice.dtos.PassengerSignupRequestDto;
import com.example.uberprojectauthservice.models.Passenger;
import com.example.uberprojectauthservice.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final PassengerSignupRequestDtoToPassengerAdapter passengerSignupRequestDtoToPassengerAdapter;
    private final AuthService authService;
    private final PassengerToPassengerDtoAdapterImpl passengerToPassengerDtoAdapterImpl;

    AuthController(PassengerSignupRequestDtoToPassengerAdapter passengerSignupRequestDtoToPassengerAdapter, AuthService authService,PassengerToPassengerDtoAdapterImpl passengerToPassengerDtoAdapterImpl){
        this.passengerSignupRequestDtoToPassengerAdapter = passengerSignupRequestDtoToPassengerAdapter;
        this.authService = authService;
        this.passengerToPassengerDtoAdapterImpl = passengerToPassengerDtoAdapterImpl;
    }

    @PostMapping("/signup/passenger")
    public ResponseEntity<?> signup(@RequestBody PassengerSignupRequestDto passengerSignupRequestDto) {

        Passenger passenger = passengerSignupRequestDtoToPassengerAdapter.convertDto(passengerSignupRequestDto);
        Passenger newPassenger = authService.signupPassenger(passenger);
        return ResponseEntity.ok(passengerToPassengerDtoAdapterImpl.convertDto(newPassenger));

    }

    @PostMapping("/signup/driver")
    public ResponseEntity<?> signup(@RequestBody DriverSignUpDto driverSignUpDto) {

        return null;
    }
}

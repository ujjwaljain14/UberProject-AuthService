package com.example.uberprojectauthservice.controllers;

import com.example.uberprojectauthservice.adapters.DriverSignUpDtoToDriverAdapterImpl;
import com.example.uberprojectauthservice.adapters.DriverToDriverDtoAdapterImpl;
import com.example.uberprojectauthservice.adapters.PassengerSignupRequestDtoToPassengerAdapter;
import com.example.uberprojectauthservice.adapters.PassengerToPassengerDtoAdapterImpl;
import com.example.uberprojectauthservice.dtos.DriverSignUpDto;
import com.example.uberprojectauthservice.dtos.PassengerSignupRequestDto;
import com.example.uberprojectauthservice.models.Driver;
import com.example.uberprojectauthservice.models.Passenger;
import com.example.uberprojectauthservice.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final PassengerSignupRequestDtoToPassengerAdapter passengerSignupRequestDtoToPassengerAdapter;
    private final AuthService authService;
    private final PassengerToPassengerDtoAdapterImpl passengerToPassengerDtoAdapterImpl;
    private final DriverSignUpDtoToDriverAdapterImpl driverSignUpDtoToDriverAdapterImpl;
    private final DriverToDriverDtoAdapterImpl driverToDriverDtoAdapterImpl;

    AuthController(PassengerSignupRequestDtoToPassengerAdapter passengerSignupRequestDtoToPassengerAdapter, AuthService authService, PassengerToPassengerDtoAdapterImpl passengerToPassengerDtoAdapterImpl, DriverSignUpDtoToDriverAdapterImpl driverSignUpDtoToDriverAdapterImpl, DriverToDriverDtoAdapterImpl driverToDriverDtoAdapterImpl){
        this.passengerSignupRequestDtoToPassengerAdapter = passengerSignupRequestDtoToPassengerAdapter;
        this.authService = authService;
        this.passengerToPassengerDtoAdapterImpl = passengerToPassengerDtoAdapterImpl;
        this.driverSignUpDtoToDriverAdapterImpl = driverSignUpDtoToDriverAdapterImpl;
        this.driverToDriverDtoAdapterImpl = driverToDriverDtoAdapterImpl;
    }

    @PostMapping("/signup/passenger")
    public ResponseEntity<?> signup(@RequestBody PassengerSignupRequestDto passengerSignupRequestDto) {

        Passenger passenger = passengerSignupRequestDtoToPassengerAdapter.convertDto(passengerSignupRequestDto);
        Passenger newPassenger = authService.signupPassenger(passenger);
        return ResponseEntity.ok(passengerToPassengerDtoAdapterImpl.convertDto(newPassenger));

    }

    @PostMapping("/signup/driver")
    public ResponseEntity<?> signup(@RequestBody DriverSignUpDto driverSignUpDto) {
        Driver driver = driverSignUpDtoToDriverAdapterImpl.convertDto(driverSignUpDto);
        Driver newdriver = authService.signupDriver(driver);
        return ResponseEntity.ok(driverToDriverDtoAdapterImpl.convertDto(newdriver));

    }

    @GetMapping("/signin/passenger")
    public ResponseEntity<?> signin(@RequestBody DriverSignUpDto driverSignUpDto) {
        Driver driver = driverSignUpDtoToDriverAdapterImpl.convertDto(driverSignUpDto);
        Driver newdriver = authService.signupDriver(driver);
        return ResponseEntity.ok(driverToDriverDtoAdapterImpl.convertDto(newdriver));

    }
}

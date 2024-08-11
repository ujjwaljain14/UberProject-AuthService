package com.example.uberprojectauthservice.controllers;

import com.example.uberprojectauthservice.adapters.DriverSignUpDtoToDriverAdapterImpl;
import com.example.uberprojectauthservice.adapters.DriverToDriverDtoAdapterImpl;
import com.example.uberprojectauthservice.adapters.PassengerSignupRequestDtoToPassengerAdapter;
import com.example.uberprojectauthservice.adapters.PassengerToPassengerDtoAdapterImpl;
import com.example.uberprojectauthservice.dtos.AuthRequestDto;
import com.example.uberprojectauthservice.dtos.DriverSignUpDto;
import com.example.uberprojectauthservice.dtos.PassengerSignupRequestDto;
import com.example.uberprojectauthservice.models.Driver;
import com.example.uberprojectauthservice.models.Passenger;
import com.example.uberprojectauthservice.services.AuthService;
import com.example.uberprojectauthservice.services.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final PassengerSignupRequestDtoToPassengerAdapter passengerSignupRequestDtoToPassengerAdapter;
    private final AuthService authService;
    private final PassengerToPassengerDtoAdapterImpl passengerToPassengerDtoAdapterImpl;
    private final DriverSignUpDtoToDriverAdapterImpl driverSignUpDtoToDriverAdapterImpl;
    private final DriverToDriverDtoAdapterImpl driverToDriverDtoAdapterImpl;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Value("${cookie.expiry}")
    private int cookieExpiry;

    AuthController(PassengerSignupRequestDtoToPassengerAdapter passengerSignupRequestDtoToPassengerAdapter, AuthService authService, PassengerToPassengerDtoAdapterImpl passengerToPassengerDtoAdapterImpl, DriverSignUpDtoToDriverAdapterImpl driverSignUpDtoToDriverAdapterImpl, DriverToDriverDtoAdapterImpl driverToDriverDtoAdapterImpl, AuthenticationManager authenticationManager, JwtService jwtService){
        this.passengerSignupRequestDtoToPassengerAdapter = passengerSignupRequestDtoToPassengerAdapter;
        this.authService = authService;
        this.passengerToPassengerDtoAdapterImpl = passengerToPassengerDtoAdapterImpl;
        this.driverSignUpDtoToDriverAdapterImpl = driverSignUpDtoToDriverAdapterImpl;
        this.driverToDriverDtoAdapterImpl = driverToDriverDtoAdapterImpl;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
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

    @PostMapping("/signin/passenger")
    public ResponseEntity<?> signin(@RequestBody AuthRequestDto authRequestDto, HttpServletResponse response) {

        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(authRequestDto.getEmail(), authRequestDto.getPassword());

        Authentication authenticationResponse =
                this.authenticationManager.authenticate(authenticationRequest);

        if(authenticationResponse.isAuthenticated()){
            Map<String,Object> payload = new HashMap<>();
            String jwtToken = jwtService.createToken(payload, authRequestDto.getEmail());

            ResponseCookie cookie = ResponseCookie.from("jwtToken",jwtToken)
                    .httpOnly(true)
                    .secure(false)
                    .maxAge(cookieExpiry)
                    .build();
            response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());
            return ResponseEntity.ok("Successfully authenticated");
        }else{
            throw new UsernameNotFoundException("Username not found");
        }


    }
}

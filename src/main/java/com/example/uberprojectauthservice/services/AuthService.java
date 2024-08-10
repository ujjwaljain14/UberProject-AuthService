package com.example.uberprojectauthservice.services;

import com.example.uberprojectauthservice.dtos.PassengerDto;
import com.example.uberprojectauthservice.dtos.PassengerSignupRequestDto;
import com.example.uberprojectauthservice.models.Passenger;
import com.example.uberprojectauthservice.repositories.PassengerRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PassengerRepository passengerRepository;

    public AuthService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger signupPassenger(Passenger passenger) {

        return passengerRepository.save(passenger);

    }
}

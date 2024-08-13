package com.example.uberprojectauthservice.services;

import com.example.uberprojectauthservice.repositories.DriverRepository;
import com.example.uberprojectauthservice.repositories.PassengerRepository;
import com.example.uberprojectentityservice.models.Driver;
import com.example.uberprojectentityservice.models.Passenger;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PassengerRepository passengerRepository;
    private final DriverRepository driverRepository;

    public AuthService(PassengerRepository passengerRepository, DriverRepository driverRepository) {
        this.passengerRepository = passengerRepository;
        this.driverRepository = driverRepository;
    }

    public Passenger signupPassenger(Passenger passenger) {

        return passengerRepository.save(passenger);

    }

    public Driver signupDriver(Driver driver) {

        return driverRepository.save(driver);

    }
}

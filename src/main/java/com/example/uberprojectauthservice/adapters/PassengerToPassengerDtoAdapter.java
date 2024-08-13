package com.example.uberprojectauthservice.adapters;

import com.example.uberprojectauthservice.dtos.PassengerDto;
import com.example.uberprojectentityservice.models.Passenger;

public interface PassengerToPassengerDtoAdapter {

    PassengerDto convertDto(Passenger passenger);
}

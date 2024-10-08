package com.example.uberprojectauthservice.adapters;

import com.example.uberprojectauthservice.dtos.PassengerSignupRequestDto;
import com.example.uberprojectentityservice.models.Passenger;

public interface PassengerSignupRequestDtoToPassengerAdapter {

    Passenger convertDto(PassengerSignupRequestDto passengerSignupRequestDto);
}

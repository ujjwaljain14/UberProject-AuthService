package com.example.uberprojectauthservice.adapters;

import com.example.uberprojectauthservice.dtos.PassengerSignupRequestDto;
import com.example.uberprojectauthservice.models.Passenger;
import org.springframework.stereotype.Component;

@Component
public class PassengerSignupRequestDtoToPassengerAdapterImpl implements PassengerSignupRequestDtoToPassengerAdapter{
    @Override
    public Passenger convertDto(PassengerSignupRequestDto passengerSignupRequestDto) {
        return Passenger.builder()
                .email(passengerSignupRequestDto.getEmail())
                .password(passengerSignupRequestDto.getPassword())//todo encrypt
                .name(passengerSignupRequestDto.getName())
                .phoneNumber(passengerSignupRequestDto.getPhoneNumber())
                .build();
    }
}

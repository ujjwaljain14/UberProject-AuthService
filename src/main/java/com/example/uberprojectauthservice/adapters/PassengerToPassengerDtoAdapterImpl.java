package com.example.uberprojectauthservice.adapters;

import com.example.uberprojectauthservice.dtos.PassengerDto;
import com.example.uberprojectauthservice.models.Passenger;
import org.springframework.stereotype.Component;

@Component
public class PassengerToPassengerDtoAdapterImpl implements PassengerToPassengerDtoAdapter {
    @Override
    public PassengerDto convertDto(Passenger passenger) {
        return PassengerDto.builder()
                .id(String.valueOf(passenger.getId()))
                .name(passenger.getName())
                .email(passenger.getEmail())
                .password(passenger.getPassword())
                .phoneNumber(passenger.getPhoneNumber())
                .createdAt(passenger.getCreatedAt())
                .build();
    }
}

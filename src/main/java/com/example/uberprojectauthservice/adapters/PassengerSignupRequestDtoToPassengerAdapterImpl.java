package com.example.uberprojectauthservice.adapters;

import com.example.uberprojectauthservice.dtos.PassengerSignupRequestDto;
import com.example.uberprojectauthservice.models.Passenger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PassengerSignupRequestDtoToPassengerAdapterImpl implements PassengerSignupRequestDtoToPassengerAdapter{
    private final PasswordEncoder passwordEncoder;

    public PassengerSignupRequestDtoToPassengerAdapterImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Passenger convertDto(PassengerSignupRequestDto passengerSignupRequestDto) {
        return Passenger.builder()
                .email(passengerSignupRequestDto.getEmail())
                .password(passwordEncoder.encode(passengerSignupRequestDto.getPassword()))
                .name(passengerSignupRequestDto.getName())
                .phoneNumber(passengerSignupRequestDto.getPhoneNumber())
                .build();
    }
}

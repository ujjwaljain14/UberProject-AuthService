package com.example.uberprojectauthservice.adapters;

import com.example.uberprojectauthservice.dtos.DriverSignUpDto;
import com.example.uberprojectauthservice.models.Driver;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DriverSignUpDtoToDriverAdapterImpl implements DriverSignUpDtoToDriverAdapter {


    private final PasswordEncoder passwordEncoder;

    public DriverSignUpDtoToDriverAdapterImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Driver convertDto(DriverSignUpDto driverSignUpDto) {

        return Driver.builder()
                .name(driverSignUpDto.getName())
                .email(driverSignUpDto.getEmail())
                .password(passwordEncoder.encode(driverSignUpDto.getPassword()))
                .phoneNumber(driverSignUpDto.getPhoneNumber())
                .licenseNumber(driverSignUpDto.getLicenseNumber())
                .build();

    }
}

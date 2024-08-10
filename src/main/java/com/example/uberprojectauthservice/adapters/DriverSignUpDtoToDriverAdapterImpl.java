package com.example.uberprojectauthservice.adapters;

import com.example.uberprojectauthservice.dtos.DriverSignUpDto;
import com.example.uberprojectauthservice.models.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverSignUpDtoToDriverAdapterImpl implements DriverSignUpDtoToDriverAdapter {
    @Override
    public Driver convertDto(DriverSignUpDto driverSignUpDto) {

        return Driver.builder()
                .name(driverSignUpDto.getName())
                .email(driverSignUpDto.getEmail())
                .password(driverSignUpDto.getPassword())
                .phoneNumber(driverSignUpDto.getPhoneNumber())
                .licenseNumber(driverSignUpDto.getLicenseNumber())
                .build();

    }
}

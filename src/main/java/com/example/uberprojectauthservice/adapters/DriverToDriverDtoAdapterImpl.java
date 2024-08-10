package com.example.uberprojectauthservice.adapters;

import com.example.uberprojectauthservice.dtos.DriverDto;
import com.example.uberprojectauthservice.models.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverToDriverDtoAdapterImpl implements DriverToDriverDtoAdapter {
    @Override
    public DriverDto convertDto(Driver driver) {

        return DriverDto.builder()
                .id(String.valueOf(driver.getId()))
                .name(driver.getName())
                .email(driver.getEmail())
                .password(driver.getPassword())
                .phoneNumber(driver.getPhoneNumber())
                .licenseNumber(driver.getLicenseNumber())
                .createdAt(driver.getCreatedAt())
                .build();

    }
}

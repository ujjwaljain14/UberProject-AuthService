package com.example.uberprojectauthservice.adapters;

import com.example.uberprojectauthservice.dtos.DriverDto;
import com.example.uberprojectauthservice.models.Driver;

public interface DriverToDriverDtoAdapter {

    DriverDto convertDto(Driver driver);
}

package com.example.uberprojectauthservice.adapters;

import com.example.uberprojectauthservice.dtos.DriverSignUpDto;
import com.example.uberprojectentityservice.models.Driver;

public interface DriverSignUpDtoToDriverAdapter {

    Driver convertDto(DriverSignUpDto driverSignUpDto);

}

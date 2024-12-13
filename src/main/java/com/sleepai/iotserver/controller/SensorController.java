package com.sleepai.iotserver.controller;

import com.sleepai.iotserver.model.SensorData;
import com.sleepai.iotserver.repositories.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SensorController {


    @Autowired
    private SensorDataRepository sensorDataRepository;

    @QueryMapping
    public SensorData getSensorDataById(@Argument String id) {
        return sensorDataRepository.findById(id).orElseGet(null);
    }

    @QueryMapping
    public List<SensorData> getAllSensorData() {
        return this.sensorDataRepository.findAllByeHumanPresenceGreaterThan(0);
    }
}
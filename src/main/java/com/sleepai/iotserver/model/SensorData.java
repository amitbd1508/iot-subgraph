package com.sleepai.iotserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "mmwavesensors")
public class SensorData {

    @Id
    private String id;
    private String deviceId;
    private int eHumanMovement;
    private int eHumanMovingRange;
    private int eHumanPresence;
    private int heartRate;
    private int respiratory;
    private int rssi;
    private String SSID;
    private double time;
    private Instant createdAt;
    private Instant updatedAt;
    private int version;
}

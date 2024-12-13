package com.sleepai.iotserver.controller;

import com.sleepai.iotserver.model.SensorData;
import com.sleepai.iotserver.repositories.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sensordata")
public class SensorDataController {

    @Autowired
    private SensorDataRepository repository;

    @GetMapping
    public List<SensorData> getAllSensorData() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorData> getSensorDataById(@PathVariable String id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SensorData createSensorData(@RequestBody SensorData sensorData) {
        sensorData.setCreatedAt(java.time.Instant.now());
        sensorData.setUpdatedAt(java.time.Instant.now());
        return repository.save(sensorData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorData> updateSensorData(@PathVariable String id, @RequestBody SensorData sensorData) {
        return repository.findById(id)
                .map(existingData -> {
                    sensorData.setId(existingData.getId());
                    sensorData.setCreatedAt(existingData.getCreatedAt());
                    sensorData.setUpdatedAt(java.time.Instant.now());
                    return ResponseEntity.ok(repository.save(sensorData));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensorData(@PathVariable String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


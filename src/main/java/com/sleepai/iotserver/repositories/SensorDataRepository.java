package com.sleepai.iotserver.repositories;

import com.sleepai.iotserver.model.SensorData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorDataRepository extends MongoRepository<SensorData, String> {
    List<SensorData> findAllByeHumanPresenceGreaterThan(int present);
}

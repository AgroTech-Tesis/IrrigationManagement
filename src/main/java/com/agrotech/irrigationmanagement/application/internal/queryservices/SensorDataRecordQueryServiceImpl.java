package com.agrotech.irrigationmanagement.application.internal.queryservices;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecord;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecordAverage;
import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecordListAverage;
import com.agrotech.irrigationmanagement.domain.model.queries.GetSensorDataRecordAllQuery;
import com.agrotech.irrigationmanagement.domain.services.SensorDataRecordQueryService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.ISensorDataRecordRepository;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.SensorDataRecordResource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SensorDataRecordQueryServiceImpl implements SensorDataRecordQueryService {
    private final ISensorDataRecordRepository sensorDataRecordRepository;

    public SensorDataRecordQueryServiceImpl(ISensorDataRecordRepository sensorDataRecordRepository) {
        this.sensorDataRecordRepository = sensorDataRecordRepository;
    }

    @Override
    public List<SensorDataRecord> handle(GetSensorDataRecordAllQuery query) {
        return sensorDataRecordRepository.getPagination(query.startDate(), query.endDate(), query.zoneId(), query.typeSensor());
    }
    @Override
    public List<SensorDataRecordAverage> handle() {
        List<SensorDataRecordListAverage> sensorDataRecords = sensorDataRecordRepository.getAverage().stream()
                .map(tuple -> new SensorDataRecordListAverage(
                        tuple.get(0, Long.class),
                        tuple.get(1, LocalDateTime.class),
                        tuple.get(2, Double.class),
                        tuple.get(3, String.class),
                        tuple.get(4, Long.class),
                        tuple.get(5, String.class),
                        tuple.get(6, String.class)))
                .collect(Collectors.toList());
        // Mapa para almacenar los valores de los sensores agrupados por dispositivo
        Map<String, Map<String, List<Double>>> deviceSensorValues = new HashMap<>();

        // Recorremos todos los registros y agrupamos por dispositivo y tipo de sensor
        sensorDataRecords.forEach(sensorDataRecord -> {
            String deviceId = sensorDataRecord.getDeviceId();
            String sensorType = sensorDataRecord.getTypeSensor();

            // Si no existe el dispositivo en el mapa, lo creamos
            deviceSensorValues.putIfAbsent(deviceId, new HashMap<>());
            // Si no existe el tipo de sensor para ese dispositivo, lo creamos
            deviceSensorValues.get(deviceId).putIfAbsent(sensorType, new ArrayList<>());
            // Añadimos el valor del sensor al tipo de sensor correspondiente del dispositivo
            deviceSensorValues.get(deviceId).get(sensorType).add(sensorDataRecord.getLastValue());
        });

        // Lista para almacenar los promedios por dispositivo
        List<SensorDataRecordAverage> sensorAveragesPerDevice = new ArrayList<>();

        // Calculamos los promedios de los sensores para cada dispositivo
        deviceSensorValues.forEach((deviceId, sensorTypeValues) -> {
            Double sensor1Avg = sensorTypeValues.getOrDefault("SENSOR DE CAUDAL", List.of(0.0))
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);

            Double sensor2Avg = sensorTypeValues.getOrDefault("SENSOR DE HUMEDAD", List.of(0.0))
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);

            Double sensor3Avg = sensorTypeValues.getOrDefault("SENSOR DE TEMPERATURA", List.of(0.0))
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);

            // Creamos un nuevo objeto SensorDataRecordAverage con los promedios
            sensorAveragesPerDevice.add(new SensorDataRecordAverage(sensor1Avg, sensor2Avg, sensor3Avg));
        });

        return sensorAveragesPerDevice;
    }
}

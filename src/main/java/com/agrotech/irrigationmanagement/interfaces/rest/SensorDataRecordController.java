package com.agrotech.irrigationmanagement.interfaces.rest;

import com.agrotech.irrigationmanagement.domain.model.queries.GetNotificationAllQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetSensorDataRecordAllQuery;
import com.agrotech.irrigationmanagement.domain.services.SensorDataRecordQueryService;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.SensorDataRecordResource;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.NotificationResourceFromEntityAssembler;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.SensorDataRecordMapperResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("sensor-data-records")
public class SensorDataRecordController {
    private final SensorDataRecordQueryService sensorDataRecordService;

    public SensorDataRecordController(SensorDataRecordQueryService sensorDataRecordService) {
        this.sensorDataRecordService = sensorDataRecordService;
    }

    @GetMapping("/pagination")
    @Operation(tags = {"SensorDataRecord"})
    public ResponseEntity<List<SensorDataRecordResource>> G(@RequestParam(name = "startDate", required = false) String startDate,
                            @RequestParam(name = "endDate", required = false) String endDate,
                            @RequestParam(name = "zoneId", required = false) String zoneId,
                            @RequestParam(name = "typeSensor", required = false) String typeSensor){
        var getSensorDataRecordAllQuery = new GetSensorDataRecordAllQuery(startDate, endDate, zoneId, typeSensor);
        var sensorDataList = sensorDataRecordService.handle(getSensorDataRecordAllQuery);

        var sensorDataRecordResources = sensorDataList.stream().map(SensorDataRecordMapperResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(sensorDataRecordResources);
    }
}

package com.agrotech.irrigationmanagement.interfaces.rest;

import com.agrotech.irrigationmanagement.domain.model.aggregates.SensorDataRecordAverage;
import com.agrotech.irrigationmanagement.domain.model.queries.GetNotificationAllQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetSensorDataRecordAllQuery;
import com.agrotech.irrigationmanagement.domain.services.SensorDataRecordCommandService;
import com.agrotech.irrigationmanagement.domain.services.SensorDataRecordQueryService;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateRiceCropResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateSensorDataResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.RiceCropResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.SensorDataRecordResource;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("sensor-data-records")
public class SensorDataRecordController {
    private final SensorDataRecordQueryService sensorDataRecordService;
    private final SensorDataRecordCommandService sensorDataRecordCommandService;

    public SensorDataRecordController(SensorDataRecordQueryService sensorDataRecordService, SensorDataRecordCommandService sensorDataRecordCommandService) {
        this.sensorDataRecordService = sensorDataRecordService;
        this.sensorDataRecordCommandService = sensorDataRecordCommandService;
    }

    @GetMapping("/pagination")
    @Operation(tags = {"SensorDataRecord"})
    public ResponseEntity<List<SensorDataRecordResource>> pagination(@RequestParam(name = "startDate", required = false) String startDate,
                            @RequestParam(name = "endDate", required = false) String endDate,
                            @RequestParam(name = "zoneId", required = false) String zoneId,
                            @RequestParam(name = "typeSensor", required = false) String typeSensor){
        var getSensorDataRecordAllQuery = new GetSensorDataRecordAllQuery(startDate, endDate, zoneId, typeSensor);
        var sensorDataList = sensorDataRecordService.handle(getSensorDataRecordAllQuery);

        var sensorDataRecordResources = sensorDataList.stream().map(SensorDataRecordMapperResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(sensorDataRecordResources);
    }
    @GetMapping("/average")
    @Operation(tags = {"SensorDataRecord"})
    public ResponseEntity<List<SensorDataRecordAverage>> average(){
        var sensorDataList = sensorDataRecordService.handle();
        return ResponseEntity.ok(sensorDataList);
    }
    @PostMapping("")
    @Operation(tags = {"SensorDataRecord"})
    public ResponseEntity<SensorDataRecordResource> createReview(@RequestBody CreateSensorDataResource createSensorDataResource){
        var createSensorDataCommand = CreateSensorDataCommandFromResourceAssembler.toResourceFromEntity(createSensorDataResource);
        var sensorDataRecord = sensorDataRecordCommandService.handle(createSensorDataCommand);
        if (sensorDataRecord.isEmpty()) return ResponseEntity.badRequest().build();
        var sensorDataRecordResource = SensorDataResourceFromEntityAssembler.toResourceFromEntity(sensorDataRecord.get());
        return ResponseEntity.ok(sensorDataRecordResource);
    }
}

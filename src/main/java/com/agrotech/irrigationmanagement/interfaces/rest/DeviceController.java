package com.agrotech.irrigationmanagement.interfaces.rest;

import com.agrotech.irrigationmanagement.domain.model.queries.GetDeviceByZoneIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetRiceCropByIdQuery;
import com.agrotech.irrigationmanagement.domain.services.DeviceCommandService;
import com.agrotech.irrigationmanagement.domain.services.DeviceQueryService;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateDeviceResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.DeviceResource;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.CreateDeviceCommandFromResourceAssembler;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.DeviceResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("devices")
public class DeviceController {
    private final DeviceCommandService deviceService;
    private final DeviceQueryService deviceQueryService;

    public DeviceController(DeviceCommandService deviceService, DeviceQueryService deviceQueryService) {
        this.deviceService = deviceService;
        this.deviceQueryService = deviceQueryService;
    }
    @GetMapping("")
    @Operation(tags = {"Device"})
    public ResponseEntity<List<DeviceResource>> getAll(){
        var devices = deviceQueryService.handle();
        var deviceResources = devices.stream().map(DeviceResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(deviceResources);
    }

    @GetMapping("/zones/{zoneId}")
    @Operation(tags = {"Device"})
    public ResponseEntity<List<DeviceResource>> getAllByZoneId(@PathVariable("zoneId") Long zoneId){
        var getDevicesByZoneIdQuery = new GetDeviceByZoneIdQuery(zoneId);
        var devices = deviceQueryService.handle(getDevicesByZoneIdQuery);
        if (devices.isEmpty()) return ResponseEntity.badRequest().build();

        var deviceResources = devices.stream().map(DeviceResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(deviceResources);
    }

    @PostMapping("/zones")
    @Operation(tags = {"Device"})
    public ResponseEntity<DeviceResource> createReview(@RequestBody CreateDeviceResource createDeviceResource){
        var createDeviceCommand = CreateDeviceCommandFromResourceAssembler.toResourceFromEntity(createDeviceResource);
        var device = deviceService.handle(createDeviceCommand);

        if (device.isEmpty()) return ResponseEntity.badRequest().build();
        var deviceResource = DeviceResourceFromEntityAssembler.toResourceFromEntity(device.get());
        return new ResponseEntity<>(deviceResource, HttpStatus.CREATED);
    }

    @GetMapping("/rice-crops/{riceCropId}")
    @Operation(tags = {"Device"})
    public String devicesIot(@PathVariable("riceCropId") Long riceCropId){
        var getRiceCrop = new GetRiceCropByIdQuery(riceCropId);
        return deviceService.devicesIot(getRiceCrop);
    }
}

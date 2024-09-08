package com.agrotech.irrigationmanagement.interfaces.rest;

import com.agrotech.irrigationmanagement.domain.model.queries.GetZoneAllByRiceCropIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetZoneByIdQuery;
import com.agrotech.irrigationmanagement.domain.services.ZoneCommandService;
import com.agrotech.irrigationmanagement.domain.services.ZoneQueryService;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateZoneResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.ZoneResource;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.CreateZoneCommandFromResourceAssembler;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.ZoneResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("zones")
public class ZoneController {
    private final ZoneCommandService zoneCommandService;
    private final ZoneQueryService zoneQueryService;

    public ZoneController(ZoneCommandService zoneCommandService, ZoneQueryService zoneQueryService) {
        this.zoneCommandService = zoneCommandService;
        this.zoneQueryService = zoneQueryService;
    }

    @GetMapping("/{zoneId}")
    @Operation(tags = {"Zone"})
    public ResponseEntity<ZoneResource> getAllByUserId(@PathVariable("zoneId") Long zoneId){
        var getZoneByIdQuery = new GetZoneByIdQuery(zoneId);
        var zone = zoneQueryService.handle(getZoneByIdQuery);
        if (zone.isEmpty()) return ResponseEntity.badRequest().build();
        var zoneResource = ZoneResourceFromEntityAssembler.toResourceFromEntity(zone.get());
        return ResponseEntity.ok(zoneResource);
    }
    @GetMapping("")
    @Operation(tags = {"Zone"})
    public ResponseEntity<List<ZoneResource>> getAll(){
        var zones = zoneQueryService.handle();

        var zoneResources = zones.stream().map(ZoneResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(zoneResources);
    }
    @GetMapping("/rice-crops/{riceCropId}")
    @Operation(tags = {"Zone"})
    public ResponseEntity<List<ZoneResource>> getAllByRiceCropId(@PathVariable("riceCropId") Long riceCropId){

        var getZoneAllByRiceCropIdQuery = new GetZoneAllByRiceCropIdQuery(riceCropId);
        var zones = zoneQueryService.handle(getZoneAllByRiceCropIdQuery);

        var zoneResources = zones.stream().map(ZoneResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(zoneResources);
    }

    @PostMapping("")
    @Operation(tags = {"Zone"})
    public ResponseEntity<ZoneResource> createReview(@RequestBody CreateZoneResource createZoneDto){
        var createZoneCommand = CreateZoneCommandFromResourceAssembler.toResourceFromEntity(createZoneDto);
        var zone = zoneCommandService.handle(createZoneCommand);

        if (zone.isEmpty()) return ResponseEntity.badRequest().build();
        var deviceResource = ZoneResourceFromEntityAssembler.toResourceFromEntity(zone.get());
        return new ResponseEntity<>(deviceResource, HttpStatus.CREATED);
    }
}

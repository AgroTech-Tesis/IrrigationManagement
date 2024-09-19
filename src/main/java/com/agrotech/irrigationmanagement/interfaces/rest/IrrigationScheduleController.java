package com.agrotech.irrigationmanagement.interfaces.rest;

import com.agrotech.irrigationmanagement.Util.Shared.Constants.constants.Constants;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateIrrigationScheduleCommand;
import com.agrotech.irrigationmanagement.domain.model.queries.GetAllIrrigationScheduleByRiceCropIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationAllByRiceCropIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationScheduleByIdQuery;
import com.agrotech.irrigationmanagement.domain.services.IrrigationCommandService;
import com.agrotech.irrigationmanagement.domain.services.IrrigationQueryService;
import com.agrotech.irrigationmanagement.domain.services.IrrigationScheduleCommandService;
import com.agrotech.irrigationmanagement.domain.services.IrrigationScheduleQueryService;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.*;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("irrigation-schedules")
public class IrrigationScheduleController {
    private final IrrigationScheduleQueryService irrigationScheduleQueryService;
    private final IrrigationScheduleCommandService irrigationScheduleCommandService;

    public IrrigationScheduleController(IrrigationScheduleQueryService irrigationScheduleQueryService, IrrigationScheduleCommandService irrigationScheduleCommandService) {
        this.irrigationScheduleQueryService = irrigationScheduleQueryService;
        this.irrigationScheduleCommandService = irrigationScheduleCommandService;
    }

    @GetMapping("/rice-crops/{riceCropId}")
    @Operation(tags = {"IrrigationSchedule"})
    public ResponseEntity<List<IrrigationScheduleResource>> getAllIrrigationScheduleByRiceCropId(@PathVariable("riceCropId") Long riceCropId, @RequestParam(value = "status", required = false) String status){
        var getAllIrrigationScheduleByRiceCropIdQuery = new GetAllIrrigationScheduleByRiceCropIdQuery(riceCropId, status);
        var irrigationList = irrigationScheduleQueryService.handle(getAllIrrigationScheduleByRiceCropIdQuery);

        var irrigationScheduleResources = irrigationList.stream().map(IrrigationScheduleResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(irrigationScheduleResources);
    }
    @GetMapping("/{irrigationScheduleId}")
    @Operation(tags = {"IrrigationSchedule"})
    public ResponseEntity<IrrigationScheduleResource> getIrrigationScheduleById(@PathVariable("irrigationScheduleId") Long riceCropId){
        var getIrrigationScheduleByIdQuery = new GetIrrigationScheduleByIdQuery(riceCropId);
        var irrigationSchedule = irrigationScheduleQueryService.handle(getIrrigationScheduleByIdQuery);

        if (irrigationSchedule.isEmpty()) return ResponseEntity.badRequest().build();
        var irrigationScheduleResource = IrrigationScheduleResourceFromEntityAssembler.toResourceFromEntity(irrigationSchedule.get());
        return ResponseEntity.ok(irrigationScheduleResource);
    }

    @PostMapping("")
    @Operation(tags = {"IrrigationSchedule"})
    public ResponseEntity<IrrigationScheduleResource> createIrrigation(@RequestBody CreateIrrigationScheduleResource createIrrigationResource){
        var createIrrigation = CreateIrrigationScheduleCommandFromResourceAssembler.toResourceFromEntity(createIrrigationResource);
        var irrigation = irrigationScheduleCommandService.handle(createIrrigation);
        if (irrigation.isEmpty()) return ResponseEntity.badRequest().build();
        var irrigationResource = IrrigationScheduleResourceFromEntityAssembler.toResourceFromEntity(irrigation.get());
        return ResponseEntity.ok(irrigationResource);
    }
    @DeleteMapping("")
    @Operation(tags = {"IrrigationSchedule"})
    public ResponseEntity<IrrigationScheduleResource> deleteScheduleIrrigation(@RequestBody DeleteIrrigationScheduleResource deleteIrrigationScheduleResource){
        var createIrrigation = DeleteIrrigationScheduleCommandFromResourceAssembler.toResourceFromEntity(deleteIrrigationScheduleResource);
        var irrigation = irrigationScheduleCommandService.handle(createIrrigation);
        if (irrigation.isEmpty()) return ResponseEntity.badRequest().build();
        var irrigationResource = IrrigationScheduleResourceFromEntityAssembler.toResourceFromEntity(irrigation.get());
        return ResponseEntity.ok(irrigationResource);
    }
    @PutMapping("")
    @Operation(tags = {"IrrigationSchedule"})
    public ResponseEntity<IrrigationScheduleResource> updateScheduleIrrigation(@RequestBody UpdateIrrigationScheduleResource createIrrigationResource){
        var createIrrigation = UpdateIrrigationScheduleCommandFromResourceAssembler.toResourceFromEntity(createIrrigationResource);
        var irrigation = irrigationScheduleCommandService.handle(createIrrigation);
        if (irrigation.isEmpty()) return ResponseEntity.badRequest().build();
        var irrigationResource = IrrigationScheduleResourceFromEntityAssembler.toResourceFromEntity(irrigation.get());
        return ResponseEntity.ok(irrigationResource);
    }
}

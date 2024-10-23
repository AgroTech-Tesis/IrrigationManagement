package com.agrotech.irrigationmanagement.interfaces.rest;

import com.agrotech.irrigationmanagement.Util.Shared.Constants.constants.Constants;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationAllByRiceCropIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetZoneByIdQuery;
import com.agrotech.irrigationmanagement.domain.services.IrrigationCommandService;
import com.agrotech.irrigationmanagement.domain.services.IrrigationQueryService;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateIrrigationResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.IrrigationResource;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.CreateIrrigationCommandFromResourceAssembler;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.CreateZoneCommandFromResourceAssembler;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.IrrigationResourceFromEntityAssembler;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.ZoneResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("irrigation")
public class IrrigationController {
    private final IrrigationQueryService irrigationService;
    private final IrrigationCommandService irrigationCommandService;

    public IrrigationController(IrrigationQueryService irrigationService, IrrigationCommandService irrigationCommandService) {
        this.irrigationService = irrigationService;
        this.irrigationCommandService = irrigationCommandService;
    }

    @GetMapping("/{irrigationId}")
    @Operation(tags = {"Irrigation"})
    public ResponseEntity<IrrigationResource> getAllById(@PathVariable("irrigationId") Long irrigationId){
        var getIrrigationByIdQuery = new GetIrrigationByIdQuery(irrigationId);
        var irrigation = irrigationService.handle(getIrrigationByIdQuery);
        if (irrigation.isEmpty()) return ResponseEntity.badRequest().build();
        var irrigationResource = IrrigationResourceFromEntityAssembler.toResourceFromEntity(irrigation.get());
        return ResponseEntity.ok(irrigationResource);
    }
    @GetMapping("")
    @Operation(tags = {"Irrigation"})
    public ResponseEntity<List<IrrigationResource>> getAll(){
        var irrigationList = irrigationService.handle();

        var irrigationResources = irrigationList.stream().map(IrrigationResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(irrigationResources);
    }
    @GetMapping("/rice-crops/{riceCropId}")
    @Operation(tags = {"Irrigation"})
    public ResponseEntity<IrrigationResource> getAllByRiceCropId(@PathVariable("riceCropId") Long riceCropId,
                                        @RequestParam(value = "status", defaultValue = Constants.STATUS_ACTIVE) String status){
        var getIrrigationAllByRiceCropIdQuery = new GetIrrigationAllByRiceCropIdQuery(riceCropId, status);
        var irrigation = irrigationService.handle(getIrrigationAllByRiceCropIdQuery);

        var irrigationResource = IrrigationResourceFromEntityAssembler.toResourceFromEntity(irrigation);
        return ResponseEntity.ok(irrigationResource);
    }

    @PostMapping("")
    @Operation(tags = {"Irrigation"})
    public ResponseEntity<IrrigationResource> createIrrigation(@RequestBody CreateIrrigationResource createIrrigationResource){
        var createIrrigation = CreateIrrigationCommandFromResourceAssembler.toResourceFromEntity(createIrrigationResource);
        var irrigation = irrigationCommandService.handle(createIrrigation);
        if (irrigation.isEmpty()) return ResponseEntity.badRequest().build();
        var irrigationResource = IrrigationResourceFromEntityAssembler.toResourceFromEntity(irrigation.get());
        return ResponseEntity.ok(irrigationResource);
    }
    @PutMapping("{irrigationId}")
    @Operation(tags = {"Irrigation"})
    public ResponseEntity<IrrigationResource> UpdateIrrigation(@PathVariable("irrigationId") Long irrigationId, @RequestBody IrrigationResource irrigationResource){
        var updateIrrigation = irrigationCommandService.handle(irrigationId, irrigationResource);
        if (updateIrrigation.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var irrigationResource1 = IrrigationResourceFromEntityAssembler.toResourceFromEntity(updateIrrigation.get());
        return ResponseEntity.ok(irrigationResource1);
    }
}

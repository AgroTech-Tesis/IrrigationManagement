package com.agrotech.irrigationmanagement.interfaces.rest;

import com.agrotech.irrigationmanagement.Util.Shared.Constants.constants.Constants;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationByIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetRiceCropByFarmerIdAndStatusQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetRiceCropByIdQuery;
import com.agrotech.irrigationmanagement.domain.services.RiceCropCommandService;
import com.agrotech.irrigationmanagement.domain.services.RiceCropQueryService;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.CreateRiceCropResource;
import com.agrotech.irrigationmanagement.interfaces.rest.resources.RiceCropResource;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.CreateIrrigationCommandFromResourceAssembler;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.CreateRiceCropCommandFromResourceAssembler;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.IrrigationResourceFromEntityAssembler;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.RiceCropResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("rice-crops")
public class RiceCropsController {
    private final RiceCropCommandService riceCropsService;
    private final RiceCropQueryService riceCropQueryService;

    public RiceCropsController(RiceCropCommandService riceCropsService, RiceCropQueryService riceCropQueryService) {
        this.riceCropsService = riceCropsService;
        this.riceCropQueryService = riceCropQueryService;
    }

    @GetMapping("/{riceCropsId}")
    @Operation(tags = {"RiceCrops"})
    public ResponseEntity<RiceCropResource> getById(@PathVariable("riceCropsId") Long riceCropsId){
        var getRiceCropByIdQuery = new GetRiceCropByIdQuery(riceCropsId);
        var riceCrop = riceCropQueryService.handle(getRiceCropByIdQuery);
        if (riceCrop.isEmpty()) return ResponseEntity.badRequest().build();
        var irrigationResource = RiceCropResourceFromEntityAssembler.toResourceFromEntity(riceCrop.get());
        return ResponseEntity.ok(irrigationResource);
    }
    @GetMapping("/farmer/{farmerId}")
    @Operation(tags = {"RiceCrops"})
    public ResponseEntity<RiceCropResource> getByFarmerId(@PathVariable("farmerId") Long farmerId,
                                      @RequestParam(name = "status", required = false, defaultValue = Constants.STATUS_ACTIVE) String status){
        var getRiceCropByIdQuery = new GetRiceCropByFarmerIdAndStatusQuery(farmerId, status);
        var riceCrop = riceCropQueryService.handle(getRiceCropByIdQuery);
        if (riceCrop.isEmpty()) return ResponseEntity.badRequest().build();
        var irrigationResource = RiceCropResourceFromEntityAssembler.toResourceFromEntity(riceCrop.get());
        return ResponseEntity.ok(irrigationResource);
    }
    @GetMapping("")
    @Operation(tags = {"RiceCrops"})
    public ResponseEntity<List<RiceCropResource>> getAll(){
        var riceCropList = riceCropQueryService.handle();

        var riceCropResourceList = riceCropList.stream().map(RiceCropResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(riceCropResourceList);
    }

    @PostMapping("")
    @Operation(tags = {"RiceCrops"})
    public ResponseEntity<RiceCropResource> createReview(@RequestBody CreateRiceCropResource createRiceCropResource){
        var createRiceCropCommand = CreateRiceCropCommandFromResourceAssembler.toResourceFromEntity(createRiceCropResource);
        System.out.println(createRiceCropCommand.farmerId());
        var riceCrop = riceCropsService.handle(createRiceCropCommand);
        if (riceCrop.isEmpty()) return ResponseEntity.badRequest().build();
        var riceCropResource = RiceCropResourceFromEntityAssembler.toResourceFromEntity(riceCrop.get());
        return ResponseEntity.ok(riceCropResource);
    }
}

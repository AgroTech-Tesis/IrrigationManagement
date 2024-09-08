package com.agrotech.irrigationmanagement.application.internal.commandservices;

import com.agrotech.irrigationmanagement.Util.Shared.Constants.constants.Constants;
import com.agrotech.irrigationmanagement.domain.model.IotCloud.FarmerDto;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Actuator;
import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.domain.model.commands.CreateRiceCropCommand;
import com.agrotech.irrigationmanagement.domain.services.RiceCropCommandService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IRiceCropsRepository;
import com.agrotech.irrigationmanagement.interfaces.rest.Client.SecurityRESTClient;
import com.agrotech.irrigationmanagement.interfaces.rest.transform.RiceCropFromCreateRiceCropCommand;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class RiceCropCommandServiceImpl implements RiceCropCommandService {

    private final SecurityRESTClient securityRESTClient;
    private final IRiceCropsRepository riceCropsRepository;

    public RiceCropCommandServiceImpl(SecurityRESTClient securityRESTClient, IRiceCropsRepository riceCropsRepository) {
        this.securityRESTClient = securityRESTClient;
        this.riceCropsRepository = riceCropsRepository;
    }

    @Override
    public Optional<RiceCrop> handle(CreateRiceCropCommand command) {
        if(command.farmerId() == null)
            throw new IllegalArgumentException("Not found Farmer Id");
        FarmerDto farmer = securityRESTClient.getFarmerById(command.farmerId());
        if(farmer == null)
            throw new IllegalArgumentException("Not found Farmer");
        var riceCrop = RiceCropFromCreateRiceCropCommand.toResourceFromEntity(command);
        try {
            riceCrop.setStatus(Constants.STATUS_ACTIVE);
            riceCrop.setCreatedAt(LocalDateTime.now(ZoneId.of(Constants.TIME_ZONE_DEFAULT)));
            return Optional.of(riceCropsRepository.save(riceCrop));
        }catch (Exception e){
            throw new IllegalArgumentException("Error: ", e);
        }
    }
}

package com.agrotech.irrigationmanagement.application.internal.queryservices;

import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.domain.model.queries.GetRiceCropByFarmerIdAndStatusQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetRiceCropByIdQuery;
import com.agrotech.irrigationmanagement.domain.services.RiceCropQueryService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IRiceCropsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiceCropQueryServiceImpl implements RiceCropQueryService {
    private final IRiceCropsRepository riceCropsRepository;

    public RiceCropQueryServiceImpl(IRiceCropsRepository riceCropsRepository) {
        this.riceCropsRepository = riceCropsRepository;
    }

    @Override
    public List<RiceCrop> handle() {
        return riceCropsRepository.findAll();
    }

    @Override
    public Optional<RiceCrop> handle(GetRiceCropByFarmerIdAndStatusQuery query) {
        return Optional.of(riceCropsRepository.getFirstByFarmerIdAndStatus(query.farmerId(), query.status()));
    }

    @Override
    public Optional<RiceCrop> handle(GetRiceCropByIdQuery query) {
        return Optional.of(riceCropsRepository.findById(query.id()).orElse(null));
    }
}

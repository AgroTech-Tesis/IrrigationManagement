package com.agrotech.irrigationmanagement.application.internal.queryservices;

import com.agrotech.irrigationmanagement.domain.model.aggregates.Device;
import com.agrotech.irrigationmanagement.domain.model.aggregates.Irrigation;
import com.agrotech.irrigationmanagement.domain.model.aggregates.RiceCrop;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationAllByRiceCropIdQuery;
import com.agrotech.irrigationmanagement.domain.model.queries.GetIrrigationByIdQuery;
import com.agrotech.irrigationmanagement.domain.services.IrrigationQueryService;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IIrrigationRepository;
import com.agrotech.irrigationmanagement.infraestructure.persistence.jpa.IRiceCropsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IrrigationQueryServiceImpl implements IrrigationQueryService {
    private final IIrrigationRepository irrigationRepository;
    private final IRiceCropsRepository riceCropsRepository;

    public IrrigationQueryServiceImpl(IIrrigationRepository irrigationRepository, IRiceCropsRepository riceCropsRepository) {
        this.irrigationRepository = irrigationRepository;
        this.riceCropsRepository = riceCropsRepository;
    }

    @Override
    public List<Irrigation> handle() {
        return irrigationRepository.findAll();
    }

    @Override
    public Irrigation handle(GetIrrigationAllByRiceCropIdQuery query) {
        RiceCrop riceCrop = riceCropsRepository.findById(query.riceCropId()).orElse(null);
        if(riceCrop == null)
            throw new IllegalArgumentException("Error");
        try{
            Irrigation irrigation = irrigationRepository.getFirstByRiceCropIdAndStatus(query.riceCropId(), query.status());

            if(irrigation == null)
                return irrigationRepository.findFirstByRiceCropIdOrderByIdDesc(query.riceCropId());
            else
                return irrigation;
        }catch (Exception e){
            throw new IllegalArgumentException("Error");
        }
    }

    @Override
    public Optional<Irrigation> handle(GetIrrigationByIdQuery query) {
        return Optional.of(irrigationRepository.findIrrigationEntitiesById(query.id()));
    }

}

package com.agrotech.irrigationmanagement.domain.services;

import com.agrotech.irrigationmanagement.domain.model.IotCloud.DashboardDTO;
import com.agrotech.irrigationmanagement.domain.model.IotCloud.DeviceIotDTO;
import com.agrotech.irrigationmanagement.domain.model.IotCloud.ThingDTO;
import com.agrotech.irrigationmanagement.domain.model.IotCloud.TokenDTO;

import java.util.List;

public interface IotCloudCommandService {
    List<ThingDTO> getThing();
    List<DashboardDTO> getDashboard();
    List<DeviceIotDTO> getDevices();
    TokenDTO getTokenIot();
}

package com.agrotech.irrigationmanagement.interfaces.rest.Client;


import com.agrotech.irrigationmanagement.Util.Shared.Constants.constants.Constants;
import com.agrotech.irrigationmanagement.domain.model.IotCloud.DashboardDTO;
import com.agrotech.irrigationmanagement.domain.model.IotCloud.DeviceIotDTO;
import com.agrotech.irrigationmanagement.domain.model.IotCloud.ThingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "iot-cloud", url = Constants.IOT_API_URL, path = "")
public interface IotRESTClient {
    @GetMapping("/devices")
    List<DeviceIotDTO> getDevices(@RequestHeader HttpHeaders headers);

    @GetMapping("/dashboards")
    List<DashboardDTO> getDashboard(@RequestHeader HttpHeaders headers);

    @GetMapping("/thing")
    List<ThingDTO> getThing(@RequestHeader HttpHeaders headers);
}
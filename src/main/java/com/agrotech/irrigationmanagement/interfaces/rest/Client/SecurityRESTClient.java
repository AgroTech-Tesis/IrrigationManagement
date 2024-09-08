package com.agrotech.irrigationmanagement.interfaces.rest.Client;

import com.agrotech.irrigationmanagement.Util.Shared.Constants.constants.Constants;
import com.agrotech.irrigationmanagement.domain.model.IotCloud.FarmerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@FeignClient(name = "security", url = Constants.URL_SECURITY ,path = "farmer")
public interface SecurityRESTClient {
    @PostMapping("/account/{accountId}")
    FarmerDto getFarmerByAccountId(
            @PathVariable("accountId") Long accountId);

    @GetMapping("/{farmerId}")
    FarmerDto getFarmerById(
            @PathVariable("farmerId") Long farmerId);
}
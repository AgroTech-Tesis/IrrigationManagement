package com.agrotech.irrigationmanagement.interfaces.rest.Client;

import com.agrotech.irrigationmanagement.Util.Shared.Constants.constants.Constants;
import com.agrotech.irrigationmanagement.domain.model.IotCloud.CredentialTokenDTO;
import com.agrotech.irrigationmanagement.domain.model.IotCloud.TokenDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "iot-token", url = Constants.TOKEN_URL ,path = "token")
public interface TokenRESTClient {
    @PostMapping("")
    TokenDTO getToken(
            @RequestBody CredentialTokenDTO credentialTokenDTO);
}
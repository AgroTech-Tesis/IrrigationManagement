package com.agrotech.irrigationmanagement.domain.model.IotCloud;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CredentialTokenDTO {
    private String grant_type;
    private String client_id;
    private String client_secret;
    private String audience;
    private String tokenUrl;
}
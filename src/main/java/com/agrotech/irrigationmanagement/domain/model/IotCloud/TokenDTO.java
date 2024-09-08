package com.agrotech.irrigationmanagement.domain.model.IotCloud;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
    private String access_token;
    private String expires_in;
    private String token_type;
}

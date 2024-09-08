package com.agrotech.irrigationmanagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record FarmerResource(Long id, LocalDateTime name, LocalDateTime address, LocalDateTime phoneNumber) {
}
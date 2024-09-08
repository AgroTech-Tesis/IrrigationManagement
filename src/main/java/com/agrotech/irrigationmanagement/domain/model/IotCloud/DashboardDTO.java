package com.agrotech.irrigationmanagement.domain.model.IotCloud;

import lombok.*;

import java.util.List;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDTO {
    private UserDTO createdBy;
    private String id;
    private String name;
    private String updatedAt;
    private List<WidgetDTO> widgets;
}
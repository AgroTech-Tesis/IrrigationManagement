package com.agrotech.irrigationmanagement.domain.model.IotCloud;

import lombok.*;

import java.util.List;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class WidgetDTO {
    private String id;
    private String name;
    private String type;
    private OptionsDTO options;
    private List<VariableDTO> variables;
    private DimensionsDTO dimensions;
}
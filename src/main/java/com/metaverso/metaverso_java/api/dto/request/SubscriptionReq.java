package com.metaverso.metaverso_java.api.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionReq {
    @NotBlank(message = "el nombre es requerido")
    @Size(min=1,max=100,
            message = "el nombre debe tener entre 1 y 100 caracteres")
    private String name;
    @NotBlank(message = "descripcion requerida")
    private String description;
    @NotBlank(message = "precio requerido")
    @DecimalMin(value = "0.01",message = "el valor debe ser mayor a cero")
    private BigDecimal price;
    @NotBlank(message = "fecha de inicio requerida")
    private LocalDate startDate;
    @NotBlank(message = "fecha de finalizacion requerida")
    private LocalDate endDate;

}

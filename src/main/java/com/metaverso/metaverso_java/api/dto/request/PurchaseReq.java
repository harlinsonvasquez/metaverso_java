package com.metaverso.metaverso_java.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseReq {
    @NotBlank (message = "La ciudad es requerida")
    private String city;
    @FutureOrPresent
    @NotBlank(message = "La fecha y la hora son requeridas")
    private LocalDateTime purchaseDay;
    @NotNull (message = "El id user es obigatorio")
    @Min(value = 1, message = "El id debe ser mayor a 0")
    private Long userId;
}

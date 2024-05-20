package com.metaverso.metaverso_java.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductSubscriptionReq {
    @NotNull(message = "el id del producto es requerido")
    private Long productId;
    @NotNull(message = "el id de la subscription es requerido")
    private Long subscriptionId;

}

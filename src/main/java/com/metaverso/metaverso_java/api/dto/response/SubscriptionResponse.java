package com.metaverso.metaverso_java.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate startDate;
    private LocalDate endDate;

    private List<ProductBasicResp> productResps;
}

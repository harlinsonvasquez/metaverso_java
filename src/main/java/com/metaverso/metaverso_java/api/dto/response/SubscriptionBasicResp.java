package com.metaverso.metaverso_java.api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.metaverso.metaverso_java.utils.enums.CategorySubscription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionBasicResp {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate startDate;
    private LocalDate endDate;
    private CategorySubscription category;

}

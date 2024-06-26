package com.metaverso.metaverso_java.api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SubscriptionBasicResp {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate startDate;
    private LocalDate endDate;
}

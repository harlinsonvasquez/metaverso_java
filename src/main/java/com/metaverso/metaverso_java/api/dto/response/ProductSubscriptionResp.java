package com.metaverso.metaverso_java.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductSubscriptionResp {
    private Long id;
    private ProductResp products;
    private SubscriptionBasicResp subscriptions;
}

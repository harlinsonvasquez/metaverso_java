package com.metaverso.metaverso_java.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResp {
    private Long id;
    private String city;
    private LocalDateTime purchaseDay;
    private List<ProductBasicResp> productBasicResp;
    private UserBasicResp userBasicResp;
}

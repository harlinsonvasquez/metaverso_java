package com.metaverso.metaverso_java.api.dto.response;

import java.time.LocalDateTime;

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
    private UserBasicResp users;
}

package com.metaverso.metaverso_java.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBasicResp {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String city;
    private  SubscriptionBasicResp subscription;
    private List<PurchaseBasicResp> purchases;
}

package com.metaverso.metaverso_java.api.dto.response;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResp {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String city;
    private  SubscriptionBasicResp subscription;

}

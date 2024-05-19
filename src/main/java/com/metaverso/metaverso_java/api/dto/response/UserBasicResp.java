package com.metaverso.metaverso_java.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}

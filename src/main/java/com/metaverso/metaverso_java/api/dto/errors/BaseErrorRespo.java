package com.metaverso.metaverso_java.api.dto.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
//serializable clse especial para responder por http
public class BaseErrorRespo  implements Serializable {
    private String status;
    private Integer code;
}
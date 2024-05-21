package com.metaverso.metaverso_java.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReq {
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 0, max = 100)
    private String name;
    @NotBlank(message = "El apellido es requerido")
    @Size(min = 0, max = 100)
    private String lastName;
    @NotBlank(message = "El email es requerido")
    private String email;
    @NotBlank(message = "La ciudadrequerida")
    private String city;
    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 0, max = 100)   
    private String password;
    private Long subscriptionId;

}

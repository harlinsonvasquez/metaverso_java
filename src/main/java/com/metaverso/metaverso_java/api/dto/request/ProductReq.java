package com.metaverso.metaverso_java.api.dto.request;

import com.metaverso.metaverso_java.utils.enums.CategoryProduct;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductReq {
    @NotBlank(message = "el nombre del producto es requerido")
    @Size(min=3,max=100,
    message = "el nombre debe tener entre 1 y 100 caracteres")
    private String name;

    @NotBlank(message = "la descripcion del producto es requerido")
    private String description;

    @NotNull(message = "la categoria del producto es requerido")
    private CategoryProduct categoryProduct;

    @DecimalMin(value = "0.01",message = "el valor debe ser mayor a cero")
    private BigDecimal price;

    @NotBlank(message = "el link del producto es requerido")
    private String link;
    @NotBlank(message = "el link de la imagen del  producto es requerido")
    private String image;

}

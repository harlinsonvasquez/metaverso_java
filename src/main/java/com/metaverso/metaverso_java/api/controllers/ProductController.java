package com.metaverso.metaverso_java.api.controllers;

import com.metaverso.metaverso_java.api.dto.response.ProductResp;
import com.metaverso.metaverso_java.infrastructure.abstract_services.IProductService;
import com.metaverso.metaverso_java.utils.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path="/Product")
@AllArgsConstructor
public class ProductController {
    //al controlador le inyectamos la interfaz IProduct
    @Autowired
    private  final IProductService ProductService;
    @GetMapping
    public ResponseEntity<Page<ProductResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestHeader(required = false) SortType sortType
    ){

        if (Objects.isNull(sortType)) sortType = SortType.NONE;

        return ResponseEntity.ok(this.ProductService.getAll(page -1, size, sortType));
    }

}

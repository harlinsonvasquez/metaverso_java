package com.metaverso.metaverso_java.api.controllers;

import com.metaverso.metaverso_java.api.dto.request.ProductReq;
import com.metaverso.metaverso_java.api.dto.response.ProductResp;
import com.metaverso.metaverso_java.infrastructure.abstract_services.IProductService;
import com.metaverso.metaverso_java.utils.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    @PostMapping
    public ResponseEntity<ProductResp>insert(
            @Validated
            @RequestBody ProductReq request
            ){
        return ResponseEntity.ok(this.ProductService.create(request));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductResp>get(@PathVariable Long id){
        return ResponseEntity.ok(this.ProductService.get(id));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductResp>update(@Validated @RequestBody
                                             ProductReq request,
                                             @PathVariable Long id){
        return  ResponseEntity.ok(this.ProductService.update(request,id));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        this.ProductService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

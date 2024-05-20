package com.metaverso.metaverso_java.api.controllers;

import com.metaverso.metaverso_java.api.dto.response.ProductResp;
import com.metaverso.metaverso_java.api.dto.response.ProductSubscriptionResp;
import com.metaverso.metaverso_java.infrastructure.abstract_services.IProductSubscriptionService;
import com.metaverso.metaverso_java.utils.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/ProductSubscription")
@AllArgsConstructor
public class ProductSubscriptionController {
    @Autowired
    private final IProductSubscriptionService productSubscriptionService;

    @GetMapping
    public ResponseEntity<Page<ProductSubscriptionResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestHeader(required = false) SortType sortType
    ){

        if (Objects.isNull(sortType)) sortType = SortType.NONE;

        return ResponseEntity.ok(this.productSubscriptionService.getAll(page -1, size, sortType));
    }
}

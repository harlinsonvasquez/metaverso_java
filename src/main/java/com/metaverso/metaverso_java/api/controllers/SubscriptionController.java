package com.metaverso.metaverso_java.api.controllers;

import com.metaverso.metaverso_java.api.dto.response.ProductResp;
import com.metaverso.metaverso_java.api.dto.response.SubscriptionResponse;
import com.metaverso.metaverso_java.infrastructure.abstract_services.ISubscriptionService;
import com.metaverso.metaverso_java.utils.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "/Subscription")
@AllArgsConstructor
public class SubscriptionController {
    @Autowired
    private final ISubscriptionService SubscriptionService;
    @GetMapping
    public ResponseEntity<Page<SubscriptionResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestHeader(required = false) SortType sortType
    ){

        if (Objects.isNull(sortType)) sortType = SortType.NONE;

        return ResponseEntity.ok(this.SubscriptionService.getAll(page -1, size, sortType));
    }
}

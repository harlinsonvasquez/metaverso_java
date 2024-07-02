package com.metaverso.metaverso_java.api.controllers;

import com.metaverso.metaverso_java.api.dto.request.SubscriptionReq;
import com.metaverso.metaverso_java.api.dto.response.ProductResp;
import com.metaverso.metaverso_java.api.dto.response.SubscriptionBasicResp;
import com.metaverso.metaverso_java.api.dto.response.SubscriptionResponse;
import com.metaverso.metaverso_java.infrastructure.abstract_services.ISubscriptionService;
import com.metaverso.metaverso_java.utils.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    @PostMapping
    public ResponseEntity<SubscriptionResponse>
    insert(@Validated
           @RequestBody SubscriptionReq request
    ){
        return ResponseEntity.ok(this.SubscriptionService.create(request));
    }
   /* @GetMapping(path = "/{id}")
    public ResponseEntity<SubscriptionResponse>get(@PathVariable Long id){
        return ResponseEntity.ok(this.SubscriptionService.get(id));
    }*/
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        this.SubscriptionService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<SubscriptionResponse>update(@Validated @RequestBody
                                                      SubscriptionReq request,
                                                      @PathVariable Long id
    ){
        return ResponseEntity.ok(this.SubscriptionService.update(request,id));

    }
    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionResponse> getSubscriptionWithProducts(@PathVariable Long id) {
        return ResponseEntity.ok(SubscriptionService.getSubscriptionWithProducts(id));
    }

}

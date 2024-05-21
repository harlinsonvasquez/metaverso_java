package com.metaverso.metaverso_java.api.controllers;

import com.metaverso.metaverso_java.api.dto.request.UserReq;
import com.metaverso.metaverso_java.api.dto.response.ProductResp;
import com.metaverso.metaverso_java.api.dto.response.UserBasicResp;
import com.metaverso.metaverso_java.api.dto.response.UserResp;
import com.metaverso.metaverso_java.infrastructure.abstract_services.IUserService;
import com.metaverso.metaverso_java.utils.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "/User")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final IUserService userService;
    @GetMapping
    public ResponseEntity<Page<UserResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType
    ){

        if (Objects.isNull(sortType)) sortType = SortType.NONE;

        return ResponseEntity.ok(this.userService.getAll(page -1, size, sortType));
    }
    @PostMapping
    public ResponseEntity<UserResp>insert(@Validated @RequestBody UserReq request){
        return ResponseEntity.ok(this.userService.create(request));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResp>update(@Validated
                                          @RequestBody
                                          UserReq request,
                                          @PathVariable Long id){
        return ResponseEntity.ok(this.userService.update(request,id));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/purchases")
    public ResponseEntity<UserBasicResp> getUserWithPurchases(@PathVariable Long id) {
        UserBasicResp userResp = userService.getUserWithPurchase(id);
        if (userResp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userResp);
    }
}

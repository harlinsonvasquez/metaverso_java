package com.metaverso.metaverso_java.infrastructure.services;

import com.metaverso.metaverso_java.api.dto.request.ProductSubscriptionReq;
import com.metaverso.metaverso_java.api.dto.response.ProductSubscriptionResp;
import com.metaverso.metaverso_java.domain.repositories.ProductSubscriptionRepository;
import com.metaverso.metaverso_java.infrastructure.abstract_services.IProductSubscriptionService;
import com.metaverso.metaverso_java.utils.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductSubscriptionService  implements IProductSubscriptionService {
    @Autowired
    private final ProductSubscriptionRepository productSubscriptionRepository;

    @Override
    public ProductSubscriptionResp create(ProductSubscriptionReq request) {
        return null;
    }

    @Override
    public ProductSubscriptionResp get(Long aLong) {
        return null;
    }

    @Override
    public ProductSubscriptionResp update(ProductSubscriptionReq request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<ProductSubscriptionResp> getAll(int page, int size, SortType sort) {
        return null;
    }
}

package com.metaverso.metaverso_java.infrastructure.services;

import com.metaverso.metaverso_java.api.dto.request.ProductSubscriptionReq;
import com.metaverso.metaverso_java.api.dto.response.ProductBasicResp;
import com.metaverso.metaverso_java.api.dto.response.ProductSubscriptionResp;
import com.metaverso.metaverso_java.api.dto.response.SubscriptionBasicResp;
import com.metaverso.metaverso_java.domain.entities.Product;
import com.metaverso.metaverso_java.domain.entities.ProductSubscription;
import com.metaverso.metaverso_java.domain.entities.Subscription;
import com.metaverso.metaverso_java.domain.repositories.ProductRepository;
import com.metaverso.metaverso_java.domain.repositories.ProductSubscriptionRepository;
import com.metaverso.metaverso_java.domain.repositories.SubscriptionRepository;
import com.metaverso.metaverso_java.infrastructure.abstract_services.IProductSubscriptionService;
import com.metaverso.metaverso_java.utils.enums.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductSubscriptionService  implements IProductSubscriptionService {
    @Autowired
    private final ProductSubscriptionRepository productSubscriptionRepository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final SubscriptionRepository subscriptionRepository;

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
        if(page<0)page=0;
        PageRequest pagination=null;
        switch (sort){
            case NONE -> pagination=PageRequest.of(page,size);
            case ASC -> pagination=PageRequest.of(page,size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination=PageRequest.of(page,size,Sort.by(FIELD_BY_SORT).descending());
        }
        return this.productSubscriptionRepository.findAll(pagination).map(this::entityToResp);
    }
    private ProductSubscriptionResp entityToResp(ProductSubscription entity) {
        ProductSubscriptionResp response = new ProductSubscriptionResp();
        response.setId(entity.getId());

        ProductBasicResp productBasicResp = new ProductBasicResp();
        BeanUtils.copyProperties(entity.getProduct(), productBasicResp);
        response.setProducts(productBasicResp);

        SubscriptionBasicResp subscriptionBasicResp = new SubscriptionBasicResp();
        BeanUtils.copyProperties(entity.getSubscription(), subscriptionBasicResp);
        response.setSubscriptions(subscriptionBasicResp);

        return response;
    }
}

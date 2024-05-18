package com.metaverso.metaverso_java.infrastructure.services;

import com.metaverso.metaverso_java.api.dto.request.SubscriptionReq;
import com.metaverso.metaverso_java.api.dto.response.ProductResp;
import com.metaverso.metaverso_java.api.dto.response.SubscriptionResponse;
import com.metaverso.metaverso_java.domain.entities.Product;
import com.metaverso.metaverso_java.domain.entities.Subscription;
import com.metaverso.metaverso_java.domain.repositories.SubscriptionRepository;
import com.metaverso.metaverso_java.infrastructure.abstract_services.ISubscriptionService;
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
public class SubscriptionService implements ISubscriptionService {
    @Autowired
    private final SubscriptionRepository subscriptionRepository;
    @Override
    public SubscriptionResponse create(SubscriptionReq request) {
        return null;
    }

    @Override
    public SubscriptionResponse get(Long aLong) {
        return null;
    }

    @Override
    public SubscriptionResponse update(SubscriptionReq request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<SubscriptionResponse> getAll(int page, int size, SortType sort) {

        if(page<0)page=0;

        PageRequest pagination=null;
        switch (sort){
            case NONE -> pagination=PageRequest.of(page,size);
            case ASC -> pagination=PageRequest.of(page,size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination=PageRequest.of(page,size,Sort.by(FIELD_BY_SORT).descending());
        }
        return this.subscriptionRepository.findAll(pagination).map(this::entityToResponse);
    }
    //metodo para convertir de product a productResponse porque la pagination recibe es un response
    private SubscriptionResponse entityToResponse(Subscription entity){
        SubscriptionResponse response=new SubscriptionResponse();
        BeanUtils.copyProperties(entity,response);
        return response;


    }
}

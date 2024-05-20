package com.metaverso.metaverso_java.infrastructure.services;

import com.metaverso.metaverso_java.api.dto.request.SubscriptionReq;
import com.metaverso.metaverso_java.api.dto.response.ProductResp;
import com.metaverso.metaverso_java.api.dto.response.ProductBasicResp;
import com.metaverso.metaverso_java.api.dto.response.SubscriptionBasicResp;
import com.metaverso.metaverso_java.api.dto.response.SubscriptionResponse;
import com.metaverso.metaverso_java.domain.entities.Product;
import com.metaverso.metaverso_java.domain.entities.ProductSubscription;
import com.metaverso.metaverso_java.domain.entities.Subscription;
import com.metaverso.metaverso_java.domain.repositories.SubscriptionRepository;
import com.metaverso.metaverso_java.infrastructure.abstract_services.ISubscriptionService;
import com.metaverso.metaverso_java.utils.enums.SortType;
import com.metaverso.metaverso_java.utils.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubscriptionService implements ISubscriptionService {
    @Autowired
    private final SubscriptionRepository subscriptionRepository;
    @Override
    public SubscriptionResponse create(SubscriptionReq request) {
        Subscription subscription=this.requestToEntity(request);
        return this.entityToResp(this.subscriptionRepository.save(subscription));
    }
    private Subscription requestToEntity(SubscriptionReq request){
        return Subscription.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .category(request.getCategory())
                .build();
    }

    @Override
    public SubscriptionResponse get(Long id) {
        return this.entityToResp(this.find(id));
    }

    @Override
    public SubscriptionResponse update(SubscriptionReq request, Long id) {
        Subscription subscription=this.find(id);
        subscription.setName(request.getName());
        subscription.setDescription(request.getDescription());
        subscription.setCategory(request.getCategory());
        subscription.setPrice(request.getPrice());
        subscription.setStartDate(request.getStartDate());
        subscription.setEndDate(request.getEndDate());


        return this.entityToResp(this.subscriptionRepository.save(subscription));
    }

    @Override
    public void delete(Long id) {
      Subscription subscription=this.find(id);
      this.subscriptionRepository.delete(subscription);

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
        return this.subscriptionRepository.findAll(pagination).map(this::entityToResp);
    }
    //metodo para convertir de product a productResponse porque la pagination recibe es un response
    private SubscriptionResponse entityToResp(Subscription entity){
        SubscriptionResponse response=new SubscriptionResponse();
        BeanUtils.copyProperties(entity,response);
        return response;


    }
    private Subscription find(Long id){
        return this.subscriptionRepository.findById(id)
                .orElseThrow(()->  new BadRequestException("bo hay registros con ese id"));
    }
    public SubscriptionResponse getSubscriptionWithProducts(Long id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Subscription not found"));

        SubscriptionResponse response = new SubscriptionResponse();
        BeanUtils.copyProperties(subscription, response);

        List<ProductBasicResp> products = subscription.getProductSubscriptions().stream()
                .map(ps -> {
                    ProductBasicResp productResp = new ProductBasicResp();
                    BeanUtils.copyProperties(ps.getProduct(), productResp);
                    return productResp;
                })
                .collect(Collectors.toList());

        response.setProducts(products);
        return response;
    }
}

package com.metaverso.metaverso_java.infrastructure.services;

import com.metaverso.metaverso_java.api.dto.request.ProductReq;
import com.metaverso.metaverso_java.api.dto.response.ProductBasicResp;
import com.metaverso.metaverso_java.api.dto.response.ProductResp;
import com.metaverso.metaverso_java.api.dto.response.SubscriptionBasicResp;
import com.metaverso.metaverso_java.domain.entities.Product;
import com.metaverso.metaverso_java.domain.repositories.ProductRepository;
import com.metaverso.metaverso_java.infrastructure.abstract_services.IProductService;
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
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ProductService implements IProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Override
    public ProductResp create(ProductReq request) {
        Product product=this.requestToEntity(request);

        return this.entityToResp(this.productRepository.save(product));
    }
    private Product requestToEntity(ProductReq request){
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .categoryProduct(request.getCategoryProduct())
                .price(request.getPrice())
                .image(request.getImage())
                .link(request.getLink())
                .build();
    }

    @Override
    public ProductResp get(Long id) {
        return this.entityToResp(this.find(id));
    }

    @Override
    public ProductResp update(ProductReq request, Long id) {
        Product product=this.find(id);
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategoryProduct(request.getCategoryProduct());
        product.setPrice(request.getPrice());
        product.setLink(request.getLink());
        product.setImage(request.getImage());

        return this.entityToResp(this.productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        Product product=this.find(id);
        this.productRepository.delete(product);

    }

    @Override
    public Page<ProductResp> getAll(int page, int size, SortType sort) {
        if(page<0)page=0;
        PageRequest pagination=null;
        switch (sort){
            case NONE -> pagination=PageRequest.of(page,size);
            case ASC -> pagination=PageRequest.of(page,size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination=PageRequest.of(page,size,Sort.by(FIELD_BY_SORT).descending());
        }
        return this.productRepository.findAll(pagination).map(this::entityToResp);
    }
    //metodo para convertir de product a productResponse porque la pagination recibe es un response
    private ProductResp entityToResp(Product entity){
        ProductResp response=new ProductResp();
        BeanUtils.copyProperties(entity,response);
        return response;

    }

    private Product find(Long id){
        return this.productRepository.findById(id)
                .orElseThrow(()-> new BadRequestException("no hay registros del id suministrado"));
    }
    public ProductBasicResp getProductWithSubscriptions(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Product not found"));

        ProductBasicResp response = new ProductBasicResp();
        BeanUtils.copyProperties(product, response);

        Set<SubscriptionBasicResp> subscriptions = product.getProductSubscriptions().stream()
                .map(ps -> {
                    SubscriptionBasicResp subscriptionResp = new SubscriptionBasicResp();
                    BeanUtils.copyProperties(ps.getSubscription(), subscriptionResp);
                    return subscriptionResp;
                })
                .collect(Collectors.toSet());

        response.setSubscriptions(subscriptions);
        return response;
    }
}

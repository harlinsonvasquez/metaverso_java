package com.metaverso.metaverso_java.infrastructure.services;

import com.metaverso.metaverso_java.api.dto.request.ProductReq;
import com.metaverso.metaverso_java.api.dto.response.ProductResp;
import com.metaverso.metaverso_java.domain.entities.Product;
import com.metaverso.metaverso_java.domain.repositories.ProductRepository;
import com.metaverso.metaverso_java.infrastructure.abstract_services.IProductService;
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

public class ProductService implements IProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Override
    public ProductResp create(ProductReq request) {
        return null;
    }

    @Override
    public ProductResp get(Long aLong) {
        return null;
    }

    @Override
    public ProductResp update(ProductReq request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

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

        /*return ProductResp.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .category(entity.getCategory())
                .price(entity.getPrice())
                .link(entity.getLink())
                .image(entity.getImage())
                .build();*/
    }
}

package com.metaverso.metaverso_java.infrastructure.abstract_services;

import com.metaverso.metaverso_java.api.dto.request.ProductReq;
import com.metaverso.metaverso_java.api.dto.response.ProductBasicResp;
import com.metaverso.metaverso_java.api.dto.response.ProductResp;

public interface IProductService extends CrudService<ProductReq, ProductResp,Long>{
    public final String FIELD_BY_SORT = "price";
    ProductBasicResp getProductWithSubscriptions(Long id);
}

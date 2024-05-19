package com.metaverso.metaverso_java.infrastructure.abstract_services;

import com.metaverso.metaverso_java.api.dto.request.ProductSubscriptionReq;
import com.metaverso.metaverso_java.api.dto.response.ProductSubscriptionResp;

public interface IProductSubscriptionService
        extends CrudService<ProductSubscriptionReq, ProductSubscriptionResp,Long>{
    public String FIELD_BY_SORT = "id";
}

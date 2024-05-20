package com.metaverso.metaverso_java.infrastructure.abstract_services;

import com.metaverso.metaverso_java.api.dto.request.SubscriptionReq;
import com.metaverso.metaverso_java.api.dto.response.SubscriptionResponse;

public interface ISubscriptionService  extends CrudService <SubscriptionReq, SubscriptionResponse,Long>{
    public String FIELD_BY_SORT = "name";
}

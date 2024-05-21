package com.metaverso.metaverso_java.infrastructure.abstract_services;

import com.metaverso.metaverso_java.api.dto.request.UserReq;
import com.metaverso.metaverso_java.api.dto.response.ProductBasicResp;
import com.metaverso.metaverso_java.api.dto.response.UserBasicResp;
import com.metaverso.metaverso_java.api.dto.response.UserResp;

public interface IUserService extends CrudService <UserReq,UserResp,Long>{

    public UserResp getById(Long id);
    public String FIELD_BY_SORT = "name";
   UserBasicResp getUserWithPurchase(Long id);
}

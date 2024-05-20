package com.metaverso.metaverso_java.infrastructure.abstract_services;

import com.metaverso.metaverso_java.api.dto.request.UserReq;
import com.metaverso.metaverso_java.api.dto.response.UserResp;

public interface IUserService extends CrudService <UserReq,UserResp,Long>{

    public UserResp getById(Long id);
}

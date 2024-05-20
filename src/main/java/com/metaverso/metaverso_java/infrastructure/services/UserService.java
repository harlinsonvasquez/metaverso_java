package com.metaverso.metaverso_java.infrastructure.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.metaverso.metaverso_java.api.dto.request.UserReq;
import com.metaverso.metaverso_java.api.dto.response.UserResp;
import com.metaverso.metaverso_java.domain.entities.User;
import com.metaverso.metaverso_java.domain.repositories.PurchaseRepository;
import com.metaverso.metaverso_java.domain.repositories.UserRepository;
import com.metaverso.metaverso_java.infrastructure.abstract_services.IUserService;
import com.metaverso.metaverso_java.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PurchaseRepository purchaseRepository;
    
    @Override
    public UserResp create(UserReq request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public UserResp get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public UserResp update(UserReq request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<UserResp> getAll(int page, int size, SortType sort) {
        if (page < 0) 
            page = 0;
        //Creacion de paginacion
        PageRequest pagination = PageRequest .of(page, size);

        return this.purchaseRepository.findAll(pagination).map(null);
    }

    @Override
    public UserResp getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    //Creamos la instancia de la respuesta
    private UserResp entityToResp (User user){

        UserResp resp = new UserResp();

        //Copiamos las propiedades del dto de la entidad con respuesta
        BeanUtils.copyProperties(user, resp);

        UserResp purchaResp = new UserResp();

        //copiamos las propiedades de la entida en el dto de respuesta

        return purchaResp;
    }
}

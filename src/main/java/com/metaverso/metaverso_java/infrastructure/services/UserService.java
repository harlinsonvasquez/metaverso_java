package com.metaverso.metaverso_java.infrastructure.services;

import com.metaverso.metaverso_java.api.dto.request.UserReq;
import com.metaverso.metaverso_java.api.dto.response.*;
import com.metaverso.metaverso_java.domain.entities.Purchase;
import com.metaverso.metaverso_java.domain.entities.PurchaseProduct;
import com.metaverso.metaverso_java.domain.entities.Subscription;
import com.metaverso.metaverso_java.domain.entities.User;
import com.metaverso.metaverso_java.domain.repositories.PurchaseRepository;
import com.metaverso.metaverso_java.domain.repositories.SubscriptionRepository;
import com.metaverso.metaverso_java.domain.repositories.UserRepository;
import com.metaverso.metaverso_java.infrastructure.abstract_services.IUserService;
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
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final SubscriptionRepository subscriptionRepository;
    @Autowired
    private final PurchaseRepository purchaseRepository;

    @Override
    public UserResp getById(Long id) {
        return null;
    }

    @Override
    public UserResp create(UserReq request) {
        User user = this.requestToEntity(request);
        return this.entityToResp(this.userRepository.save(user));
    }

    private User requestToEntity(UserReq request) {
        User.UserBuilder userBuilder = User.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .city(request.getCity())
                .email(request.getEmail())
                .password(request.getPassword());

        if (request.getSubscriptionId() != null) {
            Subscription subscription = subscriptionRepository.findById(request.getSubscriptionId()).orElse(null);
            userBuilder.subscription(subscription);
        }

        return userBuilder.build();
    }

    @Override
    public UserResp get(Long aLong) {
        return null;
    }

    @Override
    public UserResp update(UserReq request, Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    BeanUtils.copyProperties(request, user, "id");
                    if (request.getSubscriptionId() != null) {
                        Subscription subscription = subscriptionRepository.findById(request.getSubscriptionId()).orElse(null);
                        user.setSubscription(subscription);
                    }
                    user = userRepository.save(user);
                    return entityToResp(user);
                }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        User user = this.find(id);
        this.userRepository.delete(user);
    }

    @Override
    public Page<UserResp> getAll(int page, int size, SortType sort) {
        if (page < 0) page = 0;
        PageRequest pagination = null;
        switch (sort) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }
        return this.userRepository.findAll(pagination).map(this::entityToResp);
    }

    private UserResp entityToResp(User entity) {
        UserResp response = new UserResp();
        BeanUtils.copyProperties(entity, response);
        if (entity.getSubscription() != null) {
            SubscriptionBasicResp subscriptionBasicResp = new SubscriptionBasicResp();
            BeanUtils.copyProperties(entity.getSubscription(), subscriptionBasicResp);
            response.setSubscription(subscriptionBasicResp);
        }
        return response;
    }

    private User find(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("no hay registros del id suministrado"));
    }

    @Override
    public UserBasicResp getUserWithPurchase(Long id) {
        User user = userRepository.findUserWithPurchasesAndProducts(id);
        if (user == null) {
            return null; // O puedes lanzar una excepción personalizada
        }

        UserBasicResp response = userToBasicResp(user);
        List<PurchaseBasicResp> purchaseResponses = user.getPurchases().stream()
                .map(this::purchaseBasicToResp)
                .collect(Collectors.toList());

        response.setPurchases(purchaseResponses);
        return response;
    }

    private UserBasicResp userToBasicResp(User user) {
        UserBasicResp response = new UserBasicResp();
        BeanUtils.copyProperties(user, response);
        if (user.getSubscription() != null) {
            SubscriptionBasicResp subscriptionResp = new SubscriptionBasicResp();
            BeanUtils.copyProperties(user.getSubscription(), subscriptionResp);
            response.setSubscription(subscriptionResp);
        }
        return response;
    }

    private PurchaseBasicResp purchaseBasicToResp(Purchase purchase) {
        PurchaseBasicResp response = new PurchaseBasicResp();
        BeanUtils.copyProperties(purchase, response);
        List<ProductResp> productResponses = purchase.getPurchaseProducts().stream()
                .map(purchaseProduct -> {
                    ProductResp productResp = new ProductResp();
                    BeanUtils.copyProperties(purchaseProduct.getProduct(), productResp);
                    return productResp;
                })
                .collect(Collectors.toList());

        response.setProducts(productResponses);
        return response;
    }
}

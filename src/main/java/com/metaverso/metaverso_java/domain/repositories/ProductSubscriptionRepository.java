package com.metaverso.metaverso_java.domain.repositories;

import com.metaverso.metaverso_java.domain.entities.ProductSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductSubscriptionRepository extends JpaRepository<ProductSubscription,Long> {
    @Query(value = "select ps from productSubscription ps join fetch ps.product p where p.id= :idProduct")
    Optional<ProductSubscription>findByProductId(Long idProduct);
}

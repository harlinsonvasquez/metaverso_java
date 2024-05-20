package com.metaverso.metaverso_java.domain.entities;

import com.metaverso.metaverso_java.utils.enums.CategoryProduct;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;
    @Lob
    @Column(nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    private CategoryProduct categoryProduct;

    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private String link;
    @Column(nullable = false)
    private String image;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
   @OneToMany(
           fetch = FetchType.EAGER,
           mappedBy = "product",
           cascade = CascadeType.ALL,
           orphanRemoval = true
   )
   private List<ProductSubscription> productSubscriptions;


}

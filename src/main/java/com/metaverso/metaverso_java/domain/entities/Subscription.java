package com.metaverso.metaverso_java.domain.entities;

import com.metaverso.metaverso_java.utils.enums.CategorySubscription;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "subscription")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Lob
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private CategorySubscription category;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "subscription"
    )
    private List<ProductSubscription> productSubscriptions;

}

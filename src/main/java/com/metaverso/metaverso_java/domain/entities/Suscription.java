package com.metaverso.metaverso_java.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "suscription")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suscription {
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
    private LocalDate starDate;
    @Column(nullable = false)
    private LocalDate endDate;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "suscription",
            cascade = CascadeType.ALL,
            orphanRemoval = false

    )
    private List<SuscriptionProduct> suscriptionProducts;

}

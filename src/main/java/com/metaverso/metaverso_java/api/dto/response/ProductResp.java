
package com.metaverso.metaverso_java.api.dto.response;

import com.metaverso.metaverso_java.domain.entities.Subscription;
import com.metaverso.metaverso_java.utils.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResp {
    private Long id;
    private String name;
    private String description;
    private Category category;
    private BigDecimal price;
    private String link;
    private String image;
    private List<SubscriptionBasicResp>subscriptions;


}
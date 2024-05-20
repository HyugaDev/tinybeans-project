package com.tinybeans.backend.evaluation.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author danrodrigues
 * Date: 13/5/22
 */
@Entity @Data @ToString(exclude={"paymentId"})
@EqualsAndHashCode(callSuper = true)
@Builder @AllArgsConstructor @NoArgsConstructor
@Table(name = "Orders_Table")
public class Orders extends BaseEntity {

    @JsonIgnore
    @ManyToMany
    private List<Item> items;

    @Column(scale = 2, precision = 5)
    private BigDecimal subTotal, discount, finalPrice;

    private String paymentId;

}

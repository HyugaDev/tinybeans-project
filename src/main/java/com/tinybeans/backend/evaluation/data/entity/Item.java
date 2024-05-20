package com.tinybeans.backend.evaluation.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author danrodrigues
 * Date: 13/5/22
 */
@Entity @Data @ToString
@Builder @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "Items_Table")
public class Item extends BaseEntity{

    private String name, description, photoUrl;

    private Double price;

    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    private List<Orders> orders;
}

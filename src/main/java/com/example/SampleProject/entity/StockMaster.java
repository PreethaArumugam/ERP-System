package com.example.SampleProject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stock_master")
public class StockMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "item_name")
    public String itemName;

    @Column(name = "price")
    public Double price;

    @Column(name = "quantity")
    public Long quantity;

    @Column(name = "size")
    public Long size;

    @Column(name = "product_no")
    public Long productNo;

    @Column(name = "code")
    public String code;

    @Column(name = "product_owner")
    public String productOwner;

    @Column(name = "stock_no", insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    public String stockNo;


}


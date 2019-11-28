package com.danya.oht.crm.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue
    private long id;
    private String name;

    public Order() {}

    public Order(String name) {
        this.name = name;
    }
}

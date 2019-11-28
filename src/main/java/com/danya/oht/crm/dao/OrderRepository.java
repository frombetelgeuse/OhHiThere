package com.danya.oht.crm.dao;

import com.danya.oht.crm.data.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

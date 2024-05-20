package com.tinybeans.backend.evaluation.repository;

import com.tinybeans.backend.evaluation.data.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}

package com.saga.choreography.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saga.choreography.entity.PurchaseOrder;

public interface OrderRepository extends JpaRepository<PurchaseOrder, Integer>{

}

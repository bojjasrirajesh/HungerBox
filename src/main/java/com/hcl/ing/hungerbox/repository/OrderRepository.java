package com.hcl.ing.hungerbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ing.hungerbox.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {

public	Orders findByOrderId(Long orderId);

@Query(value="select sum(total_price) from order_details where order_id=?",nativeQuery=true)
public	double getTotalAmount(Long OrderId);
	
}

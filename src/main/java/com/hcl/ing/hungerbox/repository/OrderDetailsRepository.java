package com.hcl.ing.hungerbox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ing.hungerbox.entity.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long>{

  @Query(value="select * from order_details where order_id=?",nativeQuery=true)
	public List<OrderDetails> findByOrderId(Long orderId);
}

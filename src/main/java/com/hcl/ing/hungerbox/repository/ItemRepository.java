package com.hcl.ing.hungerbox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.hungerbox.entity.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long>{
	
	List<Items> findByVendorId(Long vendorId);
	

}

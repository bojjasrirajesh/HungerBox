package com.hcl.ing.hungerbox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.hungerbox.entity.Items;
import com.hcl.ing.hungerbox.entity.Vendors;

@Repository
public interface VendorRepository extends JpaRepository<Vendors, Long>{
	
	List<Items> findByVendorId(Long vendorId);
	
	List<Items> findByUserId(Long userId);
}

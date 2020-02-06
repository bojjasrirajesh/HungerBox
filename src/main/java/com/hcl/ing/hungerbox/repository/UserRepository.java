package com.hcl.ing.hungerbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.hungerbox.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	
}

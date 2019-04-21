package com.online.om.inventory.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author capgemini
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
	List<ProductEntity> findByProductIdIn(List<String> productIds);
	
	
}

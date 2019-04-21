package com.online.om.inventory.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author capgemini
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
}

package com.talch.inventoryList.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talch.inventoryList.beans.Inventory;

/**
 * 
 * @author Talch
 *
 */

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Long> {

	
}

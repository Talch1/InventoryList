package com.talch.inventoryList.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talch.inventoryList.service.InventoryService;

/**
 * 
 * @author Talch
 *
 */

@RestController
@RequestMapping("/list")
public class InventoryController {
	
	@Autowired
	InventoryService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> details(@PathVariable long id) {
		if (service.getDetailsMap().containsKey(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(service.details(id));	
		}else {
			return new ResponseEntity<String>("this id is not exist",HttpStatus.BAD_REQUEST);
		}
	
	}

	
	
}

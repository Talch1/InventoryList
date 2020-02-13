package com.talch.inventoryList.rest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talch.inventoryList.beans.Inventory;
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
	
	@GetMapping(value = "/details/{id}")
	public ResponseEntity<?> details(@PathVariable long id) {
		if (service.getDetailsMap().containsKey(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(service.details(id));	
		}else {
			return new ResponseEntity<String>("this id is not exist",HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/deposite/{id}")
	public ResponseEntity<?> deposite(@PathVariable long id) {
		if (service.getDepositeMap().containsKey(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(service.deposite(id));	
		}else {
			return new ResponseEntity<String>("this id is not exist",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/withdrawal/{id}")
	public ResponseEntity<?> withdrawalMap(@PathVariable long id) {
		if (service.getWithdrawalMap().containsKey(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(service.withdrawal(id));	
		}else {
			return new ResponseEntity<String>("this id is not exist",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/add/{details}")
	public  ResponseEntity<?> add(@RequestBody Inventory item,@PathVariable String details){
		return ResponseEntity.status(HttpStatus.OK).body(service.addItem(item, details));	
	}
	@GetMapping(value = "/getItem/{id}")
	public  ResponseEntity<?> add(@PathVariable long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.getItem(id));	
	}
	
}

package com.talch.inventoryList.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/list")

public class InventoryController {

	@Autowired
	InventoryService service;

	// http://localhost:8080/list/details/{id}
	@GetMapping(value = "/details/{id}")
	public ResponseEntity<?> details(@PathVariable long id) {
		if (service.getDetailsMap().containsKey(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(service.details(id));
		} else {
			return new ResponseEntity<String>("This id is not exist", HttpStatus.BAD_REQUEST);
		}
	}
	
	// http://localhost:8080/list/deposite/{id}
	@GetMapping(value = "/deposite/{id}")
	public ResponseEntity<?> deposite(@PathVariable long id) {
		if (service.getDepositeMap().containsKey(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(service.deposite(id));
		} else {
			return new ResponseEntity<String>("This id is not exist", HttpStatus.BAD_REQUEST);
		}
	}

	// http://localhost:8080/list/withdrawal/{id}
	@GetMapping(value = "/withdrawal/{id}")
	public ResponseEntity<?> withdrawalMap(@PathVariable long id) {
		if (service.getWithdrawalMap().containsKey(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(service.withdrawal(id));
		} else {
			return new ResponseEntity<String>("This id is not exist", HttpStatus.BAD_REQUEST);
		}
	}

	// http://localhost:8080/list/take/{id}
	@GetMapping(value = "/take/{id}")
	public ResponseEntity<?> take(@PathVariable long id) {
		if (service.getWithdrawalMap().containsKey(id)) {
			service.takeItem(id);
			return ResponseEntity.status(HttpStatus.OK).body("Amount " + service.getItem(id).get().getAmount());
		} else {
			return new ResponseEntity<String>("This id is not exist", HttpStatus.BAD_REQUEST);
		}
	}
 // http://localhost:8080/list/add/{id}
	@GetMapping(value = "/add/{id}")
	public ResponseEntity<?> add(@PathVariable long id) {
		if (service.getWithdrawalMap().containsKey(id)) {
			service.addItem(id);
			return ResponseEntity.status(HttpStatus.OK).body("Amount " + service.getItem(id).get().getAmount());
		} else {
			return new ResponseEntity<String>("This id is not exist", HttpStatus.BAD_REQUEST);
		}
	}
	
	// http://localhost:8080/list/delete/{id}
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable long id) {
		if (((service.getItem(id)) != null)) {
			service.deleteItem(id);
			return ResponseEntity.status(HttpStatus.OK).body("Item was deleted");
		} else {
			return new ResponseEntity<String>("This id is exist,please choose another", HttpStatus.BAD_REQUEST);
		}

	}

	// http://localhost:8080/list/addNewItem/{details}
	@PostMapping(value = "/addNewItem/{details}")
	public ResponseEntity<?> addNewItem(@RequestBody Inventory item, @PathVariable String details) {
		if (!service.getItem(item.getId()).isPresent()) {

			return ResponseEntity.status(HttpStatus.OK).body(service.addNewItemToList(item, details));
		} else {
			return new ResponseEntity<String>("This id is exist,please choose another", HttpStatus.BAD_REQUEST);
		}

	}

	// http://localhost:8080/list/getItem/{id}
	@GetMapping(value = "/getItem/{id}")
	public ResponseEntity<?> get(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getItem(id));
	}

}

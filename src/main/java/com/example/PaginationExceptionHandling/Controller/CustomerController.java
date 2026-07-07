package com.example.PaginationExceptionHandling.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.PaginationExceptionHandling.Entity.Customers;
import com.example.PaginationExceptionHandling.Service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController

@RequestMapping("/customers")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping
	public Page<Customers> findPage(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size){
		return service.getAll(page, size);
	}
	
	@GetMapping("/{id}")
	public Customers getOne(@PathVariable Long id) {
		return service.getOneCustomer(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customers> updateCustomer(@PathVariable Long id, @org.springframework.web.bind.annotation.RequestBody Customers cus){
		return ResponseEntity.status(HttpStatus.OK).body(service.updateCustomer(id, cus));
	} 
		
	@PostMapping
    public Customers createCustomer(@RequestBody Customers customer) {
        return service.saveCustomer(customer);
    }
}

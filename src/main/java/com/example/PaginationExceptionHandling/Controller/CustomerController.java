package com.example.PaginationExceptionHandling.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.PaginationExceptionHandling.Entity.Customers;
import com.example.PaginationExceptionHandling.Service.CustomerService;

import lombok.AllArgsConstructor;

@RestControllerAdvice
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
}

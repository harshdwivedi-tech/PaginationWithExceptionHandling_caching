package com.example.PaginationExceptionHandling.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.PaginationExceptionHandling.Entity.Customers;
import com.example.PaginationExceptionHandling.Repository.CustomersRepository;
import com.example.PaginationExceptionHandling.error.CustomerNotFound;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	
		private CustomersRepository repo;
		
		public Page<Customers> getAll(int page, int size){
			Pageable pageable = PageRequest.of(page, size);
			return repo.findAll(pageable);
					
		}
		
		public Customers getOneCustomer(Long id) {
			return repo.findById(id).orElseThrow(() -> new CustomerNotFound("Customer not Found : " + id));
		}
}

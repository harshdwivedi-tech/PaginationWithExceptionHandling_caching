package com.example.PaginationExceptionHandling.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
		
	@Autowired
		private CustomersRepository repo;
		
		public Customers saveCustomer(Customers customer) {
	        return repo.save(customer);
	    }
		
		public Page<Customers> getAll(int page, int size){
			Pageable pageable = PageRequest.of(page, size);
			return repo.findAll(pageable);
					
		}
		
		@Cacheable(value = "customer", key = "#id")
		public Customers getOneCustomer(Long id) {
			return repo.findById(id).orElseThrow(() -> new CustomerNotFound("Customer not Found : " + id));
		}
		
		@CachePut(value = "customers", key = "#id")
		public Customers updateCustomer(Long id, Customers cus) {
			Customers c = repo.findById(id).orElseThrow(() -> new CustomerNotFound("Customer not found : " + id));
			c.setEmail(cus.getEmail());
			c.setFirstName(cus.getFirstName());
			c.setGender(cus.getGender());
			c.setLastName(cus.getLastName());
			
			
			return repo.save(c);
			
			
		}
}


//caching - > hashmap -> key , value
// 					customer | customer
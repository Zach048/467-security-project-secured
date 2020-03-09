/**
 * 
 */
package com.osu.capstone.project.unsecure.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.osu.capstone.project.unsecure.dao.CustomerDAO;
import com.osu.capstone.project.unsecure.dto.Customer;
import com.osu.capstone.project.unsecure.record.CustomerRecord;


/**
 * Responsible for providing the server-side RESTful interface for the {@link Customer} DTO.
 * 
 * @author Zach Earl
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO dao;
	
	@GetMapping("id/{customerId}")
	public CustomerRecord getCustomer(@PathVariable Integer customerId) {
		return dao.getCustomer(customerId);
	}
	
//	@PostMapping("new")
//	public void newCustomer(@RequestBody Customer c) {
//		dao.addCustomer(c);
//	}
//	
//	@PutMapping("update")
//	public void updateCustomer(@RequestBody Customer c) {
//		dao.updateCustomer(c);
//	}
//	
//	@PostMapping("login/{userName}")
//	public Integer login(@PathVariable String userName, @RequestBody String password) {
//		return dao.login(userName, password);
//	}

}

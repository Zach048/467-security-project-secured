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

import com.osu.capstone.project.unsecure.dao.AccountDAO;
import com.osu.capstone.project.unsecure.dto.Account;

/**
 * Responsible for providing the server-side RESTful interface for the {@link Account} DTO.
 * @author Zach Earl
 */
@RestController
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	AccountDAO dao;
	
	@GetMapping("id/{customerId}")
	public Account getAccount(@PathVariable Integer customerId) {
		return dao.getAccount(customerId);
	}
	
	@PostMapping("new")
	public void newAccount(@RequestBody Account a) {
		dao.addAccount(a);
	}
	
	@PutMapping("update")
	public void updateAccount(@RequestBody Account a) {
		dao.updateAccount(a);
	}
	
	@PostMapping("payCreditCard/{amountPaid}")
	public void payCreditCard(@PathVariable Double amountPaid, @RequestBody Account a) {
		dao.payBalance(amountPaid, a);
	}

}

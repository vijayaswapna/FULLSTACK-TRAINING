package com.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.AccountService;

@RestController
@RequestMapping(value = "account")
public class AccountController {

	
	@Autowired
	AccountService accountService;
	
	@GetMapping(value = "balance/{accno}")
	public String checkBalance(@PathVariable("accno") int accno) {
		return accountService.getBalance(accno);
	}
}

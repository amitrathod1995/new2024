package com.bank.controller;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bank.model.Account;
import com.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AccountService accountService;

	@GetMapping("/get-account-by-id")
	public Object getAccountId(@RequestParam int aid) {
		Object account = accountService.getAccountId(aid);
		logger.info(account.toString());
		return (account); //customerService.getCustomerId(id);
	}
	@SuppressWarnings("unchecked")
	@GetMapping("/get-account-by-accnum")
	public Object getAccnum(@RequestParam long accnum) {
		List<Account> account = (List<Account>) accountService.getAccnum(accnum);		
		logger.info(account.toString());
		return (account); 
	}
	
	@Transactional
	@PutMapping("/transaction/{accnumber}/{amount}")
	public String transaction(@PathVariable("accnumber") long accnumber, @PathVariable("amount") double amount)
	{
		return accountService.Transaction(amount, accnumber);
	}
	
	//hit this link on postman for withdraw.
	//http://localhost:8089/account/transaction/12345/-1000
	//---------------------//-------------------------------
	
	//hit this link on postman for deposite.
		//http://localhost:8089/account/transaction/12345/1000
	

}

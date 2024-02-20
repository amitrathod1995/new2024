package com.bank.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionInterface;

@Service
public class AccountService implements TransactionInterface{
	
	@Autowired
	AccountRepository accountRepository;

	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public Object getAccnum(long accnum) {
	
		@SuppressWarnings({ "unchecked", "unused" })
		List<Account> account = (List<Account>) accountRepository.findByAccnum(accnum);
		return accountRepository.findByAccnum(accnum);
	}

	public Object getAccountId(int id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id);
	}
	
	//hit this link on postman for withdraw.
		//http://localhost:8089/account/transaction/12345/-1000
		//---------------------//-------------------------------
		
		//hit this link on postman for deposite.
			//http://localhost:8089/account/transaction/12345/1000
	@Override
	public String Transaction(double amount, long accnumber) {
		Account account=accountRepository.findByAccnum(accnumber);
		if(account!=null)
		{
		
			if((amount<0))
			{
				
				if(account.getAccbal()>=(amount*(-1)))
				{
					account.setAccbal(account.getAccbal()+amount);
					accountRepository.save(account);
					System.out.println("Amount Withdraw  Successfully");
					return "Amount Withdraw  Successfully";
				}
				
				else {
					System.out.println("your balence is incuficient");
					return "your balence is incuficient";
				}
			}
			
			else {
				account.setAccbal(account.getAccbal()+amount);
				accountRepository.save(account);
				System.out.println("Amount Deposited Successfully");
				return "Amount Deposited Successfully";
			}
			
		}
		else {
			System.out.println("customer does not exists");
			return "customer does not exists";
		}
		
	}

}

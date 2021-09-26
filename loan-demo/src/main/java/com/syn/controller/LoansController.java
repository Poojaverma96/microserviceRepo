package com.syn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syn.model.Loan;
import com.syn.sevice.LoansService;




@RestController
//@RequestMapping("/api/customer/")
public class LoansController {
	@Autowired
	private LoansService loansService;
	/**
	 * 
	 * @param loans
	 * @return
	 */
	@PostMapping("/loans")
	public Loan loanData(@RequestBody Loan loans) {
		
		return loansService.loanInsert(loans);
		
	}
	/**
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public List<Loan> getLoan(){
		
		return loansService.getAllLoan();
	}
	/**
	 * 
	 * @param customerid
	 * @return
	 */
	@GetMapping("/{customer_id}/loans")
	public Loan getLoanByCustomerId(@PathVariable("customer_id") String customer_id) {
		return loansService.getLoanByCustomerId(customer_id);
	}
	/**
	 * 
	 * @param loanid
	 * @return
	 */
	@GetMapping("/{customer_id}/loans/{loan_id}")
	public Loan getByLoanIdAndCustId(@PathVariable("customer_id")String customer_id, @PathVariable("loan_id")Long loan_id) {
		return loansService.getByLoanAndCustomerId(customer_id,loan_id);
	}
	/**
	 * 
	 * @param loans
	 * @param customerid
	 * @param loanid
	 * @return
	 */
	@PutMapping("update/{customer_id}/loans/{loan_id}")
	public Loan updateLoan(@RequestBody Loan loans, @PathVariable("customer_id")String customer_id, @PathVariable("loan_id")Long loan_id) {
		Loan update=loansService.getByLoanAndCustomerId(customer_id,loan_id);
		update.setBalance_tenure(loans.getBalance_tenure());
		update.setAmount(loans.getAmount());
		return loansService.loanInsert(update);
	} 
	
	
}

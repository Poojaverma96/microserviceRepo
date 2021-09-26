package com.syn.sevice;

import java.util.List;

import com.syn.model.Loan;


public interface LoansService {

	Loan loanInsert(Loan loans);

	List<Loan> getAllLoan();

	Loan getLoanByCustomerId(String customer_id);

	Loan getByLoanAndCustomerId(String customer_id,Long loan_id);

	

	

}


package com.syn.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.syn.model.Loan;


@Repository
public interface LoansDAO extends JpaRepository<Loan, String>{


	//@Query("SELECT l FROM Loan l WHERE l.customer_id=? ")
	@Query(value="SELECT * from loans  WHERE customer_id=?1",  nativeQuery = true)
	Optional<Loan> getLoanByCustomerId(String customer_id);

	//@Query("SELECT l FROM Loan l WHERE l.customer_id=?  AND l.loan_id=?")
	 @Query(value="SELECT * from loans  WHERE customer_id=?1 AND loan_id=?1",  nativeQuery = true)
	Optional<Loan> getByLoanAndCustomerId(String customer_id, Long loan_id);

}

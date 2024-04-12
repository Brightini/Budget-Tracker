package model;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * 
 */
public class Income extends Transactions {
	private double amount;
	private String description;
	private LocalDate entryDate;
	private User user;

	
	public Income(double amount, String description, LocalDate entryDate, User user) {
		this.amount = amount;
		this.description = description;
		this.entryDate = entryDate;
		this.user = user;
	}

	@Override
	public void updateTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getAmount() {
		return this.amount;
	}
	
	@Override
	public void setAmount(double amount) {
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}
	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	public LocalDate getDate() {
		return entryDate;
	}
	public void setDate(LocalDate date) {
//		this.entryDate = date;
	}

}

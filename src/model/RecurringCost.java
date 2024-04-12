package model;

import java.time.YearMonth;

public class RecurringCost extends Transactions {
	private int transactionID;
	private double amount;
	private String description;
	private String name;
	private YearMonth startDate;
	private YearMonth endDate;
	private int frequency;
	
	
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
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void setAmount(double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public YearMonth getStartDate() {
		return startDate;
	}

	public void setStartDate(YearMonth startDate) {
		this.startDate = startDate;
	}

	public YearMonth getEndDate() {
		return endDate;
	}

	public void setEndDate(YearMonth endDate) {
		this.endDate = endDate;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}

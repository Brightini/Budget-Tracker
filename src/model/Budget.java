package model;

public class Budget {
	private int budgetID;
	private int userID;
	private double totalIncome;
	private double totalExpenses;
	private double totalBalance;

	/**
	 * @return the budgetID
	 */
	public int getBudgetID() {
		return budgetID;
	}
	/**
	 * @param budgetID the budgetID to set
	 */
	public void setBudgetID(int budgetID) {
		this.budgetID = budgetID;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the totalIncome
	 */
	public double getTotalIncome() {
		return totalIncome;
	}
	/**
	 * @param totalIncome the totalIncome to set
	 */
	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}

	/**
	 * @return the totalExpenses
	 */
	public double getTotalExpenses() {
		return totalExpenses;
	}
	/**
	 * @param totalExpenses the totalExpenses to set
	 */
	public void setTotalExpenses(double totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	/**
	 * @return the totalBalance
	 */
	public double getTotalBalance() {
		return totalBalance;
	}
	/**
	 * @param totalBalance the totalBalance to set
	 */
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}
	
	public void addIncome() {
		
	}
	
	public void addExpenses() {
		
	}
	
	public void addRecurringCost() {
		
	}
	
	public double getAvailableBalance() {
		double balance = 0.0;
		return balance;
	}
}

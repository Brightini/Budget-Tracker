package model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String userName;
	private String password;
	private List<Income> incomes;
	private List<Expenses> expenses;
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.incomes = new ArrayList<>();
		this.expenses = new ArrayList<>();
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	public List<Income> getIncome() {
		return incomes;
	}

	public void addIncome(Income income) {
        incomes.add(income);
    }
	
	public List<Expenses> getExpenses() {
		return expenses;
	}

	public void addExpense(Expenses expense) {
		expenses.add(expense);
	}
	
	public String getPassword() {
		return this.password;
	}
}

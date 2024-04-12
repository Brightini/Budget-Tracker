package model;

import view.BudgetTrackerGUI;

public class Report {
	private BudgetTrackerGUI budgetTrackerGUI;
	private double totalIncome;
	private double totalExpenses;

	public Report(BudgetTrackerGUI budgetTrackerGUI) {
		this.budgetTrackerGUI = budgetTrackerGUI;
	}

	public double getTotalExpenses() {
		User currentUser = budgetTrackerGUI.getLoggedInUser();
		if (currentUser != null ) {
			for (Expenses expense : currentUser.getExpenses()) {
				totalExpenses += expense.getAmount();
			}
		}
		return totalExpenses;
	}

	public double getTotalIncome() {
		User currentUser = budgetTrackerGUI.getLoggedInUser();
		if (currentUser != null) {
			for (Income income : currentUser.getIncome()) {
				totalIncome += income.getAmount();
			}
		}
		return totalIncome;
	}

	public double getBalance() {
		return totalIncome - totalExpenses;
	}

}

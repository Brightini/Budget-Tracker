package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Expenses;
import model.Income;
import model.Report;
import model.User;

public class ReportUI {
	private JButton transactionsButton;
	private JButton reportButton;
	private BudgetTrackerGUI budgetTrackerGUI;

	public ReportUI(BudgetTrackerGUI budgetTrackerGUI) {
		this.budgetTrackerGUI = budgetTrackerGUI;
	}
	
	JPanel createReportPanel() {
		JPanel panel = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER, 10, 10));
		transactionsButton = new JButton("VIEW TRANSACTIONS");
		reportButton = new JButton("VIEW REPORT");
		
		handleTransactionButton(transactionsButton);
		handleReportButton(reportButton);
		
		panel.add(transactionsButton);
		panel.add(reportButton);
		return panel;
	}
	
	public void handleTransactionButton(JButton transactionsButton) {
		transactionsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewTransactions();
			}
		});
	}
	
	public void handleReportButton(JButton reportButton) {
		reportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewReport();
			}
		});
	}
	
	public void viewReport() {
			StringBuilder transactionDetails = new StringBuilder();
			User currentUser = budgetTrackerGUI.getLoggedInUser();
			Report report = new Report(this.budgetTrackerGUI);

			transactionDetails.append("Name: ").append(currentUser.getUserName()).append("\n");
			transactionDetails.append("Total income: $").append(report.getTotalIncome()).append("\n");
			transactionDetails.append("Total Expenses: $").append(report.getTotalExpenses()).append("\n");
			transactionDetails.append("Balance: $").append(report.getBalance());
			
			// Display transaction details in a dialogue box
			JOptionPane.showMessageDialog(null, transactionDetails.toString(), "Report", JOptionPane.PLAIN_MESSAGE);		
	}

	public void viewTransactions() {
		JPanel transactionPanel = new JPanel(new GridLayout(0, 2, 10, 10));
		User currentUser = budgetTrackerGUI.getLoggedInUser();

		JPanel incomePanel = new JPanel(new GridLayout(0, 1, 5, 5)); // One column with a 5-pixel gap
	    incomePanel.setBorder(BorderFactory.createTitledBorder("Income Transactions"));

		// Retrieve and display income transactions
		for (Income income : currentUser.getIncome()) {
			JPanel incomeEntryPanel = new JPanel(new GridLayout(0, 1));
			incomeEntryPanel.add(new JLabel("Date: " + income.getDate()));
	        incomeEntryPanel.add(new JLabel("Amount: $" + income.getAmount()));
	        incomeEntryPanel.add(new JLabel("Description: " + income.getDescription()));
	        incomePanel.add(incomeEntryPanel);
		}
		transactionPanel.add(incomePanel);

		// Retrieve and display expense transactions
		JPanel expensePanel = new JPanel(new GridLayout(0, 1, 5, 5)); // One column with a 5-pixel gap
	    expensePanel.setBorder(BorderFactory.createTitledBorder("Expense Transactions"));
		for (Expenses expenses : currentUser.getExpenses()) {
			JPanel expenseEntryPanel = new JPanel(new GridLayout(0, 1));
	        expenseEntryPanel.add(new JLabel("Date: " + expenses.getDate()));
	        expenseEntryPanel.add(new JLabel("Amount: $" + expenses.getAmount()));
	        expenseEntryPanel.add(new JLabel("Description: " + expenses.getDescription()));
	        expensePanel.add(expenseEntryPanel);
		}
		transactionPanel.add(expensePanel);
		
		// Display transaction details in a dialogue box
		JOptionPane.showMessageDialog(null, transactionPanel, "Transactions", JOptionPane.PLAIN_MESSAGE);
	}
	
//	public void viewAvailableBalance() {
//		
//	}
}

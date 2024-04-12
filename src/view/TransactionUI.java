package view;


import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Expenses;
import model.Income;
import model.User;

public class TransactionUI {
	private BudgetTrackerGUI budgetTrackerGUI;

	public TransactionUI(BudgetTrackerGUI budgetTrackerGUI) {
		this.budgetTrackerGUI = budgetTrackerGUI;
	}
	
	JPanel createTransactionPanel(BudgetTrackerGUI tracker) {
		JPanel panel = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER, 10, 10));
		JButton addIncomeButton = new JButton("ADD INCOME");
		JButton addExpenseButton = new JButton("ADD EXPENSE");
		JButton goToReportButton = new JButton("VIEW REPORT/TRANSACTION");
		
		panel.add(addIncomeButton);
		panel.add(addExpenseButton);
		panel.add(goToReportButton);
		
		addIncomeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Show a dialog box for adding income
                JTextField amountField = new JTextField(10);
                JTextField descriptionField = new JTextField(10);

                JPanel dialogPanel = new JPanel(new FlowLayout());
                dialogPanel.add(new JTextField("Amount ($):"));
                dialogPanel.add(amountField);
                dialogPanel.add(new JTextField("Description:"));
                dialogPanel.add(descriptionField);
                
                int result = JOptionPane.showConfirmDialog(null, dialogPanel, "Add Income", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    String amountText = amountField.getText().trim();
                    String description = descriptionField.getText().trim();
                    // Proceed to add income if both fields are not empty
                    if (!amountText.isEmpty() && !description.isEmpty()) {
                    	User currentUser = budgetTrackerGUI.getLoggedInUser();
                    	double amount = Double.parseDouble(amountText);
                    	Income newIncome = new Income(amount, description, LocalDate.now(), currentUser);
                        currentUser.addIncome(newIncome);
//                        tracker.onUserViewReport(); // Navigate to report panel after adding income
                    }
                }
			}
		});
		
		addExpenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show a dialog box for adding expenses
                JTextField amountField = new JTextField(10);
                JTextField descriptionField = new JTextField(10);

                JPanel dialogPanel = new JPanel(new FlowLayout());
                dialogPanel.add(new JTextField("Amount ($):"));
                dialogPanel.add(amountField);
                dialogPanel.add(new JTextField("Description:"));
                dialogPanel.add(descriptionField);

                int result = JOptionPane.showConfirmDialog(null, dialogPanel, "Add Expense", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    String amountText = amountField.getText().trim();
                    String description = descriptionField.getText().trim();
                    // Proceed to add expense if both fields are not empty
                    if (!amountText.isEmpty() && !description.isEmpty()) {
                    	User currentUser = budgetTrackerGUI.getLoggedInUser();
                    	double amount = Double.parseDouble(amountText);
                        Expenses newExpense = new Expenses(amount, description, LocalDate.now(), currentUser);
                        currentUser.addExpense(newExpense);
//                        tracker.onUserViewReport(); // Navigate to report panel after adding expense
                    }
                }
            }
        });

		goToReportButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tracker.onUserViewReport();
			}
		});
		
		return panel;
	}
}

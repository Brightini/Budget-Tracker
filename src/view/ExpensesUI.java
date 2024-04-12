package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Expenses;
import model.User;

public class ExpensesUI {
	private JTextField amountField;
	private JTextField descriptionField;
	private JLabel statusLabel;
	private BudgetTrackerGUI budgetTrackerGUI;
	
	public ExpensesUI(BudgetTrackerGUI budgetTrackerGUI) {
		this.budgetTrackerGUI = budgetTrackerGUI;
	}
	
	JPanel createExpensePanel() {
		JPanel panel = new JPanel(new GridLayout(0, 2));
		
		amountField = new JTextField(10);
		descriptionField = new JTextField();

		panel.add(new JLabel("Amount ($): "));
		panel.add(amountField);

		panel.add(new JLabel("Description: "));
		panel.add(descriptionField);
		
		statusLabel = new JLabel("");
		panel.add(statusLabel);

		JButton addIncomeButton = new JButton("ADD EXPENSE");
		handleAddExpenseButton(addIncomeButton);

		panel.add(addIncomeButton);
		return panel;
	}

	public void handleAddExpenseButton(JButton addExpenseButton ) {
		addExpenseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String amountText = amountField.getText().trim();
				String description = descriptionField.getText();

				User currentUser = budgetTrackerGUI.getLoggedInUser();
				if (currentUser != null && !(amountText.isEmpty() && description.trim().isEmpty())) {
					try {
						double amount = Double.parseDouble(amountText);
						Expenses newExpense = new Expenses(amount, description, LocalDate.now(), currentUser);
						currentUser.addExpense(newExpense);
						statusLabel.setText("");
						budgetTrackerGUI.onUserViewReport();
					} catch(NumberFormatException e2) {
						statusLabel.setText("Invalid amount format");
					}
				} else {
					statusLabel.setText("Entry cannot be empty");
				}
			}
		});
	}
}

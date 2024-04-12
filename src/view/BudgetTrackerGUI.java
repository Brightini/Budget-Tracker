package view;

import javax.swing.*;

import model.Report;
import model.User;

import java.awt.*;

public class BudgetTrackerGUI {
	private JFrame frame;
    private CardLayout cardLayout = new CardLayout();
    private JPanel cards; // a panel that uses CardLayout
    private User loggedInUser;
    
    public BudgetTrackerGUI() {
        // Initialise the GUI components
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame("Budget Tracker App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 150);
        
        cards = new JPanel(cardLayout);

        // Panels for different functionalities
        UserUI userUI = new UserUI(this);
        JPanel userPanel = userUI.createUserPanel();

        IncomeUI incomeUI = new IncomeUI(this);
        JPanel incomePanel = incomeUI.createIncomePanel();

        ExpensesUI expenseUI = new ExpensesUI(this);
        JPanel expensesPanel = expenseUI.createExpensePanel();

        TransactionUI transaction = new TransactionUI(this);
        JPanel transactionPanel = transaction.createTransactionPanel(this);

        ReportUI reportUI = new ReportUI(this);
        JPanel reportPanel = reportUI.createReportPanel();

        // Add panels to cards
        cards.add(userPanel, "User");
        cards.add(incomePanel, "Income");
        cards.add(transactionPanel, "Transaction");
        cards.add(expensesPanel, "Expenses");
        cards.add(reportPanel, "Report");
        
        // Show the User Registration panel first
        cardLayout.show(cards, "User");
        
        frame.add(cards);
        frame.setVisible(true);
    }
    
    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    // Navigate to Transaction panel after registration
 	public void onUserTransaction() {
 		cardLayout.show(cards, "Transaction");
 	}

 	// Navigate to Income panel
 	public void onUserAddIncome() {
 		cardLayout.show(cards, "Income");
 	}
 	
 	// Navigate to Expense panel
  	public void onUserAddExpense() {
  		cardLayout.show(cards, "Expenses");
  	}
  	
  	// Navigate to Expense panel
  	public void onUserViewReport() {
  		cardLayout.show(cards, "Report");
  	}
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BudgetTrackerGUI();
            }
        });
    }
}


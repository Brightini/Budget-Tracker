package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.User;

public class UserUI {
	private JTextField userNameField;
    private JTextField passwordField;
    private static JLabel statusLabel;
    private static ArrayList<User> registeredUsers = new ArrayList<>();
    private static final String USERS_FILE = "src/textFiles/users.txt";
    private static User loggedInUser;
    private BudgetTrackerGUI budgetTrackerGUI;

    public UserUI(BudgetTrackerGUI budgetTrackerGUI) {
        this.budgetTrackerGUI = budgetTrackerGUI;
    }
    
    // Method to create the user panel
    JPanel createUserPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2));

        userNameField = new JTextField(10);
        passwordField = new JTextField(10);
        statusLabel = new JLabel("");

        panel.add(new JLabel("Enter your name: "));
        panel.add(userNameField);

        panel.add(new JLabel("Enter your password: "));
        panel.add(passwordField);
        panel.add(statusLabel);

        JButton registerButton = new JButton("Register");
        handleRegisterButton(registerButton);  

        panel.add(registerButton);
        return panel;
    }

    private void handleRegisterButton(JButton registerButton) {
    	registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = userNameField.getText();
	            String password = passwordField.getText();
	            if (!(name.trim().isEmpty() || password.trim().isEmpty())) {
	            	User newUser = new User(name, password);
	                registeredUsers.add(newUser);
	                budgetTrackerGUI.setLoggedInUser(newUser);
	                saveUsers();
	                statusLabel.setText("Registration successful");
	                budgetTrackerGUI.onUserTransaction();
	            } else {
	            	statusLabel.setText("Invalid input");
	            }
			}
		});
    }
    
    private static void saveUsers() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE))) {
            for (User user : registeredUsers) {
                writer.println(user.getUserName() + "," + user.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error occurred while saving users to file.");
        }
    }
    
    public static User getLoggedInUser() {
    	return loggedInUser;
    }

}

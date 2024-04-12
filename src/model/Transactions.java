package model;

public abstract class Transactions {
	public abstract void updateTransaction();
	public abstract void deleteTransaction();
	public abstract void setAmount(double amount);
	public abstract double getAmount();
	public abstract String getDescription();
	public abstract void setDescription(String description);
}

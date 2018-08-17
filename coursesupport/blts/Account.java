package blts;

public class Account {

	// Instance variables
	private int balance;

	// The constructor
	//    It has no return type
	//    It has the same name as the class
	public Account(int initialBal) {
		this.balance = initialBal;
	}
	
	// An accessor, returns the value of balance
	public int getBalance() {
		return this.balance;
	}
	
	// A mutator, changes the value of balance
	public void deposit(int funds) {
		this.balance = this.balance + funds;
		this.balance = this.balance - 1;      // fee for deposit
	}

}


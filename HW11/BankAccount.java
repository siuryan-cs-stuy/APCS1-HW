// Ryan Siu -- Team S^3 (Mark Shafran, James Smith)
// APCS pd5
// HW10 -- Iterative Improvement
// 2016-09-29

public class BankAccount {

    // Instance variables
    private String fullName;
    private String password;
    private int PIN;
    private int accountNum;
    private double balance;

    // Default constructor
    public BankAccount(){
	fullName = "placeholder";
	password = "placeholder";
	PIN = 1234;
	accountNum = 0;
	balance = 0;
    }

    // Overloaded constructor
    public BankAccount( String newName, String newPassword, int newPIN,
			int newAccountNum, double newBalance ){
	fullName = newName;
	password = newPassword;
	PIN = newPIN;
	accountNum = newAccountNum;
	balance = newBalance;
    }

    // Set functions
    public void setFullName( String newName ){
	fullName = newName;
    }

    public void setPassword( String newPassword ){
	password = newPassword;
    }

    public void setPIN( int newPIN ){
	PIN = newPIN;
    }

    public void setAccountNum( int newAccountNum ){
	accountNum = newAccountNum;
    }

    public void setBalance( double newBalance ){
	balance = newBalance;
    }

    // Prints the values of all the instance variables
    public void printInfo(){
	System.out.println("Your balance is: " + balance);
	System.out.println("Your name is: " + fullName);
	System.out.println("Your password is: " + password);
	System.out.println("Your PIN is: " + PIN);
	System.out.println("Your account number is: " + accountNum);
    }

    // Adds input amt to the balance instance variable
    public void deposit( double amt ){
	balance += amt;
	System.out.println("You deposited " + amt);
    }

    // Subtracts input amt to the balance instance variable
    public void withdraw( double amt ){
	balance -= amt;
	System.out.println("You withdrew " + amt);
    }
}

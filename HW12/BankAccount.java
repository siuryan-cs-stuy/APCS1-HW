// Ryan Siu
// APCS1 pd 5
// HW 12 -- Mo Money Mo Problems
// 2016-09-29
// Team S^3: James Smith, Ryan Siu, Mark Shafran

public class BankAccount {

    
    // Instance variables
    private String fullName;
    private String password;
    private int PIN;
    private int accountNum;
    private double balance;

    
    // Default constructor, no values
    public BankAccount() {
	System.out.println("Please make sure to instantiate all the instance variables");
    }
    
    // Overloaded constructor
    public BankAccount( String newName, String newPassword, int newPIN,
			int newAccountNum, double newBalance ){
	setFullName(newName);
        setPassword(newPassword);
	setPIN(newPIN);
        setAccountNum(newAccountNum);
	setBalance(newBalance);
    }
    
    
    // Set functions
    public String setFullName( String newName ){
	String oldName = fullName;
	fullName = newName;
	return oldName;
    }

    public String setPassword( String newPassword ){
	String oldPassword = password;
	password = newPassword;
	return oldPassword;
    }

    public int setPIN( int newPIN ){
	int oldPIN = PIN;
	
	if (newPIN >= 1000 && newPIN <= 9998){
	    PIN = newPIN;
	} else {
	    System.out.println("Error: The PIN you entered is out of the range [1000,9998], your input was: "+ newPIN);
	    PIN = 9999;
	}
	
	return oldPIN;
    }

    public int setAccountNum( int newAccountNum ){
	int oldAccountNum = accountNum;

	if (newAccountNum >= 100000000 && newAccountNum <= 999999998){
	    accountNum = newAccountNum;
	} else {
	    System.out.println("Error: The account number you entered is out of the range [100000000,9999999998], your input was: " + newAccountNum);
	    newAccountNum = 999999999;
	}
	
	return oldAccountNum;
    }

    public double setBalance( double newBalance ){
	double oldBalance = balance;
	balance = newBalance;
	return oldBalance;
    }

    
    // Will return information when System.out.println(<Object>) is called
    public String toString(){
        String retStr = "Your balance is: " + balance;
	retStr += "\nYour name is: " + fullName;
	retStr += "\nYour password is: " + password;
        retStr += "\nYour PIN is: " + PIN;
	retStr += "\nYour account number is: " + accountNum + "\n";
	return retStr;
    }

    
    // Adds input amt to the balance instance variable
    public void deposit( double amt ){
	balance += amt;
	System.out.println("You deposited " + amt);
    }

    // Subtracts input amt to the balance instance variable
    public boolean withdraw( double amt ){
	double newBalance = balance - amt;
	
	if (newBalance < 0) {
	    System.out.println("Not enough money to withdraw " + amt);
	    return false;
	} else {
	    balance = newBalance;
	    System.out.println("You withdrew " + amt);
	    return true;
	}
    }

    // Checks the input account number and input password against the values
    // stored in the instance variables
    public boolean authenticate( int authAccNum, String authPassword ){
	return authAccNum == accountNum && authPassword == password;
    }

    // Main method, testing purposes
    public static void main( String[] args ){
	BankAccount a = new BankAccount();
	System.out.println(a);
	
	BankAccount b = new BankAccount();
	b.setFullName("Ryan Siu");
	b.setPassword("abc123");
	b.setPIN(9876);
	b.setAccountNum(123456789);
	b.setBalance(357.73);
	System.out.println(b);

	b.setPIN(36);
	System.out.println(b);

	b.setAccountNum(30);
	System.out.println(b);

	BankAccount c = new BankAccount( "Ryan Siu", "abc123", 9876,
					 123456789, 357.73 );
	System.out.println(c);
	
	c.deposit(45.64);
	System.out.println(c);
	
	c.withdraw(45.64);
	System.out.println(c);

	c.withdraw(5000);
	System.out.println(c);
	
	System.out.println(c.authenticate( 123456789, "abc123" ));  // true
	System.out.println(c.authenticate( 123456789, "bc123" ));   // false
    }
}

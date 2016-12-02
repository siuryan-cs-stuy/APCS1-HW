public class Test {

    public static void main( String[] args ){
	BankAccount a = new BankAccount();
	a.printInfo();
	System.out.println();
	BankAccount b = new BankAccount();
	b.setFullName("Ryan Siu");
	b.setPassword("abc123");
	b.setPIN(9876);
	b.setAccountNum(123456789);
	b.setBalance(357.73);
	b.printInfo();
	System.out.println();
	BankAccount c = new BankAccount( "Ryan Siu", "abc123", 9876,
					 123456789, 357.73 );
	c.printInfo();
	System.out.println();
	c.deposit(45.64);
	c.printInfo();
	System.out.println();
	c.withdraw(45.64);
	c.printInfo();
    }
    
}

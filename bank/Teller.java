//Team C. R. E. A. M. -- Nadine Jackson, Raunak Chowdhury, Hasif Ahmed
//APCS1 pd2
//HW11 -- Breaking the Bank
//2017-10-04


public class Teller{
    public static void main(String [] args){
	BankAccount acct1 = new BankAccount();
	// Tests the toString() method
	System.out.println("Testing the toString() method, should return all of acct1's info (default)");
	System.out.println(acct1);
	System.out.println("\n");

	//Tests the toPin method
	System.out.println("The first call should generate a hardcoded error message and the second should set the pin to 4444, returning the old pin");
	acct1.setPin(444);
	acct1.setPin(4444);
	System.out.println(acct1);
	System.out.println("\n"); /* There's a problem here. If the number of digits for the pin is incorrect, then the ACCOUNT NUMBER, not the pin is set  to 9999. We assume that this might have been a typo, but a flawed method is still a flawed method.*/

	// Tests the setAcctNum method
	System.out.println("Testing the setAcctNum() method, the first should display hardcoded error, the second should return the old number.");	
	acct1.setAcctNum(426);
	acct1.setAcctNum(426426426);
	System.out.println("\n");

	//Makes sure everything has been stored so far
	System.out.println("Should update the stats based on what has been changed (pin to 4444 and number to 426426426)");
	System.out.println(acct1);
	System.out.println("\n");

	//Tests the authenticate method
	System.out.println("this should set the name to bill, password to nye and return true the first time, false the second.");
	acct1.setName("bill");
	acct1.setPasswd("nye");
	acct1.authenticate("bill","nye");
	acct1.authenticate("dank","memes");
	System.out.println("\n");

	// Tests the withdraw method
	System.out.println("Should set the balance to 500, withdraw 500 and then send a hardcoded error");
	acct1.setBalance(500);
	acct1.withdraw(500);
	acct1.withdraw(40);
	
	//The deposit method contains a bug. The deposit method adds the balance and the deposited amount to the balance, essentially doubling the balance every time deposit() is called
	System.out.println("should add 50, then 47, resulting in 97");
	acct1.deposit(50);
	acct1.deposit(47);
	System.out.println("\n");

	// One final time!
	System.out.println("Check to see that account info changes are in order. Name is bill, number is 426426426, pin is 4444, balance 0, password nye");
	System.out.println(acct1);
	System.out.println("\n");
	
    }
}

//Team Car with a K
//APCS1 pd2
//HW09 - BankAccount
//2017-10-02


public class BankAccount{
    public static String acctHolderName;
    private static String password;
    private static String pin;
    public static int acctNumber;
    public static double acctBalance;

    public static void main ( String[] args ){
	setAcctName ("Kaitlin Wan");
	setPass ("password");
	setPin ("4646");
	setAcctNumber (349857398);
	setAcctBalance (9999.99);
	printinfo();
       	deposit (42);
	withdraw (42);
	
    }

    
    // Set the variables!
    public static void setAcctName ( String str ){
	acctHolderName = str;
	    }

    public static void setPass ( String str ) {
	password = str;
    }

    public static void setPin ( String str ) {
	pin = str;
    }

    public static void setAcctNumber ( int num ) {
	acctNumber = num;
    }

    public static void setAcctBalance ( double num ) {
	acctBalance = num;
    }
	

    public static void printinfo() {
	System.out.println ("Account Holder: " + acctHolderName);
	System.out.println ("Account Number: " + acctNumber);
	System.out.println ("Current Account Balance: " + acctBalance);
    }

    public static void deposit ( double amt ){
	acctBalance += amt; // Adds the amount 
	System.out.println ("You have deposited into " + acctHolderName + "'s account. Transaction complete."); // Indicates if the deposit was successful
	System.out.println ("Current amount: " + acctBalance); // Should report the amount
    }

    public static void withdraw ( double amt ){
	acctBalance += -amt; // Subtracts the amount 
	System.out.println ("You have withdrawn from " + acctHolderName + "'s account. Transaction complete."); // Indicates if the deposit was successful
	System.out.println ("Current amount:" + acctBalance); // Should report the amount   
    }
}

// Team C.R.E.A.M.(Group 6) -- Hasif Ahmed, Nadine Jackson, Raunak Chowdhury
// APCS1 pd2
// HW10 -- No Money No Problems
// 2017-10-03 T

public class BankAccount
{
    //instance variables
    private static String name;
    private static String passwd;
    private static int pin;
    private static int acctNum;
    private static double balance;


    //mutators
    public static String setName( String newName )
    {
	String oldName = name;
	name = newName;
	return oldName;
    }

    public static String setPasswd( String newPasswd )
    {
	String oldPasswd = passwd;
	passwd = newPasswd;
	return oldPasswd;
    }

    public static int setPin( int newPin )
    {
	if (1000 <= newPin && newPin <= 9998){ // Checks to see if a PIN is a 4-digit number
	    int oldPin = pin;
	    pin = newPin;
	    return oldPin;
	}
	else {
	    pin = 9999;
	    System.out.println("Invalid PIN. Your PIN has been set to " + pin);
	    return pin; // Report that the pin is invalid, and notify them that it has been set to 9999
	}
    }

    public static int setAcctNum( int newAcctNum )
    {
	if(100000000 <= newAcctNum && newAcctNum  <= 999999998){
	    int oldAcctNum = acctNum;
	    acctNum = newAcctNum;
	    return oldAcctNum;
	}
	else{ // If the account number is not within the designated domain, report this message
	    acctNum = 999999999;
	    System.out.println("The account number you tried to set is invalid. Your account number has been set to " + acctNum);
	    return acctNum;
	}
	    
    }

    public static boolean authPassword ( String username, String pass){ //Authenticate the user by requiring them to input a username and password
	if (name == username && pass == passwd){ //Check to see if the name and password is equal to what is already been stored as the username and password
	    System.out.println ( "Success! You have successfully logged in.");
	    return true;	// Notfiy the user if they logged in or not, and return the corresponding boolean value
	}
	else {
	    System.out.println ("Incorrect username/password. Please try again.");
	    return false;
	}
    }

    public static double setBalance( double newBalance )
    {
	double oldBalance = balance;
	balance = newBalance;
	return oldBalance;
    }

    public static void deposit( double depositAmount ) {
	balance = balance + depositAmount;
    }

    public static void withdraw ( double withdrawAmount ){
	double difference = balance - withdrawAmount; // Subtracts it from the get-go
	if (difference < 0){
	    System.out.println ("You are not allowed to do that, as your account only has " + balance);
	}
	else {
	    balance = difference; //Set the balance to the difference if the balance doesn't drop below 0
	    System.out.println ("Transaction success! Your new balance is: " + balance); //Gives a notif if successful
	}
    }


    //overwritten toString()
    public String toString() {
	String retStr = "\nAccount info:\n=======================";
	retStr = retStr + "\nName: " + name;
	retStr = retStr + "\nPassword: " + passwd;
	retStr = retStr + "\nPIN: " + pin;
	retStr = retStr + "\nAccount Number: " + acctNum;
	retStr = retStr + "\nBalance: " + balance;
	retStr = retStr + "\n=======================";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
	// INSERT YOUR METHOD CALLS FOR TESTING HERE
	//Tried testing all cases
	setName ("Rick");
	setPasswd ("Morty");
	setAcctNum (99990777);
	setAcctNum (999999998);
	setBalance(100);
	setPin(300);
	setPin(3099);
	
	withdraw(50);
	withdraw(200);

	authPassword("Rick", "Morty");
	authPassword("Boi", "Pass");


	
	
    }//end main()

}//end class BankAccount

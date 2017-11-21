// Team Sleep Deprivation - Henry Carver, Jackie Li, Lily Yan
// APCS1 pd2
// HW10 -- Mo Money Mo Problems
// 2017-10-03 


public class BankAccount{
  //instance variables
  private String name;
  private String passwd;
  private int pin;
  private int acctNum;
  private double balance;


  //mutators
    //changes the name and stores + returns the old name
  public String setName( String newName )
  {
    String oldName = name;
    name = newName;
    return oldName;
  }

    //changes the password and stores + returns the old password
  public String setPasswd( String newPasswd )
  {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
  }

    //stores the pin. if the pin is out of range, send an error + set to 9999. otherwise return the old pin
  public int setPin( int newPin )
  {
    int oldPin = pin;
    pin = newPin;
    if ((newPin < 1000) || (newPin > 9998)) {
			acctNum = 9999;
			System.out.println("Pin number not valid. Number set to 9999.");
	    }
    return oldPin;
  }

    //stores the old account number, changes the account number. if not in range, set the number to 999999999 and send an error, otherwise, return the old number
  public int setAcctNum( int newAcctNum )
  {
    int oldAcctNum = acctNum;
    acctNum = newAcctNum;
    if ((newAcctNum > 999999998) || (newAcctNum < 100000000)) {
			acctNum = 999999999;
			System.out.println("Account number not valid. Number set to 999999999.");
	    }
    return oldAcctNum;
  }

    //stores the old balance, changes the balance, returns the old balance
  public double setBalance( double newBalance )
  {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }

    //adds the depositAmount to the current balance
  public double deposit( double depositAmount ) {
    balance += balance + depositAmount;
    return balance;
  }

    //if the withdrawal is greater than the amount of money, do not withdraw and send a message, otherwise, withdraw
  public Boolean withdraw( double withdrawAmount ) { 				// make this function a boolean since it has to return an operator 
    if (withdrawAmount > balance) {
			System.out.println("Insufficient funds.");
  		return false;
    }
    else {
			balance -= withdrawAmount;
      return true;
    }
  }

    //check if the inputs are right. return true or false accordingly
    public Boolean authenticate (String inputname, String inputpasswd) {
	if ((inputname == name) && (inputpasswd == passwd)) {
	    return true;
	}
	else {
	    return false;
	}
    }

  //overwritten toString()
    //prints what attribute is, and then the attribute
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

  // I commented out the main method so that we can at least see if we can compile the code with the conditionals.
  // I added the conditionals for account number, PIN number, and withdraw function. 

  //main method for testing
    public static void main( String[] args ) {/*
      BankAccount myAcct = new BankAccount();
      myAcct.setName("Squiggle Squaggle");
      myAcct.setPasswd("password");
      myAcct.setPin(6583);
      myAcct.setAcctNum(653098485);
      myAcct.setBalance(500.00);
      myAcct.withdraw(5.00);
      myAcct.authenticate("lol","bop");

      System.out.println(myAcct.toString());*/
    }
    //end main()
}
    //end class BankAccount

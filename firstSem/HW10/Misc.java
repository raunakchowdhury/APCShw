public class Misc
{
    byte bert = 89;
    byte bert = 160;
    public static void main (String [] args){
	
	BankAccount rode = new BankAccount();
	BankAccount rod = new BankAccount();
	rode.setName("rod");
	rod.setName("rod");
	rode.setPasswd("rod");
	rod.setPasswd("rod");
	System.out.println(rode);
	System.out.println(rod);
	System.out.println(rode.equals(rod));
	System.out.println(rode == rod);

	int i2;
	double d2 = 3.8644f;
	i2 = (int) d2;
	System.out.println(i2);
    }
    
	
}

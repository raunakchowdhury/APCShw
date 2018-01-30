public class Greet{
    public static void main( String[] args){
	String greeting;

	Bigsib sample = new Bigsib();
	Bigsib richard = new Bigsib("Word up");
	Bigsib grizz = new Bigsib("Hey ya");
	Bigsib dotCom = new Bigsib("Sup");
	Bigsib tracy = new Bigsib("Salutations");

	greeting = sample.greet ("Roy");
	System.out.println(greeting);

	greeting = richard.greet ("freshman");
	System.out.println(greeting);

	greeting = grizz.greet ("Kong Fooey");
	System.out.println(greeting);

	greeting = dotCom.greet ("mom");
	System.out.println(greeting);

	greeting = tracy.greet ("Dr. Spaceman");
	System.out.println(greeting);
    }
}





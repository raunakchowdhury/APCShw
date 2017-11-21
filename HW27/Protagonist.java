// Team RPG -- Raunak Chowdhury
// APCS1 pd2
// HW28 -- Ye Olde Role Playing Game
// 2017-11-09

public class Protagonist{
    private String name;
    private int health;
    private int defense;
    private int strength;
    private double attack;

    public Protagonist(){
	name = "Max";
	health = 125;
	attack = 0.4;
	defense = 40;
	strength = 100;
    }

    public Protagonist( String entName){
	this();
	name = entName;
    }

    public boolean isAlive(){
	return health > 0;
    }

    public int getDefense(){
	return defense;
    }

    public String getName(){
	return name;
    }

    public void lowerHP( int damage ){
	health = health - damage;
    }

    public int attack( Monster monster ){
	int damage = (int) ( (strength * attack) - monster.getDefense() );
	monster.lowerHP( damage );
	return damage;
	}

    //special
    public void specialize(){
	attack += 0.1;
	defense -= 5;
	//System.out.print("Charging special! Player's attack is now " + attack + ". ");
	//System.out.println( "Player's defense is now " + defense + ".");  
    }

    //normalizes stats
    public void normalize(){
	attack = 0.4;
	defense = 40;
	//System.out.print("Charging special! Player's attack is now " + attack + ". ");
	//System.out.println( "Player's defense is now " + defense + ".");  
    }

    public static void main( String[] args ){
	Protagonist knight = new Protagonist ("Etheros");
	// test out the constructor and associated methods
	System.out.println( "Your name is: " + knight.getName() );
	System.out.println( "Your def is: " + knight.getDefense() );
	System.out.println( "Your knight is: " + knight.isAlive() );
	System.out.println( "\n" );
	// test the damage taken
	knight.lowerHP(22);
	knight.specialize();
	knight.normalize();
	
    }
}

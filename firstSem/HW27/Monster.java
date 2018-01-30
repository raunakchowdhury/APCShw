// Team RPG -- Raunak Chowdhury
// APCS1 pd2
// HW28 -- Ye Olde Role Playing Game
// 2017-11-09

public class Monster{
    private String name;
    private int health;
    private int defense;
    private int strength;
    private double attack;

    public Monster(){
	name = "Max";
	health = 150;
	attack = 1;
	defense = 20;
	strength = (int)( (Math.random() * 20) + 45 );
    }

    public Monster( String entName){
	this();
	name = entName;
    }

    public boolean isAlive(){
	return health > 0;
    }

    public static String git(String darth){
      return darth;
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

    public int attack( Protagonist protagonist ){
	int damage = (int) ( (strength * attack) - protagonist.getDefense() );
	protagonist.lowerHP( damage);
	return damage;
	}


    public static void main( String[] args ){
	Monster ornstein = new Monster ("Smaug");
	// test out the constructor and associated methods
	//	System.out.println( "Your name is: " + knight.getName() );
	//System.out.println( "Your def is: " + knight.getDefense() );
	//System.out.println( "Your knight is: " + knight.isAlive() );
	//System.out.println( "\n" );
	// test the damage taken
	//knight.lowerHP(22);
	//knight.specialize();
	//knight.normalize();

    }
}

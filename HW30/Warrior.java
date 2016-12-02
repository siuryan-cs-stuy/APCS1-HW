// Team FileNotFound -- Ryan Siu, Jonathan Quang, Rihui Zheng
// APCS1 pd5
// HW30 -- Ye Olde Role Playing Game
// 2016-11-16

/* Warrior class */
public class Warrior {

    // Instance vars
    private String name;
    private int hp;
    private int strength;
    private int defense;
    private double attRate;

    // Constructor: set warrior's attributes
    public Warrior (String newName) {
	this.name = newName;
	hp = 125;
	strength = 100;
	defense = 40;
	attRate = 0.4;
    }//end constructor

    //checks to see if warrior is alive
    public boolean isAlive() {
	return this.hp > 0;
    }//end isAlive

    //gets defense attribute of warrior
    public int getDefense() {
	return this.defense;
    }//end getDefense

    //gets name of warrior
    public String getName() {
	return this.name;
    }//end getName

    //warrior takes damage
    public void lowerHP (int damage) {
	this.hp -= damage;
    }//end lowerHP

    //returns the damage done by monster
    public int attack (Monster m) {
	int damage = (int)(this.strength * this.attRate) - m.getDefense();
	if (damage < 0) {
	    damage = 0;
	}
	m.lowerHP(damage);
	return damage;
    }//end attack

    //warrior goes berserk, increasing its attack rate but decreasing defense
    public void specialize() {
	this.defense = 30;
	this.attRate = 0.5;
    }//end specialize

    //warrior calms down
    public void normalize() {
	this.defense = 40;
	this.attRate = 0.25;
    }//end normalize

}//end class

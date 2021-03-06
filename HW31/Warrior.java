// Team FileNotFound -- Ryan Siu, Jonathan Quang, Rihui Zheng
// APCS1 pd5
// HW31 -- Ye Olde Role Playing Game, Improved
// 2016-11-17

/*=============================================
  class Warrior -- protagonist of Ye Olde RPG
  =============================================*/

public class Warrior extends Character
{
    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private String _name = "John Adams";

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Warrior() {
	_hitPts = 125;
	_strength = 100;
	_defense = 40;
	_attack = .4;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Warrior( String name ) {
	this();
	if (!name.equals(""))
	    _name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return _name; }
    
    public int getDefense() { return _defense; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //prepare a Warrior for a special attack
    public void specialize() {
	_attack = .75;
	_defense = 20;
    }

    //revert to normal mode
    public void normalize() {
	_attack = .4;
	_defense = 40;
    }


}//end class Warrior

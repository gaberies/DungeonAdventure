import java.util.Scanner;

/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from DungeonCharacter.  A Hero has battle choices: regular attack and a
 *  special skill which is defined by the classes derived from Hero.
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *    public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	  public void readName()
	  public boolean defend()
	  public void subtractHitPoints(int hitPoints)
	  public void battleChoices(DungeonCharacter opponent)

 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */
/* Modify:
		change to private for chanceToBlock
		add Scanner
		remove readName()
		use getName() and getAttackSpeed()
*/

public abstract class Hero extends DungeonCharacter
{

	protected Scanner sc = new Scanner(System.in);
	private double chanceToBlock;
	protected int numTurns;
	
	//add
//	private int x, y;
//	private int numPillar, numPotion, numVisionPotion;
	private int numPotions, numVisionPots, numPillars, x, y;


//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	//readName();
//	this.numPillar=0;
//	this.numPotion=0;
	this.numPotions = 0;
	this.numPillars = 0;
	this.numVisionPots = 0;
	System.out.print("Enter character name: ");
	name = sc.nextLine();
	setName(name);
  }
  public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public void usePot(){

	//	int healAmount = ThreadLocalRandom.current().nextInt(1,15);
		int healAmount = (int)(Math.random() * 15) + 1;
		if(this.numPotions > 0){
			addHitPoints(healAmount);
			this.numPotions--;
			System.out.println("you absorb: " + healAmount + "HP");
			System.out.println(this.getName() + " has " + this.getHitPoints() + "HP after using a potion.");
		}
		else System.out.println("you have no potion.");
	}



	public void setNumPotions(int numPots) {
		this.numPotions = numPots;
	}

	public int getNumPotions() {
		return numPotions;
	}

	public int getNumPillars() {
		return numPillars;
	}

	public void setNumPOO(int numP) {
		this.numPillars = numP;
	}

	@Override
	public String toString() {
		return   getName() + " has" +
				"HP: " + getHitPoints() + " "+
				"numPots left: " + numPotions + " " +
				", numVisionPots left: " + numVisionPots + " " +
				", numPOO found: " + numPillars + " ";
	}
//add
 /* public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
  public void setX(int xCoor) {
		this.x = xCoor;
	}

	public void setY(int yCoor) {
		this.y = yCoor;
	}
	public int getNumPillar() {
		return this.numPillar;
	}

	public void setNumPillar(int numP) {
		this.numPillar = numP;
	}
	public int getNumPotion() {
		return this.numPotion;
	}

	public void setNumPotion(int numP) {
		this.numPotion = numP;
	}
	public void usePotionOption(){

		int healAmount = ThreadLocalRandom.current().nextInt(1,15);
		if(this.numPotion > 0){
			addHitPoints(healAmount);
			this.numPotion--;
			System.out.println("you absorb: " + healAmount + "HP");
			System.out.println(this.getName() + " has " + this.getHitPoints() + "HP after using a potion.");
		}
		else System.out.println("you have no potion.");
	}
	@Override
	public String toString() {
		return   getName() + " has" +
				"HP: " + getHitPoints() + " "+
				"numPots left: " + numPotion + " " +
				", numVisionPots left: " + numVisionPotion + " " +
				", numPOO found: " + numPillar + " ";
	}


	*/
/*-------------------------------------------------------
readName obtains a name for the hero from the user

Receives: nothing
Returns: nothing

This method calls: nothing
This method is called by: hero constructor
---------------------------------------------------------*/
 /* public void readName()
  {
		System.out.print("Enter character name: ");
		name = Keyboard.readString();
  }//end readName method */

/*-------------------------------------------------------
defend determines if hero blocks attack

Receives: nothing
Returns: true if attack is blocked, false otherwise

This method calls: Math.random()
This method is called by: subtractHitPoints()
---------------------------------------------------------*/
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method

/*-------------------------------------------------------
subtractHitPoints checks to see if hero blocked attack, if so a message
is displayed, otherwise base version of this method is invoked to
perform the subtraction operation.  This method overrides the method
inherited from DungeonCharacter promoting polymorphic behavior

Receives: hit points to subtract
Returns: nothing

This method calls: defend() or base version of method
This method is called by: attack() from base class
---------------------------------------------------------*/
public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(this.getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}//end method

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought.  The number of turns is reported to the user.  This stuff might
go better in another method that is invoked from this one...

Receives: opponent
Returns: nothing

This method calls: getAttackSpeed()
This method is called by: external sources
---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = this.getAttackSpeed() /opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices

}//end Hero class
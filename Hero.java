import java.util.Scanner;

/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes. It is derived
 * from DungeonCharacter. A Hero has battle choices: regular attack and a
 * special skill which is defined by the classes derived from Hero.
 *
 * class variables (all are directly accessible from derived classes):
 * chanceToBlock -- a hero has a chance to block an opponents attack numTurns --
 * if a hero is faster than opponent, their is a possibility for more than one
 * attack per round of battle
 *
 * class methods (all are public): public Hero(String name, int hitPoints, int
 * attackSpeed, double chanceToHit, int damageMin, int damageMax, double
 * chanceToBlock) public void readName() public boolean defend() public void
 * subtractHitPoints(int hitPoints) public void battleChoices(DungeonCharacter
 * opponent)
 * 
 * Copyright: Copyright (c) 2001 Company:
 * 
 * @author
 * @version 1.0
 */
/*
 * Modify: .change to private filed get rid of readName() method and use scanner
 * .add SkillBehavior specialSkill and get/setSpecialSkill() .no need defend()
 * so removed. modified subtractHitPoints() .add getNumTurns() .add attack
 * method .Change battleChoices() methods name to setNumTurns()
 */

public abstract class Hero extends DungeonCharacter {
	private double chanceToBlock;
	protected int numTurns;
	protected SkillBehavior specialSkill;
	protected int numOfHealingPotions;
	protected int numOfVisionPotions;
	protected int numOfPillars;
	protected int heroPosRow;
	protected int heroPosCol;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
	public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		// readName();
		System.out.print("Enter character name: ");
		name = sc.nextLine();
		setName(name);

		heroPosRow = (int) (Math.random() * 5 + 1);
		heroPosCol = (int) (Math.random() * 5 + 1);
	}

	public int getNumTurns() {
		return this.numTurns;
	}

	public void attack(DungeonCharacter opponent) {
		super.attack(opponent);
		numTurns--;
	}

	public SkillBehavior getSpecialSkill() {
		return specialSkill;
	}

	public void setSpeacialSkill(SkillBehavior specialSkill) {
		this.specialSkill = specialSkill;
	}

	public void specialSkillAttack(Monster opponent) {
		specialSkill.execute(this, opponent);
		numTurns--;
	}

	/*-------------------------------------------------------
	readName obtains a name for the hero from the user
	
	Receives: nothing
	Returns: nothing
	
	This method calls: nothing
	This method is called by: hero constructor
	---------------------------------------------------------*/
	/*
	 * public void readName() { System.out.print("Enter character name: "); name =
	 * Keyboard.readString(); }//end readName method
	 */

	/*-------------------------------------------------------
	defend determines if hero blocks attack
	
	Receives: nothing
	Returns: true if attack is blocked, false otherwise
	
	This method calls: Math.random()
	This method is called by: subtractHitPoints()
	---------------------------------------------------------*/
	/*
	 * public boolean defend() { return Math.random() <= chanceToBlock;
	 * 
	 * }//end defend method
	 */
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

	public void subtractHitPoints(int hitPoints) {
		/*
		 * if (defend()) { System.out.println(name + " BLOCKED the attack!"); } else {
		 * super.subtractHitPoints(hitPoints); }
		 */
		if (Math.random() <= chanceToBlock) // check if the random number pass the block rate to perform an attack
		{
			System.out.println(getName() + " BLOCKED the attack!");
		} else {
			super.subtractHitPoints(hitPoints);
		}

	}// end method

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
	public void setNumTurns(DungeonCharacter opponent) {
		numTurns = this.getAttackSpeed() / opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);
	}

	public void showHeroPos() {
		System.out.println("The hero is at [" + this.heroPosRow + "][" + this.heroPosCol + "]");
	}

	public void moveHero(String move) {

		if (move.equals("u")) {
			if (this.heroPosRow != 1) {
				this.heroPosRow--;
			} else {
				System.out.println("you're already at the top of the maze!");
			}
		} else if (move.equals("d")) {
			if (this.heroPosRow != 5) {
				this.heroPosRow++;
			} else {
				System.out.println("you're already at the bottom of the maze!");
			}
		} else if (move.equals("l")) {
			if (this.heroPosCol != 1) {
				this.heroPosCol--;
			} else {
				System.out.println("you're as far left as you can go!");
			}
		} else if (move.equals("r")) {
			if (this.heroPosCol != 5) {
				this.heroPosCol++;
			} else {
				System.out.println("you're as far right as you can go!");
			}
		}

	}

	public String ToString() {
		return this.getName() + " has " + this.getHitPoints() + " and " + this.numOfHealingPotions
				+ " Healing potions, " + this.numOfVisionPotions + " Vision Potions and has found " + this.numOfPillars
				+ " Pillars of OO";
	}
	/*
	 * public void battleChoices(DungeonCharacter opponent) { // numTurns =
	 * attackSpeed/opponent.getAttackSpeed(); numTurns =
	 * this.getAttackSpeed()/opponent.getAttackSpeed();
	 * 
	 * 
	 * if (numTurns == 0) numTurns++;
	 * 
	 * System.out.println("Number of turns this round is: " + numTurns);
	 * 
	 * }//end battleChoices
	 * 
	 */
}// end Hero class
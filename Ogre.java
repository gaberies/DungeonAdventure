

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */
/*
 * Modidy: use get methods
 */
public class Ogre extends Monster
{

    public Ogre()
	{
		super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
		setAttackMessage(" slowly swings a club toward's ");



    }//end constructor
}//end Monster class

/*	public void attack(DungeonCharacter opponent)
	{
		System.out.println(this.getName() + " slowly swings a club toward's " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack

*/

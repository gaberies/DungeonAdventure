

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

/*Modify:  use getName() because we set private field
 *
 */

public class Gremlin extends Monster
{

    public Gremlin()
	{
		super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);
		setAttackMessage(" jabs his kris at ");

    }//end constructor

/*	public void attack(DungeonCharacter opponent)
	{
		System.out.println(this.getName() + " jabs his kris at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack
	*/


}//end class Gremlin
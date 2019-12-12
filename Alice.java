public class Alice extends Hero
{

	public Alice()
	{
		super("Alice", 120, 5, .5, 30, 70, .3);
		setAttackMessage(" creates a Bubble Trouble at ");
		specialSkill = new BubbleAttack();
    }//end constructor
}//end Hero class

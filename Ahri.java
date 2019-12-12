public class Ahri extends Hero
{   
    public Ahri()
	{
		super("Ahri", 150, 6, .7, 30, 60, .8);
		setAttackMessage(" lands a hit at ");
		specialSkill = new OrbOfDeception();

    }//end constructor
}//end Hero class
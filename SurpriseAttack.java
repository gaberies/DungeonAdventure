
public class SurpriseAttack implements SkillBehavior {

	@Override
	public String skillName() {
		return "Surprise Attack";
	}

	@Override
	public void execute(Hero hero, Monster monster) {
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								hero.getName() + " gets an additional turn.");
			hero.numTurns++;
			hero.attack(monster);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + monster.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    hero.attack(monster);

		
	}

}


public class CrushingBlow implements SkillBehavior {

	@Override
	public String skillName() {
		return "Crushing Blow";
	}

	@Override
	public void execute(Hero hero, Monster monster) {
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(hero.getName() + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			monster.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(hero.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed
		
	}

}


public class OrbOfDeception implements SkillBehavior {

	@Override
	public String skillName() {
		return "Orb of Deception";
	}

	@Override
	public void execute(Hero hero, Monster monster) {
		if (Math.random() <= .4)
		{
			int orbPoints = (int)(Math.random() * 76) + 100;
			System.out.println(hero.getName() + "  sends out and pulls back her orb, dealing magic damage on the way out and true damage on the way back for " + orbPoints
								+ " damage!");
			monster.subtractHitPoints(orbPoints);
			
			int hPoints = (int)(Math.random() * (hero.getDamageMax() - hero.getDamageMin() + 1)) + hero.getDamageMin();
			hero.addHitPoints(hPoints);
			System.out.println("Ahri's next orb hits restored her health for [" + hPoints + "] points.\n");

		}//end blow succeeded
		else
		{
			System.out.println(hero.getName() + " failed to land her Orb of Deception");
			System.out.println();
		}//blow failed

	}

}

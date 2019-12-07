
public class IncreaseHitPoints implements SkillBehavior{

	@Override
	public String skillName() {
		return "Increase Hit Points";
	}

	@Override
	public void execute(Hero hero, Monster monster) {
		/*	hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
			addHitPoints(hPoints);
			System.out.println(this.getName() + " added [" + hPoints + "] points.\n"
								+ "Total hit points remaining are: "
								+ this.getHitPoints());
			 System.out.println();		*/
			 
			 int hPoints;

				hPoints = (int)(Math.random() * (hero.getDamageMax() - hero.getDamageMin() + 1)) + hero.getDamageMin();
				hero.addHitPoints(hPoints);
				System.out.println(hero.getName() + " added [" + hPoints + "] points.\n"
										+ "Total hit points remaining are: "
										+ hero.getHitPoints());
				System.out.println();
	}

}

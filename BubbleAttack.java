import java.util.Random;

public class BubbleAttack implements SkillBehavior {

	@Override
	public String skillName() {
		return "Sleepy Trouble Bubble";
	}

	@Override
	public void execute(Hero hero, Monster monster) {
		
		Random rd = new Random();
		double bubbleChance = 0.4;
			if (rd.nextInt(100) / 100.0 < bubbleChance) {
				int bubble = rd.nextInt(hero.getDamageMax() - hero.getDamageMin()) + hero.getDamageMin();
				System.out.println(hero.getName() + " missed her Sleepy Trouble Bubble, but dropkicks a bubble that deals "
						+ bubble + " damage to " + monster.getName());
				System.out.println("She also gains a shield that absorbs (+30) HP");
				hero.addHitPoints(30);
				monster.subtractHitPoints(bubble);
			} else {
				System.out.println("The first source of damage that breaks the sleep is doubled!");
				int doubleDmg = (rd.nextInt(hero.getDamageMax() - hero.getDamageMin()) + hero.getDamageMin())
						+ (rd.nextInt(hero.getDamageMax() - hero.getDamageMin()) + hero.getDamageMin());
				System.out.println(monster.getName() + " dealing " + doubleDmg + " from " + hero.getName());
				monster.subtractHitPoints(doubleDmg);
			}

	}
}

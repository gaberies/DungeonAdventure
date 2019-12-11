import java.util.Scanner;

public class DungeonAdventure {

	public static void main(String[] args) {
		System.out.println(
				"Hello welcome to the Dungeon Adventure game! \nYou will play as a hero and move through our maze by entering u for up d for down l for left and r for right!\n"
						+ "Good luck and keep your eye out for traps and potions! You win by collecting 4 pilalrs of OO which will be in different rooms of the maze! \n");
		
		
		//create dungeon object here
		HeroFactory h = new HeroFactory();
		
		Hero hero = h.buildHero();
		Scanner sc = new Scanner(System.in);
		while (hero.numOfPillars != 4 && hero.getHitPoints() > 0) {
			hero.showHeroPos();
			System.out.println("Choose what you'd like to do:");
			System.out.println("Press 1 to move, then enter u for up, d for down l for left and r for right");
			if (hero.numOfHealingPotions > 0) {
				System.out.println("Press 2 to use a Healing Potion");
			}
			if (hero.numOfVisionPotions > 0) {
				System.out.println("Press 3 to use a Vision Potion");
			}
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1: hero.moveHero(sc.next());
			
			case 2: //use healing potion if they have one. 
				
			case 3: //use vison potion if they have one.
				
			case 5: //hidden menu option that prints the entire Dungeon
			
			default: System.out.println("Please enter a correct choice!");
				
			}
			//Put display the entire Dungeon here.
		}
		//print Dungeon here
;	}
}

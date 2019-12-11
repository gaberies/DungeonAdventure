import java.util.Scanner;

public final class Dungeon {
    static Scanner sc = new Scanner(System.in);
    String visionMap = "";
    private static boolean hasEntrance = false;
    private static boolean hasExit = false;
    private  static int hasPillar = 0;
    private static boolean dungeonCondition = false;
    private static String visionRespone = "";

    public static Room[][] createDungeonRoom(Hero hero){
        Room[][] rooms = new Room[5][5];

        while(hasExit == false && hasEntrance == false && hasPillar < 4) {
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms.length; j++) {

                	//this room have entrance but no exit and less than 4 plillars
                    if (hasEntrance == true && hasExit == false && hasPillar < 4) {
                      	int random=(int)(Math.random() * 7) + 2;

                      	rooms[i][j] = Room.newRoom(random);
                         if (rooms[i][j].isExit() == true) {
                             hasExit = true;
                         } else if (rooms[i][j].isPillar() == true) {
                             hasPillar++;
                         }
                    }
                    //this room have no entrance and no exit and less than 4 pillars
                    else if (hasEntrance == false && hasExit == false && hasPillar < 4) {
                        	int random=(int)(Math.random() * 7) + 1;

                        	rooms[i][j] = Room.newRoom(random);
                            if (rooms[i][j].isEntrance() == true) {
                                hasEntrance = true;
                            } else if (rooms[i][j].isExit() == true) {
                                hasExit = true;
                            } else if (rooms[i][j].isPillar() == true) {
                                hasPillar++;
                            }
                    }
                    //this room has exit and no entrance
                    else if (hasEntrance == false && hasExit == true && hasPillar < 4) {
                    	int random=(int)(Math.random() * 7) + 1;

                    	rooms[i][j] = Room.newRoom(random);
                        if (rooms[i][j].isEntrance() == true) {
                            hasEntrance = true;
                        } else if (rooms[i][j].isPillar() == true) {
                            hasPillar++;
                        }
                    }

                    //have entrance and exit
                     else if (hasEntrance == true && hasExit == true && hasPillar < 4) {
                    	int random=(int)(Math.random() * 7) + 3;

                    	rooms[i][j] = Room.newRoom(random);
                        if (rooms[i][j].isPillar() == true) {
                            hasPillar++;
                        }
                    } 
                     else {
                    	int random=(int)(Math.random() * 7) + 4;
                    	rooms[i][j] = Room.newRoom(random);
                    }
                    
                    rooms[i][j].setNorth(validMove(i, j + 1));
                    rooms[i][j].setSouth(validMove(i, j - 1));
                    
                    rooms[i][j].setWest(validMove(i - 1, j));
                    rooms[i][j].setEast(validMove(i + 1, j));
                }
            }

            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms.length; j++) {
                    if (rooms[i][j].isEntrance() == true) {
                        hero.setX(i);
                        hero.setY(j);
                    }
                }
            }
        }
        return rooms;
    }

    public void play(Room[][] room, Hero hero){
    	
        while(hero.isAlive() && dungeonCondition == false) {	
            System.out.println(room[hero.getX()][hero.getY()].toString());

            //Monster room
            if (room[hero.getX()][hero.getY()].getNumMons() > 0) {
            	System.out.println("You encounter a Goblin!");
                battle(hero, room[hero.getX()][hero.getY()].getMonster());
                room[hero.getX()][hero.getY()].setNumMons(0);
            }
            //Healing pot room
            else if(room[hero.getX()][hero.getY()].isHealingPot() == true){
            	room[hero.getX()][hero.getY()].setHealingPot(false);
                hero.setNumPotions(hero.getNumPotions()+1);
                System.out.println("Found a healing potion in this room!");
                System.out.println(hero.getName() + " has " + hero.getNumPotions() + " Healing potion(s)");
            
            }
            //Pit room
            else if(room[hero.getX()][hero.getY()].isPit() == true){
            	room[hero.getX()][hero.getY()].setPit(false);
                hero.subtractHitPoints((int)(Math.random() * 20) + 1);


                System.out.println("Ough! You felt in the pit and got damaged!");
                System.out.println(hero.getName() + " has " + hero.getHitPoints() + " HP left");
            }
            //Pillar room
            else if(room[hero.getX()][hero.getY()].isPillar() == true){
                hero.setNumPillars(hero.getNumPillars()+1);
                room[hero.getX()][hero.getY()].setPillar(false);
                System.out.println("That's a great move! YOU FOUND A PILLAR!");
                if(hero.getNumPillars() >= 4){
                    System.out.println("You have reached :" + hero.getNumPillars() + " pillars, AMAZING!");
                    dungeonCondition = true;
                    break;
                }
            }
            //Vision Potion room
           else if(room[hero.getX()][hero.getY()].isVisionPot() == true) {
            	hero.setNumVisionPotions(hero.getNumPotions()+1);
                room[hero.getX()][hero.getY()].setVisionPot(false);
                System.out.println("You entered  The Vision Potion room!  It will help you see current room as well as rooms surrounding!");
                System.out.print("For your vision that show the maze press M, anything else to deny ->");
                visionRespone = sc.next().toLowerCase();
                if(visionRespone.equals("m")) {
                	//visionMap += dungeonRooms[hero.getX()][hero.getY()].toString();
                	visionMap = toString(room, hero);
                    System.out.print(visionMap); //THIS WILL PRINT THE 8 ROOMS INFO IN MAZE...
                }

             } 
          //  }

            System.out.println("........REPORT........");
            System.out.println("Name: "+hero.getName() + "\n"
                             +  "HP: "+ hero.getHitPoints() + "\n"
                             +  "Potion(s) left: " + hero.getNumPotions() + "\n"
                             +  "Vision Potion(s) left: " + hero.getNumVisionPotions() + "\n"
                             +  "Pillar(s): " + hero.getNumPillars() + " /4." + "\n");
            System.out.println("........CURRENT LOCATION........");

            if(!hero.isAlive()){
                break;
            }

            if(hero.getNumPotions() > 0) {
                System.out.println("Would you prefer to use any potions? Y/N ->");
                char response = sc.next().charAt(0);
                if(response == 'y' || response == 'Y')
                    hero.drinkHealingPotion();
                else System.out.println("Okay let's keep going!");
            }

            if(!hero.isAlive()){
                break;
            }
            System.out.println(room[hero.getX()][hero.getY()].toString());
            System.out.println("You are at: [" + hero.getX() + "][" + hero.getY() + "]");
            System.out.println("................................");
            canMove(room[hero.getX()][hero.getY()], hero);
    }
    
}

    public static void battle(Hero theHero, Monster theMonster)
     {
        char pause = 'p';
        System.out.println(theHero.getName() + " battles " +
                theMonster.getName());
        System.out.println("---------------------------------------------");

        //do battle
        while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
        {
            //hero goes first
            theHero.battleChoices(theMonster);

            //monster's turn (provided it's still alive!)
            if (theMonster.isAlive())
                theMonster.attack(theHero);

            //let the player bail out if desired
            System.out.print("\n-->q to quit, anything else to continue: ");
            pause = sc.next().charAt(0);

        }//end battle loop

        if (!theMonster.isAlive()) {
            System.out.println(theHero.getName() + " was victorious!");
            pause = 'q';
        }
        else if (!theHero.isAlive()) {
            System.out.println(theHero.getName() + " was defeated :-(");
            pause = 'q';
        }
        //both are alive so user quit the game
        else {
            pause = 'q';
            System.out.println("Quitters never win ;-)");
        }
    }//end battle method

    public static void canMove(Room room, Hero hero){
    	
    	room.setNorth(validMove(hero.getX()-1,hero.getY()));
        room.setSouth(validMove(hero.getX()+1,hero.getY()));
    	room.setWest(validMove(hero.getX(),hero.getY()-1));
        room.setEast(validMove(hero.getX(),hero.getY()+1));
        
        System.out.println("\nThere is your valid moves: ");
        if(room.isNorth()) {
        	System.out.println("North(up)");
        }
        if(room.isWest()) {
        	 System.out.println("South(down)");
        }
        if(room.isWest()) {
        	System.out.println("West(left)");
        }
        if(room.isEast()) {
        	System.out.println("East(right)");
        }
        
        System.out.print("Enter N for North, S for South, W for West, E for East. You choose > ");

        char makeMove = sc.next().charAt(0);
        moveMyHero(room, hero, makeMove);
    }

    public static boolean validMove(int x, int y) {
        return x>=0 && x <=4 && y >= 0 && y <= 4;
    }

    public static void moveMyHero(Room room, Hero hero, char move){
    	boolean pass =false;

        while (pass==false){
            if(move == 'N' || move == 'n' && room.isNorth()== true){
            	hero.setX(hero.getX() - 1);
            	pass = true;
            }

            else if(move == 'S' || move == 's' && room.isSouth()== true ){
            	hero.setX(hero.getX() + 1);
            	pass = true;
            }

            else if(move == 'W' || move == 'w' && room.isWest()== true ){
            	hero.setY(hero.getY() - 1);
            	pass = true;
            }

            else if(move == 'E' || move == 'e' && room.isEast()== true ){
            	hero.setY(hero.getY() + 1);
            	pass = true;
            }
        }
    }

       //This method will give hero vision
       public String toString(Room[][] room, Hero hero){
    	
    	String vision="";
    	for(int x = hero.getX(); x < room.length; x++) {
            for (int y = hero.getY(); y < room.length; y++) {
            	vision += "room's coordinate: [" + (x-1 )+ "][" + (y-2) + "]" + "\n";
            	vision += "room's coordinate: [" + x + "][" + (y-1) + "]" + "\n";
            	vision += "room's coordinate: [" + (x+1) + "][" + (y-1) + "]" + "\n";
            	vision += "room's coordinate: [" + (x-1) + "][" + y + "]" + "\n";
            	vision += "room's coordinate: [" + x + "][" + y + "]" + "\n";
            	vision += "room's coordinate: [" + (x+1) + "][" + y + "]" + "\n";
            	vision += "room's coordinate: [" + (x-1) + "][" + (y+1) + "]" + "\n";
            	vision += "room's coordinate: [" + x + "][" + (y+1) + "]" + "\n";
            	vision += "room's coordinate: [" + (x+1) + "][" + (y+1) + "]" + "\n";
                
                vision += room[x][y].toString();
            }
        }
       return vision;
  }
   /*  public String theMap(Room[][] dungeon){
        String map ="";
        for(int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon.length; j++) {
                theWholeMap += "\nroom's coordinate: [" + i + "][" + j + "]" + "\n";
                theWholeMap += dungeon[i][j].toString();

            }
        }

        return map;  } */
 }






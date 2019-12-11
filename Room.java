import java.util.Observable;
import java.util.Random;

public class Room   {

    private String roomName;
    private  boolean isHealingPot;
    private  boolean isPit ;
    private  boolean isEntrance;
    private  boolean isExit;
    private  boolean isPillar ;
    private Monster monster;
    private  int numMons;
    //Doors:
    private  boolean north = false;
    private  boolean south = false;
    private  boolean west = false;
    private  boolean  east = false;
    private boolean isVisionPot =false;


    // when the room has monster
    private Room (String roomName, Monster monster, int numMons, boolean isPit, boolean isPillar, boolean isHealingPot,boolean isEntrance,boolean isExit, boolean isVisionPot){
        this.roomName  = roomName;
        this.monster = monster;
        this.numMons = numMons;
        this.isPit = isPit;
        this.isPillar = isPillar;
        this.isHealingPot = isHealingPot;
        this.isEntrance = isEntrance;
        this.isExit = isExit;
        this.isVisionPot=isVisionPot;
    }
    
    // room has no monster
    private Room (String roomName, int numMons, boolean isPit, boolean isPillar, boolean isHealingPot, boolean isEntrance,boolean isExit, boolean isVisionPot) {
        this.roomName = roomName;
        this.numMons = numMons;
        this.isPit = isPit;
        this.isPillar = isPillar;
        this.isHealingPot = isHealingPot;
        this.isEntrance = isEntrance;
        this.isExit = isExit;
        this.isVisionPot = isVisionPot;
    }



    //CREAT THE NEW ROOM WITH ITEMS/BEHAVIORS
    public static Room newRoom(int ranNum4Room){
        String nameRoom = " ";
        int amountMonsterToBeAssign = 0;
		Monster monster;
        MonsterFactory monsterFac = new MonsterFactory();
		monster= monsterFac.buildMonster((int)(Math.random() * 3) + 1);
        boolean createHealingPot = false;
        boolean createPitRoom = false;
        boolean createPillar = false;
        boolean createEntrance = false;
        boolean createExit = false;
        boolean createVisionPot=false;



        switch (ranNum4Room){
            case 1:
            	nameRoom = "The Entrance room";
                amountMonsterToBeAssign = 0;
                createEntrance = true;
                break;

            case 2:
            	nameRoom = "The exit room";
                amountMonsterToBeAssign = 0;
                createExit = true;
                break;

            case 3:
            	nameRoom = "The room";
                amountMonsterToBeAssign = 1; //THIS ROOM WILL HAVE  1 MONSTER
                break;
                
            case 4:
            	nameRoom = "The Healing Potion room";
              //  amountMonsterToBeAssign = ThreadLocalRandom.current().nextInt(0,1); //THIS ROOM WILL HAVE RANDOMLY 0 or 1 MONSTER
                amountMonsterToBeAssign=(int)(Math.random() * 1) + 0;
                createHealingPot = true;
                break;
                
            case 5:
            	nameRoom = "The pit room";
                amountMonsterToBeAssign = 0;
                createPitRoom = true;
                break;

            case 6:
            	nameRoom = "The Pillar room";
                amountMonsterToBeAssign=(int)(Math.random() * 1) + 0;
            	createPillar = true;
                break;
            case 7:
            	nameRoom = "The Vision Potion room";
                amountMonsterToBeAssign=0;
                createVisionPot=true;
                break;
        }

        if(amountMonsterToBeAssign <= 0 )
            return new Room(nameRoom,amountMonsterToBeAssign,createPitRoom,createPillar,createHealingPot, createEntrance, createExit,createVisionPot);
        else
            return new Room(nameRoom, monster, amountMonsterToBeAssign,createPitRoom,createPillar, createHealingPot, createEntrance, createExit,createVisionPot);

    }
    public String getRoomName() {    return roomName;}
    public  boolean isHealingPot() {    return isHealingPot; }
    public void setHealingPot(boolean healingPot) {    isHealingPot = healingPot;}


    public  boolean isPit() { return isPit;}
    public void setPit(boolean pit) {    isPit = pit; }

    public  boolean isPOO() { return isPillar; }
    public void setPOO(boolean POO) {      isPillar = POO;  }

    
    public  boolean isEntrance(){return isEntrance;  }
    public  boolean isExit() {     return isExit; }
    
    public Monster getMonster() {   return monster; }
    public  int getNumMons() {   return numMons;  }
    public void setNumMons(int numMons) {    this.numMons = numMons;  }
    
    public boolean isVisionPot() { return this.isVisionPot(); }
    public void setVisionPot(boolean vision) {this.isVisionPot=vision;}

    public  boolean isNorth() {    return north;  }
    public  boolean isSouth() {  return south; }
    public  boolean isWest() {    return west; }
    public  boolean isEast() {   return east; }

    public void setNorth(boolean north) {this.north = north;  }
    public void setSouth(boolean south) {  this.south = south; }
    public void setWest(boolean west) {  this.west = west;  }
    public void setEast(boolean east) {  this.east = east;   }

    public String toString(){

        String res;
        String N = "";
        String S = "";
        String W = "";
        String E = "";

        if(isNorth() == true)
            N = "-";
        else if(isNorth() == false)
            N = "*";

        if(isSouth() == true)
            S = "-";
        else if(isSouth() == false)
            S = "*";

        if(isWest() == true)
            W = "|";
        else if (isWest() == false)
            W = "*";

        if(isEast() == true)
            E = "|";
        else if (isEast() == false)
            E = "*";

        this.roomName = getRoomLetters();


        res = "*" + N + "*" + "\n" +
               W + this.roomName + E + "\n" +
               "*" + S + "*" ;
        return res;
    }

    public  String getRoomLetters(){
        String Pillar = "P";
        String Pit = "P"; // Pit = Trap
        String Entrance = "I"; //IN
        String Exit = "O"; //OUT
        String HealingPot = "H";
        String Empty = "E";
        String Monster = "X";
        String VisionPotion ="V";
        if(getNumMons() > 0){
            return Monster;
        }
        else if(isPit() == true)
            return this.roomName = Pit;

        else if(isEntrance == true)
            return this.roomName = Entrance;

        else if(isExit() == true)
            return this.roomName = Exit;
        else if(isVisionPot() == true )
        	return this.roomName=VisionPotion;

        else if(isHealingPot == true)
            return this.roomName = HealingPot;

        else if(isPOO() == true)
            return this.roomName = Pillar;

        else return this.roomName = Empty;

    }




}

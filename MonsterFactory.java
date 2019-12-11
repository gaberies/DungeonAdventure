// add MonsterFactory class to create monster
public class MonsterFactory {

    public Monster buildMonster(int choice) {
    	Monster monster = null;
        switch (choice) {
        case 1:
        	monster = new Ogre();
            break;
        case 2:
        	monster = new Skeleton();
            break;
        case 3:
        	monster = new Gremlin();
            break;
        default: return new Skeleton();
        }
        return monster;
    }
}


 

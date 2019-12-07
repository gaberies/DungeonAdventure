



public class MonsterFactory {

    public Monster buildMonster(int choice){
        switch(choice){
            case 1: return new Gremlin();

            case 2: return new Ogre();

            case 3: return new Skeleton();

            // if fail then returning the default monster which skeleton

            default: return new Skeleton();
        }

    }
}
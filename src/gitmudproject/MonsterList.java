package gitmudproject;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * The idea was to have this hold all the monsters in an arraylist...
 */
public class MonsterList
{
    private ArrayList<Monster> monsterArray;

    public MonsterList()
    {
        monsterArray = new ArrayList();
        createMonsterList();
    }

    public Monster choseMonster()
    {
        Random rand = new Random();
        int getMonster = rand.nextInt(4);

        return monsterArray.get(getMonster);
    }
    
    private void createMonsterList()
    {
        //== creating the monsters
        monsterArray.add(new Monster(50, 10, "Your mother"));
        monsterArray.add(new Monster(50, 10, "monster2"));
        monsterArray.add(new Monster(50, 10, "monster3"));
        monsterArray.add(new Monster(50, 10, "monster4"));
        monsterArray.add(new Monster(50, 10, "monster5"));
    }

    public ArrayList<Monster> getMonsterArray()
    {
        return monsterArray;
    }
    
    
}

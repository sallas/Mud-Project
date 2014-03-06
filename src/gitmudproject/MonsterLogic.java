package gitmudproject;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * The idea was to have this hold all the monsters in an arraylist...
 */
public class MonsterLogic
{

    private ArrayList<Monster> monsterArray;
    private ArrayList<String> monsterCommenNames;
    private ArrayList<String> monsterBigNames;

    public MonsterLogic()
    {
        monsterArray = new ArrayList();
        monsterCommenNames = new ArrayList<>();
        monsterBigNames = new ArrayList<>();
        createMonsterList();
        SetUpBigMonsterNames();
        setUpCommenMonsterNames();
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

    private void setUpCommenMonsterNames()
    {

        monsterCommenNames.add("Your mother");
        monsterCommenNames.add("Jette");
        monsterCommenNames.add("WereBat");
        monsterCommenNames.add("Bats");
        monsterCommenNames.add("BitterFly");
        monsterCommenNames.add("Dead Pirate");
    }

    private void SetUpBigMonsterNames()
    {
        monsterBigNames.add("The BIGGEST MONSTER IN GAME");
        monsterBigNames.add("YETI");
        monsterBigNames.add("GARGOYLE");
        monsterBigNames.add("Dead Baron");
        monsterBigNames.add("Cave Troll");
    }

    public Monster createRandomMonster(int roomNum)
    {
        if (roomNum > 3)
        {
            //== Creates an monster with random name and HP 20-39
            //== and damage 20-29
            Random ran = new Random();
            String monsterName = monsterBigNames.get(ran.nextInt(4));
            int monsterHP = ran.nextInt(40) + 20;
            int monsterDMG = ran.nextInt(30) + 20;

            return (new Monster(monsterHP, monsterDMG, monsterName));

        }
        else
        {
            //== Creates an monster with random name and HP 10-19
            //== and damage 5-14
            
            Random ran = new Random();
            String monsterName = monsterCommenNames.get(ran.nextInt(5));
            int monsterHP = ran.nextInt(20) + 10;
            int monsterDMG = ran.nextInt(10) + 5;

            return (new Monster(monsterHP, monsterDMG, monsterName));
        }
    }
}

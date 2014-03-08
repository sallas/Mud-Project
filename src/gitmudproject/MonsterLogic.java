package gitmudproject;

import java.util.ArrayList;
import java.util.Random;

public class MonsterLogic
{
    private ArrayList<String> monsterCommonNames;
    private ArrayList<String> monsterBigNames;

    public MonsterLogic()
    {
        monsterCommonNames = new ArrayList<>();
        monsterBigNames = new ArrayList<>();
        SetUpBigMonsterNames();
        setUpCommenMonsterNames();
    }

    private void setUpCommenMonsterNames()
    {

        monsterCommonNames.add("Your mother");
        monsterCommonNames.add("Jette");
        monsterCommonNames.add("WereBat");
        monsterCommonNames.add("Bats");
        monsterCommonNames.add("BitterFly");
        monsterCommonNames.add("Dead Pirate");
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
        Random ran = new Random();
        if (roomNum > 3)
        {
            //== Creates an monster with random name and HP 20-39
            //== and damage 20-29
            String monsterName = monsterBigNames.get(ran.nextInt(4));
            int monsterHP = ran.nextInt(40) + 20;
            int monsterDMG = ran.nextInt(30) + 20;
            int xp = monsterHP + monsterDMG + ran.nextInt(60);

            return (new Monster(monsterHP, monsterDMG, monsterName, xp));

        }
        else
        {
            //== Creates an monster with random name and HP 10-19
            //== and damage 5-14
            String monsterName = monsterCommonNames.get(ran.nextInt(5));
            int monsterHP = ran.nextInt(20) + 10;
            int monsterDMG = ran.nextInt(10) + 5;
            int xp = monsterHP + monsterDMG + ran.nextInt(22);
            
            return (new Monster(monsterHP, monsterDMG, monsterName, xp));
        }
    }
}

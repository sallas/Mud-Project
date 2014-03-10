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
        String monsterName;
        if (roomNum > 3)
        {
            monsterName = monsterBigNames.get(ran.nextInt(4));

        } else
        {
            monsterName = monsterCommonNames.get(ran.nextInt(5));

        }
        //hp, dmg and xp grows with higher roomNum
        int monsterHP = ran.nextInt(30 + (roomNum * 3)) + 10 + roomNum;  
        int monsterDMG = ran.nextInt(10 + (roomNum * 3)) + 5 + roomNum;
        int xp = monsterHP + monsterDMG + ran.nextInt(60);

        return (new Monster(monsterHP, monsterDMG, monsterName, xp));
    }
}

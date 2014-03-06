/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitmudproject;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Peter
 */

/**
 * 
 * The idea was to have this hold all the monsters in an arraylist...
 */
public class MonsterList
{

    private Monster monster1, monster2, monster3, monster4, monster5;
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

    public void createMonsterList()
    {
        //== creating the monsters
        monster1 = new Monster(50, 10, "Your mother");
        monster2 = new Monster(50, 10, "monster2");
        monster3 = new Monster(50, 10, "monster3");
        monster4 = new Monster(50, 10, "monster4");
        monster5 = new Monster(50, 10, "monster5");
        monsterArray.add(monster1);
        monsterArray.add(monster2);
        monsterArray.add(monster3);
        monsterArray.add(monster4);
        monsterArray.add(monster5);
    }
}

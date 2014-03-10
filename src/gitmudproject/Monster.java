package gitmudproject;

import java.util.Random;

public class Monster
{

    private int health;
    private int damage;
    private String name;
    private int xp;

    public Monster(int health, int damage, String name, int xp)
    {
        this.health = health;
        this.damage = damage;
        this.name = name;
        this.xp = xp;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public String getName()
    {
        return name;
    }

    public int getDamage(int roomNum)
    {
        Random ran = new Random();

        int maxDamage = damage;
        int level = roomNum;
        int levelSubtraction=0;
        level++;
//        if (level == 0)
//        {
//            System.out.println("skriver level 2. "+level);
//            level++;
//        }
        while(levelSubtraction<=0)
        {
            levelSubtraction = ran.nextInt(level)+1;
        }
        int minimum  = maxDamage - (maxDamage/ levelSubtraction);
        
        
        if(minimum == maxDamage)
            minimum = (int) (minimum * 0.8);// if minimum is not change it is subtracted 10%

        int newDamage = maxDamage - minimum;

        return newDamage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public int getXp()
    {
        return xp;
    }

    public void setXp(int xp)
    {
        this.xp = xp;
    }

}

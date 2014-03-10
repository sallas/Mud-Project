package gitmudproject;

import java.util.Random;

public class Player
{
    
    private int health;
    private int maxHealth;
    private Room currentRoom;
    private int weaponDamage;
    private int currentXp;
    private int maxXp;
    private int level;
    private int baseDamage;

 
    public Player()
    {
        maxHealth = 100;
        health = maxHealth;
        weaponDamage = 10;
        currentXp = 0;
        maxXp = 100;
        level = 1;
        baseDamage = 0;
    }
    
    public boolean giveXp(int xp)
    {
        boolean leveledUp = false;
        currentXp += xp;
        while(currentXp >= maxXp)  //levels player as long as he is over xp threshold
        {
            levelUp();
            currentXp -= maxXp;
            maxXp *= 2;  
            leveledUp = true;
        }
        return leveledUp;
    }
    
    private void levelUp()  //increases stats
    {
        level++;
        baseDamage++;
    }
    
    public int getDamage()
    {
        Random rand = new Random();
        return weaponDamage + baseDamage + rand.nextInt(10);
    }
    
    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom)
    {
        this.currentRoom = currentRoom;
    }

    public int getWeaponDamage()
    {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage)
    {
        this.weaponDamage = weaponDamage;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }

    public int getCurrentXp()
    {
        return currentXp;
    }


    public int getMaxXp()
    {
        return maxXp;
    } 

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public int getBaseDamage()
    {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage)
    {
        this.baseDamage = baseDamage;
    }
}

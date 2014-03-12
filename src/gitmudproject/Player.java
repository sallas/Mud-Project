package gitmudproject;

import java.util.Random;

public class Player
{
    private Spells spells;
    private Stats stats;
    private int health;
    private int maxHealth;
    private Room currentRoom;
    private int weaponDamage;
    private int currentXp;
    private int maxXp;
    private int level;
    private int baseDamage;
    private Weapon weapon;

 
    public Player()
    {
        maxHealth = 100;
        health = maxHealth;
        weaponDamage = 10;
        currentXp = 0;
        maxXp = 100;
        level = 1;
        baseDamage = 0;
        weapon = null;    
        stats = new Stats(5,5,5);
        spells = new Spells(20, 25);
    }
    
    void equipWeapon(Weapon weapon)
    {
        this.weapon = weapon;
    }
    
    boolean hasWeapon()
    {
        return weapon != null;
    }
    
    void unEquipWeapon()
    {
        weapon = null;
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
            stats.agility ++;
            stats.intellect ++;
            stats.strength ++;
            System.out.println("Str: "+stats.strength+" Agi: "+stats.agility+" Int: "+stats.intellect);
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
        int extraDamage = 0;
        if(weapon != null)
        {
            extraDamage = weapon.getDamage();
        }
        
        int damage = weaponDamage + baseDamage + rand.nextInt(10) + extraDamage;
        if (rand.nextInt(100) < getCritChance())
        {
            damage *= 2;
            System.out.println("You dealt a critical hit");
        }
        return damage;
    }
    
    public int fireBall()
    {
        return spells.getFireball();
    }
    public int Heal()
    {
        return spells.getHeal();
    }
    
    public int getCritChance()
    {
        return stats.agility;
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

    public Weapon getWeapon()
    {
        return weapon;
    }
}

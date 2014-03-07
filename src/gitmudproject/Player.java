package gitmudproject;

public class Player
{
    
    private int health;
    private int maxHealth;
    private Room currentRoom;
    private int damage;

 
    public Player()
    {
        maxHealth = 100;
        health = maxHealth;
        damage = 10;
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

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }
    
    

    
}

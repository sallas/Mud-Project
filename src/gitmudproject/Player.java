package gitmudproject;

public class Player
{
    
    private int health;
    private Room currentRoom;
    private int damage;

 
    public Player()
    {
        health = 100;
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
    
    

    
}

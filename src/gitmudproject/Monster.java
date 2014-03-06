package gitmudproject;


public class Monster
{
    private int health;
    private int damage;
    private String name;

    public String getName()
    {
        return name;
    }
    private Room currentRoom;

    public Monster(int health, int damage, String name)
    {
        this.health = health;
        this.damage = damage;
        this.name = name;
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
    
    public int damage()
    {
        return damage;
    }
}

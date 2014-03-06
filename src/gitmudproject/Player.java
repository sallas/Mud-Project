package gitmudproject;

public class Player
{
    
    private int health;
    private Room currentRoom;

 
    public Player()
    {
        health = 100;
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

    
}

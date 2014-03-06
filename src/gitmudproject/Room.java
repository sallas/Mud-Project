package gitmudproject;

public class Room
{
    Monster monster;

    public Room(Monster monster)
    {
        this.monster = monster;
    }

    public Monster getMonster()
    {
        return monster;
    }

    public void setMonster(Monster monster)
    {
        this.monster = monster;
    }
    
    public String getMonsterName()
    {
        return monster.getName();
    }
    
    
}

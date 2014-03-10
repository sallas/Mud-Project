package gitmudproject;

public class Room
{
    Monster monster;

    public Room(int roomNum)
    {
        MonsterLogic monsterLogic = new MonsterLogic();
        monster = monsterLogic.createRandomMonster(roomNum);
    }
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

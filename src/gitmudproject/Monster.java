package gitmudproject;


public class Monster
{
    private int health;
    private int damage;
    private String name;

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
    
    public String getName()
    {
        return name;
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

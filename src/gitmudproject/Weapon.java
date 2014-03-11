package gitmudproject;

public class Weapon
{

    int numberOfUse;
    String name;
    int damage;

    public Weapon(int maxUse, String name, int damage)
    {
        this.numberOfUse = maxUse;
        this.name = name;
        this.damage = damage;
    }
    
    @Override
    public String toString()
    {
        return name + "\t" + damage + "\t" + numberOfUse;
    }

    public int getNumberOfUse()
    {
        return numberOfUse;
    }

    public void setNumberOfUse(int numberOfUse)
    {
        this.numberOfUse = numberOfUse;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

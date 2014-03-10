package gitmudproject;

public class Weapon
{

    int numberOfUse;
    String name;

    public Weapon(int maxUse, String name)
    {
        this.numberOfUse = maxUse;
        this.name = name;
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

}

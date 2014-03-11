package gitmudproject;

public class Potion
{

    int healingpoint;
    String potionName;

    public Potion(int healingpoint, String potionName)
    {
        this.healingpoint = healingpoint;
        this.potionName = potionName;
    }
    
    @Override
    public String toString()
    {
        return potionName + "\t" + healingpoint;
    }

    public int getHealingpoint()
    {
        return healingpoint;
    }

    public void setHealingpoint(int healingpoint)
    {
        this.healingpoint = healingpoint;
    }

    public String getPotionName()
    {
        return potionName;
    }

    public void setPotionName(String potionName)
    {
        this.potionName = potionName;
    }

}

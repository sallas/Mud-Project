/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gitmudproject;

/**
 *
 * @author nickhelmark
 */
public class Stats
{
    int strength;
    int agility;
    int intellect;

    public Stats(int strength, int agility, int intellect)
    {
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }
    public double getStrength()
    {
        return strength;
    }

    public void setStrength(int Strength)
    {
        this.strength = Strength;
    }

    public int getAgility()
    {
        return agility;
    }

    public void setAgility(int Agility)
    {
        this.agility = Agility;
    }

    public int getIntellect()
    {
        return intellect;
    }

    public void setIntellect(int Intellect)
    {
        this.intellect = Intellect;
    }

    
}

     



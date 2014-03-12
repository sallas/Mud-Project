/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gitmudproject;

public class Spells
{
  private int fireball;
  private int Heal;

    public Spells(int fireball, int Heal)
    {
        this.fireball = fireball;
        this.Heal = Heal;
    }

    public int getFireball()
    {
        return fireball;
    }

    public void setFireball(int fireball)
    {
        this.fireball = fireball;
    }

    public int getHeal()
    {
        return Heal;
    }

    public void setHeal(int Heal)
    {
        this.Heal = Heal;
    }
  
  
}

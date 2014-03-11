package gitmudproject;

import java.util.ArrayList;
import java.util.List;

public class Inventory
{

    List<Weapon> weapons = new ArrayList<>();
    List<Potion> potions = new ArrayList<>();
    
    public Inventory()
    {
        setUpStarterInventory();
    }
    
    private void setUpStarterInventory()
    {
        potions.add(new Potion(20, "Healing potion"));
        potions.add(new Potion(30, "Healing potion"));
        weapons.add(new Weapon(2, "Bronze axe", 2));
        weapons.add(new Weapon(1, "Bronze sword", 3));
    }

    public boolean addWeapon(Weapon w)  // made to return a boolean incase we want to have a invtory limit later
    {
        weapons.add(w);
        return true;
    }

    public boolean addPotion(Potion p)
    {
        potions.add(p);
        return true;
    }

    public String weaponsDisplayText()
    {
        String weaponText = "";
        for (Weapon w : weapons)
        {
            weaponText += w.toString() + "\n";
        }
        return weaponText;
    }

    public String potionDisplayText()
    {
        String potionText = "";
        for (Potion p : potions)
        {
            potionText += p.toString() + "\n";
        }
        return potionText;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitmudproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Tomoe
 */
public class WeaponList
{

    ArrayList<Weapon> weaponArray = new ArrayList();

    public WeaponList()
    {
        setUpWeapon();

    }

    private ArrayList<Weapon> setUpWeapon()
    {
        weaponArray.add(new Weapon(5, "Shuriken"));
        weaponArray.add(new Weapon(3, "Giga Ax"));
        weaponArray.add(new Weapon(2, "Flaming Sword"));
        weaponArray.add(new Weapon(5, "Brass knuckles"));
        weaponArray.add(new Weapon(1, "Bazooka"));
        return weaponArray;
    }

    public Weapon createWeapon()

    {
        Collections.shuffle(weaponArray);

        return weaponArray.get(1);
    }

    public int getDamage(String weaponName)
    {
        Random ran = new Random();
        int weaponDamage = 0;
        if (weaponName.equals("Shuriken"))
        {
            weaponDamage = ran.nextInt(3) + 1; //damage 1-3 
        }
        else if (weaponName.equals("Giga Ax"))
        {
            weaponDamage = ran.nextInt(3) + 3; //damage 3-5
        }

        else if (weaponName.equals("Flaming Sword"))
        {
            weaponDamage = ran.nextInt(4) + 5;//damage 5-8
        }
        else if (weaponName.equals("Brass knuckles"))
        {
            weaponDamage = ran.nextInt(3) + 3;//damage 3-5
        }
        else if (weaponName.equals("Bazooka"))
        {
            weaponDamage = ran.nextInt(3) + 8; //damage 8-10
        }
        return weaponDamage;
    }

}

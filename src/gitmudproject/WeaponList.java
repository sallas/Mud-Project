package gitmudproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WeaponList
{

    ArrayList<Weapon> weaponArray = new ArrayList();

    public WeaponList()
    {
        setUpWeapon();
    }

    private ArrayList<Weapon> setUpWeapon()
    {
        Random ran = new Random();
        
        weaponArray.add(new Weapon(5, "Shuriken", ran.nextInt(3) + 1));
        weaponArray.add(new Weapon(3, "Giga Ax", ran.nextInt(3) + 3));
        weaponArray.add(new Weapon(2, "Flaming Sword", ran.nextInt(4) + 5));
        weaponArray.add(new Weapon(5, "Brass knuckles", ran.nextInt(3) + 3));
        weaponArray.add(new Weapon(1, "Bazooka", ran.nextInt(3) + 8));
        return weaponArray;
    }

    public Weapon createWeapon()
    {
        setUpWeapon();
        Collections.shuffle(weaponArray);

        return weaponArray.get(1);
    }
}

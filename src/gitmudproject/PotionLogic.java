package gitmudproject;

import java.util.ArrayList;
import java.util.Random;

public class PotionLogic
{

    private ArrayList<String> potionNameArray;

    public PotionLogic()
    {
        potionNameArray = new ArrayList();
        setUpPotion();
    }

    private ArrayList<String> setUpPotion()
    {
        potionNameArray.add("Angel Potion");
        potionNameArray.add("Flower Potion");
        potionNameArray.add("Light Potion");
        potionNameArray.add("Sky Potion");
        potionNameArray.add("Sun Potion");

        return potionNameArray;
    }

    public Potion createPotion()

    {
        Random ran = new Random();
        String potionName = potionNameArray.get(ran.nextInt(potionNameArray.size()));
        int healpoint = ran.nextInt(70) - 20; // can be minus healpoint. "poisoned potion"

        return (new Potion(healpoint, potionName));
    }

}

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
        potionNameArray.add("Potion Angel");
        potionNameArray.add("Potion Flower");
        potionNameArray.add("Potion Light");
        potionNameArray.add("Potion Sky");
        potionNameArray.add("Potion Sun");

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

package gitmudproject;

import java.util.Scanner;

public class GameLogic
{

    private Player player;
    private Room room;
    private MonsterLogic monsterLogic;
    private PotionLogic potionLogic;
    private Monster monster;

    public void startGame(Player player)
    {
        monsterLogic = new MonsterLogic();
        potionLogic = new PotionLogic();
        this.player = player;
        System.out.println("Welcome player");

    }

    public void runGame()
    {
        int roomNum = 0; //just for testing 
        Scanner scan = new Scanner(System.in);
        while (player.getHealth() > 0)
        {

            this.monster = monsterLogic.createRandomMonster(roomNum);

            room = new Room(monster);
            System.out.println("You see a " + monster.getName() + " which has " + monster.getHealth() + " health");
            if (engagetMonster(monster) != true)
            {
                break;              // Player died
            }
            System.out.print("Would you like to move to the next room? (y/n): ");
            if ("n".equalsIgnoreCase(scan.next()))
            {
                break;
            }
            roomNum++; // getting the number and harder monster
            System.out.println("\n\n");

        }
        System.out.println("Good bye");
    }

    private boolean engagetMonster(Monster monster)
    {
        Scanner scan = new Scanner(System.in);
        while (player.getHealth() > 0 && monster.getHealth() > 0)
        {
            boolean done = false;
            while (!done)
            {
                done = true;
                System.out.println("What would you like to do(write the corresponding number)"
                        + "         \n1: Attack\n2: Drink potion\n3: Use spell");
                int option = scan.nextInt();
                switch (option)
                {
                    case 1:
                        fightMonster(monster);
                        break;
                    case 2:
                        drinkPotion();
                        if(player.getHealth() <= 0)
                            System.out.println("\nYou died!");
                        else
                            attackedByMonster(monster);
                        break;
                    case 3:
                        System.out.println("That feature is not implemented");
                        break;
                    default:
                        System.out.println("That wasn't an option");
                        done = false;
                        break;
                }
            }

        }
        return player.getHealth() > 0;  // return true if player is alive
    }
    
    private void attackedByMonster(Monster monster)
    {
        player.setHealth(player.getHealth() - monster.getDamage());
        System.out.println(monster.getName() + " dealt " + monster.getDamage() + " to you");
        if (player.getHealth() <= 0)
        {
            System.out.println("\nYou died");
        }
        else
        {
            System.out.println("You've got " + player.getHealth() + " health remaining\n");
        }
    }

    private void fightMonster(Monster monster)
    {
        int damage = player.getDamage();
        monster.setHealth(monster.getHealth() - damage);
        System.out.println("You dealt " + damage + " to " + monster.getName());
        if (monster.getHealth() <= 0)
        {
            System.out.println("\nYou have slayed " + monster.getName());
            if(player.giveXp(monster.getXp()))  // if leveled up
                System.out.println("You leveled up, your level is now " + player.getLevel());
        }
        else
        {
            attackedByMonster(monster);
        }

    }

    private void drinkPotion()
    {
        Potion potion = potionLogic.createPotion();
        System.out.println("\nYou'are drinking "+ potion.getPotionName() );

        int currentHP = player.getHealth();
        int potionHP = potion.getHealingpoint();
        int newHP = currentHP + potionHP;
        if(newHP > player.getMaxHealth())
            newHP = player.getMaxHealth();

        if (potionHP < 0)
        {
            System.out.println("It was a poisoned potion! You've lost " + potionHP + " health!  \nYou have now " + newHP + " health\n");
        }
        else if (potionHP == 0)
        {
            System.out.println("Oops! This potion is out of dato... no efficiency...\n");
        }
        else
        {
            System.out.println("You've healed. You have now " + newHP + " health\n");
        }

        player.setHealth(newHP);
    }

}

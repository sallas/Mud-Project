package gitmudproject;

import java.util.Scanner;

public class GameLogic
{

    private Player player;
    private Room room;
    private MonsterLogic monsterLogic;
    private PotionLogic potionLogic;
    private Monster monster;
    int roomNum = 0; //just for testing 

    public void startGame(Player player)
    {
        monsterLogic = new MonsterLogic();
        potionLogic = new PotionLogic();
        this.player = player;
        System.out.println("Welcome player");

    }

    public void runGame()
    {

        Scanner scan = new Scanner(System.in);
        while (player.getHealth() > 0)
        {

            this.monster = monsterLogic.createRandomMonster(roomNum);

            room = new Room(monster);
            System.out.println("You see a " + monster.getName() + " it has " + monster.getHealth() + " health");
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
                        if (player.getHealth() <= 0)
                        {
                            System.out.println("\nYou died!");
                        }
                        else
                        {
                            attackedByMonster(monster);
                        }
                        break;
                    case 3:
                        System.out.println("This feature is not implemented");
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
        int monsterDamage = monster.getDamage(roomNum);
        player.setHealth(player.getHealth() - monsterDamage);
        System.out.println(monster.getName() + " dealt " + monsterDamage + " damage to you");
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
        System.out.println("You dealt " + damage + " damage to " + monster.getName());
        System.out.println(monster.getName()+ " Has " + monster.getHealth()+" hp left");
        if (monster.getHealth() <= 0)
        {
            System.out.println("\nYou have slain " + monster.getName());
            if (player.giveXp(monster.getXp()))  // if leveled up
            {
                System.out.println("You leveled up!, you're now level " + player.getLevel());
            }
        }
        else
        {
            attackedByMonster(monster);
        }

    }

    private void drinkPotion()
    {
        Potion potion = potionLogic.createPotion();
        System.out.println("\nYou just drank a " + potion.getPotionName());

        int currentHP = player.getHealth();
        int potionHP = potion.getHealingpoint();
        int newHP = currentHP + potionHP;
        if (newHP > player.getMaxHealth())
        {
            newHP = player.getMaxHealth();
        }

        if (potionHP < 0)
        {
            System.out.println("The potion was actually a poison, aahh! you just lost" + potionHP + " health!  \nYou only have " + newHP + " hp left :(\n");
        }
        else if (potionHP == 0)
        {
            System.out.println("Oops! It seems the potion was made by Tobias the alchemist of Chelmor, First Brewer of Hva Enterprises... it doesn't work, surprise!...\n");
        }
        else
        {
            System.out.println("You have gained " + newHP + " health.\n");
        }

        player.setHealth(newHP);
    }

}

package gitmudproject;

import java.util.List;
import java.util.Scanner;

public class GameLogic
{

    private Player player;
    private Room currentRoom;
    private PotionLogic potionLogic;
    private WeaponList weaponList;
    private Monster monster;
    private int roomNum = 0;
    private Inventory inventory;

    public void startGame(Player player)
    {
        potionLogic = new PotionLogic();
        weaponList = new WeaponList();
        this.player = player;
        System.out.println("Welcome player");
        inventory = new Inventory();

    }

    public void runGame()
    {

        Scanner scan = new Scanner(System.in);
        while (player.getHealth() > 0)
        {

            currentRoom = new Room(roomNum);
            monster = currentRoom.getMonster();
            System.out.println("You see a " + monster.getName() + " it has " + monster.getHealth() + " health");
            if (engagetMonster(monster) != true)
            {
                break;              // Player died
            }
            System.out.print("Would you like to move to the next room? (y/n): ");
            if ("n".equalsIgnoreCase(scan.next()))
            {
                System.out.println("Are you don't want to continue?(y/n)");
                if ("y".equalsIgnoreCase(scan.next()))
                {
                    break;
                }
            }
            roomNum++; // getting the number and harder monster
            System.out.println("\n\n");

        }
        System.out.println("Good bye");
    }

    private boolean engagetMonster(Monster monster)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("You've got " + player.getHealth() + " health remaining\n");
        while (player.getHealth() > 0 && monster.getHealth() > 0)
        {
            boolean done = false;
            while (!done)
            {
                done = true;
                System.out.println("What would you like to do(write the corresponding number)"
                        + "\n1: Attack\n2: Drink potion\n3: Use spell\n4: Use weapon"
                        + "\n5: Display inventory");
                int option = scan.nextInt();
                switch (option)
                {
                    case 1:
                        fightMonster(monster);
                        break;
                    case 2:
                        if (inventory.potionDisplayText().equals(""))
                        {
                            System.out.println("You have no potion at the moment");
                            break;
                        }
                        System.out.println("Choose from the following list");
                        System.out.println(inventory.potionDisplayText());
                        int answer = scan.nextInt();
                        Potion chosenPotion = choosePotion(answer - 1);
                        drinkPotion(chosenPotion);
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
                        castSpell();
                        break;

                    case 4:
                        useWeapon();
                        break;
                    case 5:
                        displayInventory();
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
            System.out.println(monster.getName() + " Has " + monster.getHealth() + " hp left");
            attackedByMonster(monster);
        }

    }

    private Potion choosePotion(int number)
    {
        List<Potion> potionList = inventory.getPotions();

        return potionList.get(number);
    }

    private void drinkPotion(Potion potion)
    {
        List<Potion> potionlist = inventory.getPotions();
        potionlist.remove(potion);
        inventory.setPotions(potionlist);

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
            System.out.println("The potion was actually a poison, aahh! you just lost " + potionHP + " health!  \nYou only have " + newHP + " hp left :(\n");
        }
        else if (potionHP == 0)
        {
            System.out.println("Oops! It seems the potion was made by Tobias the alchemist of Chelmor, First Brewer of Hva Enterprises... it doesn't work, surprise!...\n");
        }
        else if (newHP == player.getMaxHealth())
        {
            System.out.println("You have " + newHP + " health now. You are totally healthy!");
        }
        else
        {

            System.out.println("You have gained " + potionHP + " health.\n");

        }

        player.setHealth(newHP);
    }

    private void castSpell()
    {
        System.out.println("Which spell would you like to use?\n1: Fireball: 20dmg \n2: Heal: 25hp");
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        while (!done)
        {
            done = true;
            int option = scan.nextInt();
            switch (option)
            {
                case 1:
                    monster.setHealth(monster.getHealth() - player.fireBall());
                    System.out.println("You dealt " + player.fireBall() + " damage to " + monster.getName());
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
                        System.out.println(monster.getName() + " Has " + monster.getHealth() + " hp left");
                        attackedByMonster(monster);
                    }
                    break;
                case 2:
                    if ((player.getHealth() + player.Heal()) >= 100)
                    {
                        player.setHealth(100);
                        System.out.println("You have " + player.getHealth() + " hp");
                    }
                    else
                    {
                        player.setHealth(player.getHealth() + player.Heal());
                        System.out.println("You have received: " + player.getHealth() + " hp");
                    }
                    break;
                default:
                    System.out.println("That wasn't an option");
                    done = false;
                    break;
            }
        }
    }

    private void useWeapon()
    {
        Weapon weapon;
        if (player.hasWeapon())
        {
            weapon = player.getWeapon();
        }
        else
        {
            weapon = weaponList.createWeapon();
            player.equipWeapon(weapon);
        }

        System.out.println("You'are attacking with " + weapon.getName());
        int weaponDamage = weapon.getDamage();

        fightMonster(monster);
        int remainingUse = weapon.getNumberOfUse();
        weapon.setNumberOfUse(remainingUse - 1);
        if (remainingUse == 0)
        {
            System.out.println("The weapon is broke. You cannot use this anymore");
            player.unEquipWeapon();
        }
        else
        {
            if (remainingUse == 1)
            {
                System.out.println("You have one more use of this weapon.");

            }
            else
            {
                System.out.println("The remaining use of " + weapon.getName() + " is " + weapon.getNumberOfUse());
            }
        }

    }

    private void displayInventory()
    {
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        while (!done)
        {
            done = true;
            System.out.println("What would you like to look at(write the corresponding number)"
                    + "         \n1: Weapons\n2: Potions");
            int option = scan.nextInt();
            switch (option)
            {
                case 1:
                    System.out.println("Name\t\tDamage\tDurability");
                    System.out.println(inventory.weaponsDisplayText());
                    break;
                case 2:
                    System.out.println("Name\t\tHealing points");
                    System.out.println(inventory.potionDisplayText());
                    break;
                default:
                    System.out.println("That wasn't an option");
                    done = false;
                    break;
            }
        }
    }
}

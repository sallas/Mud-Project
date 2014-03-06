package gitmudproject;

import java.util.Scanner;

public class GameLogic
{
    private Player player;
    private Room room;
    private MonsterList monsterList;
   
    
    public void startGame(Player player)
    {
        monsterList = new MonsterList();
        this.player = player;
        System.out.println("Welcome player");
       
     
    }
    
    public void runGame()
    {
        Scanner scan = new Scanner(System.in);
        while(player.getHealth() > 0)
        {
            Monster monster = new Monster(30, 10, "TEMPNAME");
            room = new Room(monster);
            System.out.println("you see: "+monster.getName());
            if(engagetMonster(monster) != true)
                break;              // Player died
            System.out.print("Would you like to move to the next room? (y/n): ");
            if("n".equalsIgnoreCase(scan.next()))
                break;
            System.out.println("\n\n");
        }
        System.out.println("Good bye");
    }
    
    private boolean engagetMonster(Monster monster)
    {
        Scanner scan = new Scanner(System.in);
        while(player.getHealth() > 0 && monster.getHealth() > 0)
        {
            boolean done = false;
            while(!done)
            {
                done = true;
                System.out.println("What would you like to do(write the corresponding number)"
                        + "         \n1: Attack\n2: Drink potion\n3: Use spell");
                int option = scan.nextInt();
                switch(option)
                {
                    case 1: fightMonster(monster);
                        break;
                    case 2: System.out.println("That feature is not implemented");
                        break;
                    case 3: System.out.println("That feature is not implemented");
                        break;
                    default: System.out.println("That wasn't an option");
                        done = false;
                        break;
                }
            }
            
        }
        return player.getHealth() > 0;  // return true if player is alive
    }

    private void fightMonster(Monster monster)
    {
            
            monster.setHealth(monster.getHealth() - player.getDamage());
            System.out.println("You dealt " + player.getDamage() + " to " + monster.getName());
            if(monster.getHealth() <= 0)
            {
                System.out.println("\nYou have slayed " + monster.getName());
            }
            else
            {
                player.setHealth(player.getHealth() - monster.getDamage());
                System.out.println(monster.getName() + " dealt " + monster.getDamage() + " to you");
                if(player.getHealth() <= 0)
                {
                   System.out.println("\nYou died");
                }
            }
            System.out.println("You've got " + player.getHealth() + " health remaining\n");
    }
}

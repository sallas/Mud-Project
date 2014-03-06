package gitmudproject;

import java.util.Scanner;

public class GameLogic
{
    private Player player;
    private Room room;
    private MonsterList monsterList;
    private Monster monster;
   
    
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
            this.monster = monsterList.choseMonster();
            room = new Room(monster);
            System.out.println("you see: "+monster.getName());
            if(fightMonster(monster) != true)
                break;              // Player died
            System.out.print("Would you like to move to the next room? (y/n): ");
            if("n".equalsIgnoreCase(scan.next()))
                break;
        }
        System.out.println("Good bye");
    }
    
    private boolean fightMonster(Monster monster)
    {
        while(player.getHealth() > 0 && monster.getHealth() > 0)
        {
            player.setHealth(player.getHealth() - monster.getDamage());
            if(player.getHealth() > 0)
            {
                monster.setHealth(monster.getHealth() - player.getDamage());
                if(monster.getHealth() <= 0)
                {
                    System.out.println("You have slayed " + monster.getName());
                }
            }
            else
            {
                System.out.println("You died");
            }
            
        }
        return player.getHealth() > 0;  // return true if player is alive
    }
}

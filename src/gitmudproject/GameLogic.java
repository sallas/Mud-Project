package gitmudproject;

import java.util.Scanner;

public class GameLogic
{
    private Player player;
    private Room room;
    private MonsterLogic monsterLogic;
    private Monster monster;
   
    
    public void startGame(Player player)
    {
        monsterLogic = new MonsterLogic();
        this.player = player;
        System.out.println("Welcome player");
       
     
    }
    
    public void runGame()
    {
        int roomNum=0; //just for testing 
        Scanner scan = new Scanner(System.in);
        while(player.getHealth() > 0)
        {
            this.monster = monsterLogic.createRandomMonster(roomNum);
            room = new Room(monster);
            System.out.println("you see: "+monster.getName());
            if(fightMonster(monster) != true)
                break;              // Player died
            System.out.print("Would you like to move to the next room? (y/n): ");
            if("n".equalsIgnoreCase(scan.next()))
                break;
            roomNum++;
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

package gitmudproject;

import java.util.ArrayList;
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
            System.out.println("you see: "+room.getMonsterName());
            System.out.print("Would you like to move to the next room? (y/n): ");
            if("n".equalsIgnoreCase(scan.next()))
                break;
        }
        System.out.println("Good bye");
    }
}

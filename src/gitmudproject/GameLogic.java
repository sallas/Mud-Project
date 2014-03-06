package gitmudproject;

import java.util.Scanner;

public class GameLogic
{
    private Player player;
    private Room room;
    
    public void startGame(Player player)
    {
        this.player = player;
        System.out.println("Welcome player");
    }
    
    public void runGame()
    {
        Scanner scan = new Scanner(System.in);
        while(player.getHealth() > 0)
        {
            room = new Room();
            System.out.print("Would you like to move to the next room? (y/n): ");
            if("n".equalsIgnoreCase(scan.next()))
                break;
        }
        System.out.println("Good bye");
    }
}

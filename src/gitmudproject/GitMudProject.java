package gitmudproject;

public class GitMudProject
{

    public static void main(String[] args)
    {
        GameLogic game = new GameLogic();
        game.startGame(new Player());
        game.runGame();
    }

}

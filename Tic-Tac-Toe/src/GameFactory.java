import Entities.Game;
import Entities.Rules;

public class GameFactory {
     public static Game createGame(int boardSize, Rules rule) {
            return new Game(boardSize,rule);
        
    }

    public static void playGame(Game game) {
        game.playGame();
    }
}

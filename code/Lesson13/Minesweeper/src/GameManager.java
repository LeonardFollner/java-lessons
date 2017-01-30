import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Max on 23.01.17.
 */
public class GameManager {

    private ArrayList<Minesweeper> games;

    public GameManager() {
        games = new ArrayList<>();
        newGame(new Point(0,0));
    }

    public Minesweeper newGame(Point location) {
        Minesweeper game = new Minesweeper(this);
        game.initGame(location);
        games.add(game);

        return game;
    }

}

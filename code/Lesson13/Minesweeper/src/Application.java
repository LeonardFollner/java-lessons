import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alex on 15.01.17.
 */
public class Application {

	private static GameManager manager;

	public static void main(String[] args) {
		System.out.println("Welcome to Minesweeper for Java!");
		manager = new GameManager();
	}
}

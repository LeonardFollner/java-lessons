import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex on 07/12/2016.
 */
public class Controller {

	private UserManager userManager;
	private PostManager postManager;

	public Controller() {
		this.userManager = UserManager.getInstance();
		this.postManager = PostManager.getInstance();

		// Create menu bar and items..
		MenuBar bar = new MenuBar();
		Menu menu = new Menu("File");

		MenuItem item = new MenuItem("Create new User");
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userManager.addUser();
			}
		});

		menu.add(item);

		bar.add(menu);

		// Create the window
		createWindow1(bar);
//		createWindow2(bar);
	}

	public void createWindow1(MenuBar menuBar) {
		// Create a new window
		JFrame window = new JFrame();

		// Set its title and size
		window.setTitle("Buggy Guestbook");
		window.setSize(500, 500);

		JSplitPane splitPane = new JSplitPane();

		splitPane.setLeftComponent(userManager.getUserPanel());
		splitPane.setRightComponent(postManager.getPostPanel());

		splitPane.setDividerLocation(0.3);

		window.setMenuBar(menuBar);
		window.add(splitPane);

		// Set the window to be visible
		window.setVisible(true);
	}

	public void createWindow2(MenuBar menuBar) {
		// Create a new window
		JFrame window = new JFrame();

		// Set its title and size
		window.setTitle("Guestbook");
		window.setSize(500, 500);

		JPanel cardPanel = new JPanel();

		cardPanel.setLayout(new GridLayout(2,1));

		cardPanel.add(userManager.getUserBox());
		cardPanel.add(postManager.getPostPanel());

		window.setMenuBar(menuBar);
		window.add(cardPanel);

		// Set the window to be visible
		window.setVisible(true);
	}

}

import javafx.geometry.Pos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by alex on 07/12/2016.
 */
public class UserManager {


	/**
	 * Singleton
	 */
	private static UserManager userManager = new UserManager();

	private JList userList;
	private JComboBox userBox;

	private UserManager() {
	}

	public static UserManager getInstance() {
		return userManager;
	}

	private static HashMap<Integer, User> users = new HashMap<>();
	private static int currentId = 0;

	public void addUser() {
		String userName = null;

		while (userName == null) {
			userName = JOptionPane.showInputDialog("Please enter the username for the new user:");
		}

		User user = new User(userName);
		users.put(currentId, user);

		System.out.println("Added new user " + userName);

		if (userList != null) {
			userList.setListData(users.values().toArray());
		} else if (userBox != null) {
			userBox.addItem(userName);
		}
	}

	public User getUserById(Integer id) {
		return users.get(id);
	}

	public JPanel getUserPanel() {
		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(1, 1));

		this.userList = new JList();
		this.userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane (userList,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		panel.add(scrollPane);

		userList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				PostManager.getInstance().viewPostsByUser();
			}
		});

		panel.setMinimumSize(new Dimension(150, 50));

		return panel;
	}

	public JComboBox getUserBox() {
		this.userBox = new JComboBox();

		this.userBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PostManager.getInstance().viewPostsByUser();
			}
		});

		return this.userBox;
	}

	public int getSelectedUserID() {
		if (userList != null) {
			return userList.getSelectedIndex();
		} else if (userBox != null) {
			return userBox.getSelectedIndex();
		}

		return 0;
	}
}

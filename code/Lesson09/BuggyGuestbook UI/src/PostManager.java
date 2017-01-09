import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by alex on 07/12/2016.
 */
public class PostManager {


	/**
	 * Singleton
	 */
	private static PostManager postManager = new PostManager();

	private PostManager() {

	}

	public static PostManager getInstance() {
		return postManager;
	}

	/**
	 * HashMap with postId containing an HashMap with the userId and the text of the post.
	 */
	private static Map<Integer, Post> posts = new HashMap<>();
	private static Integer currentId = 0;


	public void addPost() {
		int userID = UserManager.getInstance().getSelectedUserID();

		if (userID == -1) { return; }

		String text = textField.getText();

		System.out.println(text);

		Post post = new Post(userID, text);
		posts.put(currentId, post);
		currentId++;

		viewPostsByUser();
	}

	public void viewPostsByUser() {
		UserManager userManager = UserManager.getInstance();

		int userID = userManager.getSelectedUserID();

		if (userID ==  -1) { return; }

		titleLabel.setText(userManager.getUserById(userID).toString() + "'s Posts:");

		textField.setText("");

		List<String> postsByUser = new ArrayList<>();
		posts.forEach((k,v) -> {
			if(v.getUserId() == userID) {
				postsByUser.add(v.getText());
			}
		});

		postList.setListData(postsByUser.toArray());
	}

	private JLabel titleLabel;
	private JList postList;
	private JTextField textField;

	public JPanel getPostPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));

		JPanel titlePanel = new JPanel();
		titlePanel.setMaximumSize(new Dimension(1000, 30));
		titlePanel.setLayout(new GridLayout(1, 1));
		titleLabel = new JLabel("");
		titlePanel.add(titleLabel);
		panel.add(titlePanel);

		JPanel postsPanel = new JPanel();
		postsPanel.setLayout(new GridLayout(1, 1));

		postList = new JList();

		JScrollPane scrollPane = new JScrollPane (postList,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		postsPanel.add(scrollPane);
		panel.add(postsPanel);

		JPanel textPanel = new JPanel();
		textPanel.setMaximumSize(new Dimension(1000, 30));
		textPanel.setLayout(new GridLayout(1, 2));

		textField = new JTextField();
		textPanel.add(textField);

		JButton postButton = new JButton("Post");

		postButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addPost();
			}
		});

		textPanel.add(postButton);
		panel.add(textPanel);

		return panel;
	}
}

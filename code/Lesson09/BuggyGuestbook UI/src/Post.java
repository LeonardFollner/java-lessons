/**
 * Created by alex on 07/12/2016.
 */
public class Post {

	private Integer userId;
	private String text;

	public Post(Integer userId, String text) {
		this.userId = userId;
		this.text = text;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getText() {
		return text;
	}
}

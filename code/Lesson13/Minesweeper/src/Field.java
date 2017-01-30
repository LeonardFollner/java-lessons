/**
 * Created by alex on 15/01/2017.
 */
public class Field {

	public enum Type {
		EMPTY,
		BOMB
	}

	public enum Status {
		COVERED,
		FLAGGED,
		OPENED
	}

	private Status status;
	private Type type;

	private int positionX;
	private int positionY;

	private int number;

	public Field(int positionX,int positionY) {
		this.status = Status.COVERED;
		this.type = Type.EMPTY;

		this.positionX = positionX;
		this.positionY = positionY;
		number = 0;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public Status getStatus() {
		return status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}
}

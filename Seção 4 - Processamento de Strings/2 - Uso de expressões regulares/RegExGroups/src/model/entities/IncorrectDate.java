package model.entities;

public class IncorrectDate extends RuntimeException {
	public IncorrectDate() {
	}

	public IncorrectDate(String message) {
		super(message);
	}
}

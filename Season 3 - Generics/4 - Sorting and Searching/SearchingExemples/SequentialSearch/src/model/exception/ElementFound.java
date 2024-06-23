package model.exception;

public class ElementFound extends RuntimeException {
	public ElementFound() {
	}

	public ElementFound(String message) {
		super(message);
	}
}

package model.exception;

public class ElementNotFound extends RuntimeException {
	public ElementNotFound() {
	}

	public ElementNotFound(String message) {
		super(message);
	}
}

package sg.edu.nus.team3.shoppingcart.exception;

public class InvalidLoginException extends RuntimeException {
	public InvalidLoginException() {
		super();
	}
	public InvalidLoginException(String message) {
		super(message);
	}


}

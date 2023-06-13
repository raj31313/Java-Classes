package newpack;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		System.out.println("From unfe constr");

	}

	@Override
	public String toString() {
		return "UserNotFoundException tostring";
	}

}

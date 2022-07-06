package projeto;

public class MinhaException extends IndexOutOfBoundsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public MinhaException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
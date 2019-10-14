package mastermind.views;

public enum MessageView {
	ATTEMPTS("#attempts attempt(s): "),
	RESUME("Do you want to continue"),
	RESULT(" --> #blacks blacks and #whites whites"),
	TITLE("----- MASTERMIND -----"),
	SECRET("*"),
	PROPOSED_COMBINATION("1) Propose a combination "),
	WINNER("You've won!!! ;-)"),
	LOOSER("You've lost!!! :-(");

	private String message;
	
	private MessageView(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}

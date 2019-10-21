package mastermind.views;

public enum MessageView {
	ATTEMPTS("#attempts attempt(s): "), RESUME("Do you want to continue"),
	RESULT(" --> #blacks blacks and #whites whites"), TITLE("----- MASTERMIND -----"), SECRET("*"),
	PROPOSEDCOMBINATION("Propose a combination "), WINNER("You've won!!! ;-)"), LOOSER("You've lost!!! :-("),
	NAME("Name: "), SAVE("Do you want to save the game?"), OPENGAMECOMMAND("Open a saved game"),NEWGAMECOMMAND("Start a new game"),EXITCOMMAND("Exit Game");

	private String message;

	private MessageView(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}

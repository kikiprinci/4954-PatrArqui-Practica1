package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.views.MessageView;
import mastermind.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {

	private PlayController playController;

	AttemptsView(PlayController proposalController) {
		this.playController = proposalController;
	}

	void writeln() {
		this.console.writeln(
				MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts", "" + this.playController.getAttempts()));
	}

}

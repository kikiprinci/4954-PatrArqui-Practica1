package mastermind.views.console;

import java.util.List;

import mastermind.controllers.PlayController;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.views.console.ErrorView;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ProposalView extends WithConsoleView {

	public void interact(PlayController playController) {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView(playController).read();
			error = playController.checkProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			} else
				playController.addProposedCombination(colors);
		} while (error != null);

		this.console.writeln();
		new AttemptsView(playController).writeln();
		new SecretCombinationView(playController).writeln();

		for (int i = 0; i < playController.getAttempts(); i++) {
			new ProposedCombinationView(playController).write(i);
			new ResultView(playController).writeln(i);
		}
		if (playController.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
		} else if (playController.isLooser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
		}
	}

}

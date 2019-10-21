package mastermind.views.console.menu;

import mastermind.controllers.StartController;
import mastermind.views.MessageView;

class OpenGameCommand extends Command{

	protected OpenGameCommand(StartController startController) {
		super(MessageView.OPENGAMECOMMAND.getMessage(), startController);
	}

	@Override
	protected void execute() {
		new GameSelectMenu((StartController) this.acceptorController).execute();
	}

	@Override
	public boolean isActive() {
		return true;
	}

}

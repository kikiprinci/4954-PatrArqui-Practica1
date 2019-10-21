package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.views.MessageView;

class ExitCommand extends Command {

	protected ExitCommand(PlayController playController) {
		super(MessageView.EXITCOMMAND.getMessage(), playController);
	}

	@Override
	public void execute() {
		((PlayController) this.acceptorController).next();	
	}

    	@Override
	public boolean isActive() {
		return true;
	}
}
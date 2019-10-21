package mastermind.views.console.menu;

import mastermind.controllers.StartController;
import mastermind.utils.Menu;

public class StartMenu extends Menu {

	public StartMenu(StartController startController) {
		this.addCommand(new OpenGameCommand(startController));
		this.addCommand(new NewGameCommand(startController));
	}
}

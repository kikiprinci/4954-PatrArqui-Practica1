package mastermind.views.console.menu;

import mastermind.controllers.StartController;
import mastermind.utils.Menu;

class GameSelectMenu extends Menu {

	GameSelectMenu(StartController startController) {
		String[] gamesNames = startController.getGamesNames();
		for (String title : gamesNames) {
			this.addCommand(new PlaySelectCommand(title, startController));
		}
	}

}
package mastermind;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.Logic;
import mastermind.views.View;
import mastermind.views.console.ConsoleView;

//public abstract class Mastermind {
public class Mastermind {

	private Logic logic;

	private View view;

	protected Mastermind() {
		this.logic = new Logic();
		this.view = new ConsoleView();
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

	protected void play() {
		AcceptorController acceptorController;
		do {
			acceptorController = this.logic.getController();
			if (acceptorController != null) {
				this.view.interact(acceptorController);
			}
		} while (acceptorController != null);
	}

}

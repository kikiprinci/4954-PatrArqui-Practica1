package mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import mastermind.models.Session;
import mastermind.models.StateValue;

public abstract class Logic {

	private Session session;

	private Map<StateValue, AcceptorController> acceptorController;

	protected Logic() {
		this.acceptorController = new HashMap<>();
	}

	public AcceptorController getController() {
		return this.controllers.get(this.session.getValueState());
	}

}

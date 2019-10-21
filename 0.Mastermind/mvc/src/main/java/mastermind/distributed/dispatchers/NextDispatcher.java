package mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;
import mastermind.controllers.implementation.PlayControllerImplementation;

public class NextDispatcher extends Dispatcher {

	public NextDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		((PlayController) this.acceptorController).next();
	}

}
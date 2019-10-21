package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class LooseDispatcher extends Dispatcher {

	public LooseDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayControllerImplementation)this.acceptorController).isLooser());
	}

}
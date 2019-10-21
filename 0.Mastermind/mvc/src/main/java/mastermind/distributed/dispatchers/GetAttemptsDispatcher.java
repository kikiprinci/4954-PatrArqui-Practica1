package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class GetAttemptsDispatcher extends Dispatcher {

	public GetAttemptsDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayControllerImplementation)this.acceptorController).getAttempts());
	}

}
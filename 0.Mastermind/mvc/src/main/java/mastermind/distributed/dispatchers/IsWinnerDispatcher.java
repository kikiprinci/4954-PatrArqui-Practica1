package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class IsWinnerDispatcher extends Dispatcher {

	public IsWinnerDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayControllerImplementation)this.acceptorController).isWinner());
	}

}
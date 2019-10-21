package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class GetWidthDispatcher extends Dispatcher {

    public GetWidthDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayControllerImplementation)this.acceptorController).getWidth());
    }
}
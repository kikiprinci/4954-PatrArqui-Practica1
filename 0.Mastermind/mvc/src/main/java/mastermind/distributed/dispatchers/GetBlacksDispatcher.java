
package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class GetBlacksDispatcher extends Dispatcher {

    public GetBlacksDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        int position = this.tcpip.receiveInt();
        ((PlayControllerImplementation) this.acceptorController).getBlacks(position);
    }

}
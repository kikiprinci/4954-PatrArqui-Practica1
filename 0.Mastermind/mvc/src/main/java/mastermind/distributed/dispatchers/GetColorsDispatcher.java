
package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class GetColorsDispatcher extends Dispatcher {

    public GetColorsDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        int position = this.tcpip.receiveInt();
        ((PlayControllerImplementation) this.acceptorController).getColors(position);
    }

}

package mastermind.distributed.dispatchers;

import java.util.List;

import mastermind.controllers.implementation.PlayControllerImplementation;
import mastermind.types.Color;

public class AddProposedCombinationDispatcher extends Dispatcher {

    public AddProposedCombinationDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        List<Color> proposedCombination = this.tcpip.receiveColors();
        ((PlayControllerImplementation) this.acceptorController).addProposedCombination(proposedCombination);
    }
}

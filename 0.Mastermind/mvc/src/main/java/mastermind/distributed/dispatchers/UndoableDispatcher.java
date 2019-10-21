package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class UndoableDispatcher extends Dispatcher {

    public UndoableDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        ((PlayControllerImplementation) this.acceptorController).undoable();
    }

}
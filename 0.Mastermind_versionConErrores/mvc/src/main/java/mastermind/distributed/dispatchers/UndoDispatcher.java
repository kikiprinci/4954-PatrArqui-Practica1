package main.java.mastermind.distributed.dispatchers;

import mastermind.controllers.PlayController;
import mastermind.controllers.implementation.PlayControllerImplementation;

public class UndoDispatcher extends Dispatcher {

    public UndoDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        ((PlayControllerImplementation) this.acceptorController).undo();
    }

}
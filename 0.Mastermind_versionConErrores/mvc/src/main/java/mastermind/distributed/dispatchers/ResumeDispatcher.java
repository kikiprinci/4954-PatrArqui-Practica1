package main.java.mastermind.distributed.dispatchers;

import mastermind.controllers.ResumeController;
import mastermind.controllers.implementation.ResumeControllerImplementation;

public class ResumeDispatcher extends Dispatcher {

    public ResumeDispatcher(ResumeControllerImplementation resumeControllerImplementation) {
        super(resumeControllerImplementation);
    }

    @Override
    public void dispatch() {
        boolean newGame = this.tcpip.receiveBoolean();
        ((ResumeControllerImplementation) this.acceptorController).resume(newGame);
    }

}
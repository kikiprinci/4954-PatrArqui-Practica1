package mastermind.controllers.implementation;

import mastermind.controllers.StartController;
import mastermind.models.Session;

public class StartControllerImplementation extends StartController {

    public StartControllerImplementation(Session session) {
        super(session);
    }

    @Override
    public void start() {
        this.session.next();
    }

}
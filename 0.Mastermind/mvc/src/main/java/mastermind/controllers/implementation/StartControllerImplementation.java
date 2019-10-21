package mastermind.controllers.implementation;

import mastermind.controllers.StartController;
import mastermind.models.Session;
import mastermind.models.DAO.SessionDAOImplementation;

public class StartControllerImplementation extends StartController {

    private SessionDAOImplementation sessionDAOImplementation;

    public StartControllerImplementation(Session session, SessionDAOImplementation sessionDAOImplementation) {
        super(session);
        this.sessionDAOImplementation = sessionDAOImplementation;
    }

    @Override
    public void start() {
        this.session.next();
    }

    @Override
    public void start(String title) {
        this.sessionDAOImplementation.load(title);
    }

    @Override
    public String[] getGamesNames() {
        return this.sessionDAOImplementation.getGamesNames();
    }
}
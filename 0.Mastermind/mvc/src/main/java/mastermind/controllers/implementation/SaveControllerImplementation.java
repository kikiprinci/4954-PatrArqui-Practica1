package mastermind.controllers.implementation;

import mastermind.controllers.SaveController;
import mastermind.models.Session;
import mastermind.models.DAO.SessionDAOImplementation;

public class SaveControllerImplementation extends SaveController {

    private final SessionDAOImplementation sessionDAOImplementation;
    
    public SaveControllerImplementation(Session session, SessionDAOImplementation sessionDAOImplementation) {
        super(session);
        this.sessionDAOImplementation = sessionDAOImplementation;
    }
    
    @Override
    public void save(String name) {
        this.sessionDAOImplementation.save(name);
    }

    @Override
    public void save() {
        this.sessionDAOImplementation.save();
    }

    @Override
    public void next() {
        this.session.next();
    }

    @Override
    public boolean hasName() {
        return this.session.getName() != null;
    }

    @Override
    public boolean exists(String name) {
        return this.sessionDAOImplementation.exists(name);
    }
}
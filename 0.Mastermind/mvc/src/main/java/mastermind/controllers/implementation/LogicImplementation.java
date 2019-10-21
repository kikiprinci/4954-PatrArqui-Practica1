package mastermind.controllers.implementation;

import mastermind.controllers.Logic;
import mastermind.models.SessionImplementantion;
import mastermind.models.StateValue;
import mastermind.models.DAO.SessionDAOImplementation;

public class LogicImplementation extends Logic {

    protected StartControllerImplementation startControllerImplementation;
    protected PlayControllerImplementation playControllerImplementation;
    protected ResumeControllerImplementation resumeControllerImplementation;
    protected SaveControllerImplementation saveControllerImplementation;
    protected SessionDAOImplementation sessionDAOImplementation;

    public LogicImplementation() {
        this.session = new SessionImplementantion();
        this.sessionDAOImplementation = new SessionDAOImplementation();
        
        this.sessionDAOImplementation.associate((SessionImplementantion) this.session);
        this.startControllerImplementation = new StartControllerImplementation(this.session,
                this.sessionDAOImplementation);
        this.playControllerImplementation = new PlayControllerImplementation(this.session);
        this.resumeControllerImplementation = new ResumeControllerImplementation(this.session);
        this.saveControllerImplementation = new SaveControllerImplementation(this.session,
                this.sessionDAOImplementation);

        this.controllers.put(StateValue.INITIAL, this.startControllerImplementation);
        this.controllers.put(StateValue.IN_GAME, this.playControllerImplementation);
        this.controllers.put(StateValue.SAVING, this.saveControllerImplementation);
        this.controllers.put(StateValue.FINAL, this.resumeControllerImplementation);
        this.controllers.put(StateValue.EXIT, null);
    }
}
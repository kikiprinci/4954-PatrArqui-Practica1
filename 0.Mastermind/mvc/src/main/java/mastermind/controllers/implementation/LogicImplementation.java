package mastermind.controllers.implementation;

import mastermind.controllers.Logic;
import mastermind.models.SessionImplementantion;
import mastermind.models.StateValue;

public class LogicImplementation extends Logic {

    private StartControllerImplementation startControllerImplementation;
    private PlayControllerImplementation playControllerImplementation;
    private ResumeControllerImplementation resumeControllerImplementation;

    public LogicImplementation() {
        this.session = new SessionImplementation();
        this.startControllerImplementation = new StartControllerImplementation(this.session);
        this.playControllerImplementation = new PlayControllerImplementation(this.session);
        this.resumeControllerImplementation = new ResumeControllerImplementation(this.session);
        
        this.controllers.put(StateValue.INITIAL, this.startControllerImplementation);
        this.controllers.put(StateValue.IN_GAME, this.playControllerImplementation);
        this.controllers.put(StateValue.FINAL, this.resumeControllerImplementation);
        this.controllers.put(StateValue.EXIT, null);
    }
}
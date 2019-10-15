package mastermind.controllers;

import mastermind.models.Session;

public abstract class RedoController extends Controller {

    RedoController(Session session) {
        super(session);
    }

    public abstract void redo() ;

    public abstract boolean redoable() ;

}
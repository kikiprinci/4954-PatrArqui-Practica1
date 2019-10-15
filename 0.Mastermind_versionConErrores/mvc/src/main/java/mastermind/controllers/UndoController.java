package mastermind.controllers;

import mastermind.models.Session;

public abstract class UndoController extends Controller {

    UndoController(Session session) {
        super(session);
    }

    public abstract void undo();

    public abstract boolean undoable();

}
package mastermind.controllers;

import java.util.List;

import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

public abstract class PlayController extends AcceptorController {

    public PlayController(Session session) {
        super(session);
    }

    public abstract void addProposedCombination(List<Color> colors);

    public abstract Error checkProposedCombination(List<Color> colors);

    public abstract void undo();

    public abstract void redo();

    public abstract boolean undoable();

    public abstract boolean redoable();

    public abstract boolean isWinner();

    public abstract boolean isLooser();

    public abstract int getAttempts();

    public abstract void resume();

    public abstract List<Color> getColors(int position);

    public abstract int getBlacks(int position);

    public abstract int getWhites(int position);

    public abstract void next();

    @Override
    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
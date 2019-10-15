package mastermind.controllers.implementation;

import mastermind.controllers.PlayController;
import mastermind.controllers.RedoController;
import mastermind.controllers.UndoController;
import mastermind.models.Error;
import mastermind.models.Session;
import mastermind.models.Suit;

public class PlayControllerImplementation extends PlayController {

    private UndoController undoController;

    private RedoController redoController;

    PlayControllerImplementation(Session session) {
        super(session);
        this.undoController = new UndoController(this.session);
        this.redoController = new RedoController(this.session);
    }

    @Override
    public Error addProposedCombination(List<Color> colors) {
        Error error = null;
        if (colors.size() != Combination.getWidth()) {
            error = Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < colors.size(); i++) {
                if (colors.get(i) == null) {
                    error = Error.WRONG_CHARACTERS;
                } else {
                    for (int j = i + 1; j < colors.size(); j++) {
                        if (colors.get(i) == colors.get(j)) {
                            error = Error.DUPLICATED;
                        }
                    }
                }
            }
        }
        if (error == null) {
            this.session.addProposedCombination(colors);
            if (this.session.isWinner() || this.session.isLooser()) {
                this.session.next();
            }
        }
        return error;
    }

    @Override
    public void undo() {
        this.undoController.undo();
    }

    @Override
    public void redo() {
        this.redoController.redo();
    }

    @Override
    public boolean undoable() {
        return this.undoController.undoable();
    }

    @Override
    public boolean redoable() {
        return this.redoController.redoable();
    }

    @Override
    public boolean isWinner() {
        return this.session.isWinner();
    }

    @Override
    public boolean isLooser() {
        return this.session.isLooser();
    }

    @Override
    public int getAttempts() {
        return this.session.getAttempts();
    }

    @Override
    public List<Color> getColors(int position) {
        return this.session.getColors(position);
    }

    @Override
    public int getBlacks(int position) {
        return this.session.getBlacks(position);
    }

    @Override
    public int getWhites(int position) {
        return this.session.getWhites(position);
    }

}
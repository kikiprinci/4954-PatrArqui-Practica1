package mastermind.controllers.implementation;

import java.util.List;

import mastermind.controllers.ExitController;
import mastermind.controllers.GameController;
import mastermind.controllers.PlayController;
import mastermind.controllers.RedoController;
import mastermind.controllers.UndoController;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

public class PlayControllerImplementation extends PlayController {

    private UndoController undoController;
    private RedoController redoController;
    private GameController gameController;
    private ExitController exitController;

    public PlayControllerImplementation(Session session) {
        super(session);
        this.undoController = new UndoController(this.session);
        this.redoController = new RedoController(this.session);
        this.gameController = new GameController(this.session);
        this.exitController = new ExitController(this.session);
    }

    @Override
    public void addProposedCombination(List<Color> colors) {
        this.gameController.addProposedCombination(colors);
    }

    @Override
    public Error checkProposedCombination(List<Color> colors) {
        return this.gameController.checkProposedCombination(colors);
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
        return this.gameController.isWinner();
    }

    @Override
    public boolean isLooser() {
        return this.gameController.isLooser();
    }

    @Override
    public int getAttempts() {
        return this.gameController.getAttempts();
    }

    @Override
    public List<Color> getColors(int position) {
        return this.gameController.getColors(position);
    }

    @Override
    public int getBlacks(int position) {
        return this.gameController.getBlacks(position);
    }

    @Override
    public int getWhites(int position) {
        return this.gameController.getWhites(position);
    }

    @Override
    public void next() {
        this.exitController.next();
    }

    @Override
    public void resume() {
        this.gameController.resume();
    }
}
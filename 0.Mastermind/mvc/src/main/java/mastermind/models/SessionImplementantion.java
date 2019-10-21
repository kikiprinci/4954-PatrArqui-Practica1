package mastermind.models;

import java.util.List;

import mastermind.types.Color;

public class SessionImplementantion implements Session {

    private Game game;

    private State state;

    private Registry registry;

    private String name;

    public SessionImplementantion() {
        this.game = new Game();
        this.state = new State();
        this.registry = new Registry(this.game);
    }

    @Override
    public void resume() {
        this.game.clear();
        this.state.reset();
        this.registry.reset();
    }

    @Override
    public void next() {
        this.state.next();
    }

    @Override
    public StateValue getValueState() {
        return this.state.getValueState();
    }

    @Override
    public int getWidth() {
        return this.game.getWidth();
    }

    @Override
    public void addProposedCombination(List<Color> colors) {
        this.game.addProposedCombination(colors);

        if (this.game.isWinner() || this.game.isLooser()) {
            this.next();
        }

        this.registry.registry();

    }

    @Override
    public boolean isLooser() {
        return this.game.isLooser();
    }

    @Override
    public boolean isWinner() {
        return this.game.isWinner();
    }

    @Override
    public int getAttempts() {
        return this.game.getAttempts();
    }

    @Override
    public List<Color> getColors(int position) {
        return this.game.getColors(position);
    }

    public int getBlacks(int position) {
        return this.game.getBlacks(position);
    }

    @Override
    public int getWhites(int position) {
        return this.game.getWhites(position);
    }

    @Override
    public boolean undoable() {
        return this.registry.undoable();
    }

    @Override
    public boolean redoable() {
        return this.registry.redoable();
    }

    @Override
    public void undo() {
        this.registry.undo(this.game);
    }

    @Override
    public void redo() {
        this.registry.redo(this.game);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return this.game;
    }

    public void resetRegistry() {
        this.registry.reset();
    }

    public void setStateValue(StateValue stateValue) {
        this.state.setStateValue(stateValue);
    }
}
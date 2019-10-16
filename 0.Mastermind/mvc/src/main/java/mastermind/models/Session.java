package mastermind.models;

import java.util.List;

import mastermind.types.Color;

public interface Session {

    void next();

    StateValue getValueState();

    int getWidth();

    void addProposedCombination(List<Color> colors);

    boolean isLooser();

    boolean isWinner();

    int getAttempts();

    List<Color> getColors(int position);

    int getBlacks(int position);

    int getWhites(int position);

    boolean undoable();

    boolean redoable();

    void undo();

    void redo();

    void resume();
}
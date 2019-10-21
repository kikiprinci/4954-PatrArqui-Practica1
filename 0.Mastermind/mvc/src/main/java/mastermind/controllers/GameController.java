package mastermind.controllers;

import java.util.List;

import mastermind.models.Combination;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

public class GameController extends Controller {
    public GameController(Session session) {
        super(session);
    }

    public void addProposedCombination(List<Color> colors) {
        this.session.addProposedCombination(colors);
    }

    public Error checkProposedCombination(List<Color> colors) {
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
        return error;
    }

    public boolean isWinner() {
        return this.session.isWinner();
    }

    public boolean isLooser() {
        return this.session.isLooser();
    }

    public int getAttempts() {
        return this.session.getAttempts();
    }

    public List<Color> getColors(int position) {
        return this.session.getColors(position);
    }

    public int getBlacks(int position) {
        return this.session.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.session.getWhites(position);
    }

    public void resume() {
        this.session.resume();
    }

}
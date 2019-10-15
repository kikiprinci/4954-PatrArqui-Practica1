package mastermind.models;

import java.util.ArrayList;

public class Registry {

    private Game game;

    private int undoCount;

    private ArrayList<Memento> mementoList;

    public Registry(Game game) {
        this.game = game;
        this.undoCount = 0;
        this.mementoList = new ArrayList<>();
        this.mementoList.add(undoCount, this.game.createMemento());
    }

    public void registry() {
        for (int i = 0; i < this.undoCount; i++) {
            this.mementoList.remove(0);
        }
        this.undoCount = 0;
        this.mementoList.add(this.undoCount, this.game.createMemento());
    }

    public void undo(Game game) {
        this.undoCount++;
        game.restore(this.mementoList.get(this.undoCount));
    }

    public void redo(Game game) {
        this.undoCount--;
        game.restore(this.mementoList.get(this.undoCount));
    }

    public boolean undoable() {
        return this.undoCount < this.mementoList.size() - 1;
    }

    public boolean redoable() {
        return this.undoCount >= 1;
    }

    public void reset() {
        this.mementoList = new ArrayList<Memento>();
        this.mementoList.add(undoCount, this.game.createMemento());
        this.undoCount = 0;
    }
}
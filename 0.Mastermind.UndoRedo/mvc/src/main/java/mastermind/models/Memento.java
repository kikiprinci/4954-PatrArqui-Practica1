package mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class Memento {

    private List<ProposedCombination> proposedCombinations;

    private List<Result> results;

    public Memento() {
        this.proposedCombinations = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    public void addResultCombination(Result result) {
        this.results.add(result);
    }

    public Result getResultCombination(int index) {
        return this.results.get(index);
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposedCombinations.add(proposedCombination);
    }

    public ProposedCombination getProposedCombination(int index) {
        return this.proposedCombinations.get(index);
    }
}
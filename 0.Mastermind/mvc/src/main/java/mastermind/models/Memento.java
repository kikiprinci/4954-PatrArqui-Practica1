package mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class Memento {

    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;
    private SecretCombination secretCombination;
    private int attempts;

    public Memento(SecretCombination secretCombination, int attempts) {
        this.proposedCombinations = new ArrayList<>();
        this.results = new ArrayList<>();
        this.attempts = attempts;
        this.secretCombination = secretCombination;
    }

    public void addResultCombination(Result result) {
        this.results.add(result);
    }

    public Result getResultCombination(int index) {
        return this.results.get(index);
    }

    public SecretCombination getSecretCombination() {
        return this.secretCombination;
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposedCombinations.add(proposedCombination);
    }

    public ProposedCombination getProposedCombination(int index) {
        return this.proposedCombinations.get(index);
    }

    public int getAttempts() {
        return this.attempts;
    }
}
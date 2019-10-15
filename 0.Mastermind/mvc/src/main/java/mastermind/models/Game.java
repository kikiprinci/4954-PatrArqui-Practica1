package mastermind.models;

import java.util.*;

import mastermind.types.Color;

public class Game {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

	public Game() {
		this.clear();
	}

	public void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.attempts = 0;
	}

	public void addProposedCombination(List<Color> colors) {
		ProposedCombination proposedCombination = new ProposedCombination(colors);
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.attempts++;
	}

	public boolean isLooser() {
		return this.attempts == Game.MAX_LONG;
	}

	public boolean isWinner() {
		return this.results.get(this.attempts - 1).isWinner();
	}

	public int getAttempts() {
		return this.attempts;
	}

	public SecretCombination getSecretCombination() {
		return this.secretCombination;
	}

	public List<Color> getColors(int position) {
		return this.proposedCombinations.get(position).colors;
	}

	public int getBlacks(int position) {
		return this.results.get(position).getBlacks();
	}

	public int getWhites(int position) {
		return this.results.get(position).getWhites();
	}

	public int getWidth() {
		return Combination.getWidth();
	}

	public Memento createMemento() {
		Memento memento = new Memento(this.secretCombination, this.attempts);

		for (ProposedCombination proposedCombination : this.proposedCombinations)
			memento.addProposedCombination(proposedCombination.copy());

		for (Result result : this.results)
			memento.addResultCombination(result.copy());

		return memento;
	}

	public void restore(Memento memento) {
		this.attempts = memento.getAttempts();
		this.secretCombination = memento.getSecretCombination();
		this.results = new ArrayList<>();
		this.proposedCombinations = new ArrayList<>();
		for (int i = 0; i < this.attempts; i++) {
			memento.addProposedCombination(this.proposedCombinations.get(i).copy());
			memento.addResultCombination(this.results.get(i).copy());
		}
	}

}

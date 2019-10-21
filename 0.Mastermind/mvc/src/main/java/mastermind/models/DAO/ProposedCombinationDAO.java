package mastermind.models.DAO;

import mastermind.models.ProposedCombination;

public class ProposedCombinationDAO extends CombinationDAO {

	public ProposedCombinationDAO(ProposedCombination proposedCombination) {
		super(proposedCombination);
	}

	ProposedCombination getProposedCombination() {
		return (ProposedCombination) this.combination;
	}

}

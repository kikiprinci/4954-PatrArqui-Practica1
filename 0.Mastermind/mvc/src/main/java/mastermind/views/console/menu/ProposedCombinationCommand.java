package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.views.console.*;

public class ProposedCombinationCommand extends Command {

    public ProposedCombinationCommand(PlayController playController) {
        super(CommandTitle.PROPOSED_COMBINATION.getTitle(), playController);
    }

    @Override
    protected void execute() {
        new ProposalView().interact((PlayController) this.playController);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
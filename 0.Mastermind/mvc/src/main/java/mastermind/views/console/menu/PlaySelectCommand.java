package mastermind.views.console.menu;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.StartController;
import mastermind.utils.Console;

public class PlaySelectCommand extends Command {

    protected PlaySelectCommand(String title, AcceptorController acceptorController) {
        super(title, acceptorController);
    }

    @Override
    protected void execute() {
        new Console().writeln(this.title);
        ((StartController) this.acceptorController).start(this.title);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
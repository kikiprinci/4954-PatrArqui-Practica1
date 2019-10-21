package mastermind;

import mastermind.controllers.Logic;
import mastermind.distributed.LogicProxy;
import mastermind.views.View;
import mastermind.views.console.ConsoleView;

public class MastermindClient extends Mastermind {

    private LogicProxy logicProxy;

    public static void main(String[] args) {
        new MastermindClient().play();
    }

    @Override
    protected Logic createLogic() {
        this.logicProxy = new LogicProxy();
        return this.logicProxy;
    }

    @Override
    protected View createView() {
        return new ConsoleView();
    }

    @Override
    protected void play() {
        super.play();
        this.logicProxy.close();
    }

}
package mastermind.distributed;

import mastermind.controllers.Logic;
import mastermind.distributed.dispatchers.TCPIP;
import mastermind.models.StateValue;

public class LogicProxy extends Logic {
    private TCPIP tcpip;

    public LogicProxy() {
        this.tcpip = TCPIP.createClientSocket();
        this.session = new SessionProxy(this.tcpip);

        this.controllers.put(StateValue.INITIAL, new StartControllerProxy(this.session, this.tcpip));
        this.controllers.put(StateValue.IN_GAME, new PlayControllerProxy(this.session, this.tcpip));
        this.controllers.put(StateValue.FINAL, new ResumeControllerProxy(this.session, this.tcpip));
        this.controllers.put(StateValue.EXIT, null);
    }

    public void close() {
        this.tcpip.close();
    }
}
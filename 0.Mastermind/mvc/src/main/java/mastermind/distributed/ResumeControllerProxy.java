package mastermind.distributed;

import mastermind.controllers.ResumeController;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.TCPIP;
import mastermind.models.Session;

public class ResumeControllerProxy extends ResumeController {

    private TCPIP tcpip;

    public ResumeControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void resume(boolean newGame) {
        this.tcpip.send(FrameType.NEWGAME.name());
        this.tcpip.send(newGame);
    }

}
package main.java.mastermind.distributed;

import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.TCPIP;
import mastermind.models.Card;
import mastermind.models.Session;
import mastermind.models.StateValue;
import mastermind.models.Suit;

import java.util.Stack;

public class SessionProxy implements Session {

    private final TCPIP tcpip;

    public SessionProxy(TCPIP tcpip) {
        this.tcpip = tcpip;
    }

    @Override
    public boolean isGameFinished() {
        this.tcpip.send(FrameType.ISGAMEFINISHED.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public StateValue getValueState() {
        this.tcpip.send(FrameType.STATE.name());
        return StateValue.values()[this.tcpip.receiveInt()];
    }
}
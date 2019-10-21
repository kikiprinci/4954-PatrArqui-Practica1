package mastermind.distributed;

import java.util.List;

import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.TCPIP;
import mastermind.models.Session;
import mastermind.models.StateValue;
import mastermind.types.Color;

public class SessionProxy implements Session {

    private final TCPIP tcpip;

    public SessionProxy(TCPIP tcpip) {
        this.tcpip = tcpip;
    }

     @Override
    public void undo() {
        this.tcpip.send(FrameType.UNDO.name());
    }

    @Override
    public void redo() {
        this.tcpip.send(FrameType.REDO.name());
    }

    @Override
    public boolean undoable() {
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean redoable() {
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public void resume() {
        this.tcpip.send(FrameType.NEWGAME.name());
    }

    @Override
    public void next() {
        this.tcpip.send(FrameType.NEXT.name());
    }

    @Override
    public StateValue getValueState() {
        this.tcpip.send(FrameType.STATE.name());
        return StateValue.values()[this.tcpip.receiveInt()];
    }

    @Override
    public int getWidth() {
        this.tcpip.send(FrameType.GETCOMBINATIONLENGTH.name());
        return this.tcpip.receiveInt();
    }

    @Override
    public void addProposedCombination(List<Color> colors) {
        this.tcpip.send(FrameType.ADDPROPOSECOMBINATION.name());
    }

    @Override
    public boolean isLooser() {
        this.tcpip.send(FrameType.ISLOOSER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean isWinner() {
        this.tcpip.send(FrameType.ISWINNER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public int getAttempts() {
         this.tcpip.send(FrameType.GETATTEMPTS.name());
        return this.tcpip.receiveInt();
    }

    @Override
    public List<Color> getColors(int position) {
        this.tcpip.send(FrameType.GETCOLORS.name());
        this.tcpip.send(position);
        return this.tcpip.receiveColors();
    }

    @Override
    public int getBlacks(int position) {
         this.tcpip.send(FrameType.GETBLACKS.name());
        return this.tcpip.receiveInt();
    }

    @Override
    public int getWhites(int position) {
         this.tcpip.send(FrameType.GETWHITES.name());
        return this.tcpip.receiveInt();
    }

    @Override
    public String getName() {
         this.tcpip.send(FrameType.GETNAME.name());
        return this.tcpip.receiveLine();
    }
}
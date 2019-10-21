package mastermind.distributed;

import mastermind.controllers.implementation.LogicImplementation;
import mastermind.distributed.dispatchers.AddProposedCombinationDispatcher;
import mastermind.distributed.dispatchers.DispatcherPrototype;
import mastermind.distributed.dispatchers.ExistsDispatcher;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.GetAttemptsDispatcher;
import mastermind.distributed.dispatchers.GetBlacksDispatcher;
import mastermind.distributed.dispatchers.GetColorsDispatcher;
import mastermind.distributed.dispatchers.GetWhitesDispatcher;
import mastermind.distributed.dispatchers.GetWidthDispatcher;
import mastermind.distributed.dispatchers.HasNameDispatcher;
import mastermind.distributed.dispatchers.IsLooserDispatcher;
import mastermind.distributed.dispatchers.IsWinnerDispatcher;
import mastermind.distributed.dispatchers.NextDispatcher;
import mastermind.distributed.dispatchers.RedoDispatcher;
import mastermind.distributed.dispatchers.RedoableDispatcher;
import mastermind.distributed.dispatchers.ResumeDispatcher;
import mastermind.distributed.dispatchers.SaveDispatcher;
import mastermind.distributed.dispatchers.StartDispatcher;
import mastermind.distributed.dispatchers.StateDispatcher;
import mastermind.distributed.dispatchers.StartNameDispatcher;
import mastermind.distributed.dispatchers.UndoDispatcher;
import mastermind.distributed.dispatchers.UndoableDispatcher;

public class LogicImplementationServer extends LogicImplementation {

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.STARTNAME, new StartNameDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.ISWINNER, new IsWinnerDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.ISLOOSER, new IsLooserDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GETATTEMPTS, new GetAttemptsDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GETCOLORS, new GetColorsDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.ADDPROPOSECOMBINATION,new AddProposedCombinationDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GETWIDTH, new GetWidthDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GETBLACKS, new GetBlacksDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GETWHITES, new GetWhitesDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.NEWGAME, new ResumeDispatcher(this.resumeControllerImplementation));
        dispatcherPrototype.add(FrameType.SAVE, new SaveDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.HASNAME, new HasNameDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.EXISTS, new ExistsDispatcher(this.saveControllerImplementation));

    }
}
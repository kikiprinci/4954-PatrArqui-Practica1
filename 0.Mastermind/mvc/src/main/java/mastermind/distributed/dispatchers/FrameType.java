package mastermind.distributed.dispatchers;

public enum FrameType {
    START,
    STARTNAME,
    STATE,
    UNDO,
    REDO,
    UNDOABLE,
    REDOABLE,
    NEXT,
    GETCOMBINATIONLENGTH,
    CHECKPROPOSECOMBINATION,
    ADDPROPOSECOMBINATION,
    GETATTEMPTS,
    GETBLACKS,
    GETWHITES,
    GETCOLORS,
    GETWIDTH,    
    ISWINNER,
    ISLOOSER,
    NEWGAME,
    CLOSE,
    TITLES,
    SAVE,
    HASNAME,
    EXISTS,
    GETNAME;

    public static FrameType parser(String string) {
        for (FrameType frameType : FrameType.values()) {
            if (frameType.name().equals(string)) {
                return frameType;
            }
        }
        return null;
    }
}
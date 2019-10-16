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
    ISWINNER,
    ISLOOSER,
    GETSAVEDGAMES,
    NEWGAME,
    CLOSE,
    SAVE,
    SAVENAMED,
    HASNAME,
    EXISTS,
    SETTITLE,
    GETTITLE;

    public static FrameType parser(String string) {
        for (FrameType frameType : FrameType.values()) {
            if (frameType.name().equals(string)) {
                return frameType;
            }
        }
        return null;
    }
}
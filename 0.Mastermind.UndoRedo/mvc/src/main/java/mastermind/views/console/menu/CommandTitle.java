package mastermind.views.console.menu;

public enum CommandTitle {

	SECRET("*"),
	PROPOSED_COMBINATION("1) Propose a combination "),
	TITLE("----- MASTERMIND -----"),
	CHOOSE_OPTION("----- Choose one option ----"),
    UNDO_COMMAND("2) Undo previous Proposal"), 
    REDO_COMMAND("3) Redo previous Proposal");

    private String title;

    CommandTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

}
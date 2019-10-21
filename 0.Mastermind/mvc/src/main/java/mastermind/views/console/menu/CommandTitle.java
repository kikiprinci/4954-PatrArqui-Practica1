package mastermind.views.console.menu;

public enum CommandTitle {

	SECRET("*"),
	PROPOSED_COMBINATION("Propose a combination "),
	TITLE("----- MASTERMIND -----"),
	CHOOSE_OPTION("----- Choose one option ----"),
    UNDO_COMMAND("Undo previous Proposal"), 
    REDO_COMMAND("Redo previous Proposal");

    private String title;

    CommandTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

}
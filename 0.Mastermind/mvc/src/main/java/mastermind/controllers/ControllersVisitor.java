package mastermind.controllers;

public interface ControllersVisitor {

	void visit(StartController startController);

	void visit(ResumeController continueController);

	void visit(PlayController playController);
}

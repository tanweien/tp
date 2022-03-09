package seedu.address.logic.commands;

public interface CommandManageable {
    void insertCommand();
    void refreshFutureCommands(int undoRedoPointer);
    void undo();
    void redo();
}

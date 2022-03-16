package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class UndoCommand extends Command {
    public static final String COMMAND_WORD = "undo";

    public UndoCommand() {

    }

    public CommandResult execute(Model model) throws CommandException {
        return new CommandResult("Undid command", false, false);
    }

    //not used
    @Override
    public CommandResult unExecute(Model model) throws CommandException {
        return null;
    }

    @Override
    public boolean isUndo() {
        return true;
    }
}

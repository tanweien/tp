package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelMemento;

public class UndoCommand extends Command {
    private Model currentModel;
    private ModelMemento modelMemento;

    public static final String COMMAND_WORD = "undo";

    public UndoCommand() {

    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return null;
    }

    @Override
    public CommandResult unExecute(Model model) throws CommandException {
        return null;
    }
}

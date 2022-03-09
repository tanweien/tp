package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelMemento;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {
    private Model currentModel;
    private ModelMemento modelMemento;


    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_HELP_MESSAGE = "Opened help window.";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, true, false);
    }

    @Override
    public CommandResult unExecute(Model model) throws CommandException {
        return null;
    }
}

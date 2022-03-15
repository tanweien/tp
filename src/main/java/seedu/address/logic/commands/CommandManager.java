package seedu.address.logic.commands;
import java.util.Stack;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class CommandManager implements CommandManageable {
    private int commandStackPointer = -1;
    private final Stack<Command> commandStack = new Stack<>();
    private final Model model;

    public CommandManager(Model modelManager) {
        this.model = modelManager;
    }

    public int getCommandStackPointer() {
        return commandStackPointer;
    }

    public Stack<Command> getCommandStack() {
        return commandStack;
    }

    public Model getModel() {
        return model;
    }

    @Override
    public CommandResult insertCommand(Command currentCommand) throws CommandException {
        CommandResult toReturn;
        try {
            if (currentCommand.isUndo()) {
                String undidMessage = undo().getFeedbackToUser();
                return new CommandResult("Undid command: " + undidMessage, false, false);
            }
            //if redo
            if (currentCommand.isRedo()) {
                String redidMessage = redo().getFeedbackToUser();
                return new CommandResult("Redid command: " + redidMessage, false, false);
            }
        } catch (Exception err) {
            //handle error
        }
        //if undo

        // else
        refreshFutureCommands(commandStackPointer);
        commandStack.push(currentCommand);
        toReturn = currentCommand.execute(model);
        commandStackPointer++;
        return toReturn;
    }

    @Override
    public void refreshFutureCommands(int undoRedoPointer) {
        if (commandStack.size() < 1) {
            return;
        }
        if (commandStack.size() > undoRedoPointer + 1) {
            commandStack.subList(undoRedoPointer + 1, commandStack.size()).clear();
        }
    }

    @Override
    public CommandResult undo() throws CommandException {
        Command command = commandStack.get(commandStackPointer);
        commandStackPointer--;
        return command.unExecute(model);
    }

    @Override
    public CommandResult redo() throws CommandException {
        if (commandStackPointer == commandStack.size() - 1) {
            //i.e no future commands to execute
            return new CommandResult("There are no commands to redo!", true, false);
        }
        commandStackPointer++;
        Command command = commandStack.get(commandStackPointer);
        return command.execute(model);
    }
}

package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;

import java.util.Stack;

public class CommandManager implements CommandManageable {
    private int commandStackPointer = -1;
    private final Stack<Command> commandStack = new Stack<>();
    private final Model model;

    public CommandManager(Model modelManager) {
        this.model = modelManager;
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
                return new CommandResult("Undid command: " + redidMessage, false, false);
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
        if(commandStack.size()<1) {
            return;
        }
        for(int i = commandStack.size()-1; i > undoRedoPointer; i--) {
            commandStack.remove(i);
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
        if(commandStackPointer == commandStack.size() - 1) {
            //i.e no future commands to execute
            return new CommandResult("todo", true, false);
        }
        commandStackPointer++;
        Command command = commandStack.get(commandStackPointer);
        return command.execute(model);
    }
}

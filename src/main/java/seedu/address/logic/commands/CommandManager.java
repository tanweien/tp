package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;

import java.util.Stack;

public class CommandManager implements CommandManageable{
    private int commandStackPointer = -1;
    private Stack<Command> commandStack = new Stack<>();
    private Model model;
    private Command currentCommand;

    public CommandManager(Model modelManager, Command currentCommand) {
        this.model = modelManager;
        this.currentCommand = currentCommand;
    }

    @Override
    public void insertCommand() {

    }

    @Override
    public void refreshFutureCommands(int undoRedoPointer) {
        if(commandStack.size()<1) {
            return;
        }
        for(int i = commandStack.size()-1; i > commandStackPointer; i--) {
            commandStack.remove(i);
        }
    }

    @Override
    public void undo() {
        Command command = commandStack.get(commandStackPointer);
        //command.unExecute(model);
        commandStackPointer--;
    }

    @Override
    public void redo() {
        if(commandStackPointer == commandStack.size() - 1)
            return;
        commandStackPointer++;
        Command command = commandStack.get(commandStackPointer);
        //command.execute();
    }
}

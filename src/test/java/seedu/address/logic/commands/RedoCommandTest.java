package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

class RedoCommandTest {

    @Test
    void execute() throws CommandException {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        CommandResult result = (new RedoCommand()).execute(model);

        assertEquals(result.getFeedbackToUser(), "Redid command");
    }

    @Test
    void unExecute() throws CommandException {
        RedoCommand command = new RedoCommand();
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        CommandResult shouldBeNull = command.unExecute(model);

        assertTrue(shouldBeNull == null);
    }

    @Test
    void isRedo() {
        boolean isRedo = (new RedoCommand()).isRedo();

        assertEquals(isRedo, true);
    }
}

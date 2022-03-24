package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandUnExecuteSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;

public class CopyCommandTest {

    private final Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Person personToCopy = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        CopyCommand copyCommand = new CopyCommand(INDEX_FIRST_PERSON);

        String expectedMessage = String.format(CopyCommand.MESSAGE_COPY_PERSON_SUCCESS, personToCopy.getEmail());

        assertCommandSuccess(copyCommand, model, expectedMessage, model);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);

        Person personToCopy = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        CopyCommand copyCommand = new CopyCommand(INDEX_FIRST_PERSON);

        String expectedMessage = String.format(CopyCommand.MESSAGE_COPY_PERSON_SUCCESS, personToCopy.getEmail());

        assertCommandSuccess(copyCommand, model, expectedMessage, model);
    }

    @Test
    public void equals() {
        CopyCommand copyFirstCommand = new CopyCommand(INDEX_FIRST_PERSON);
        CopyCommand copySecondCommand = new CopyCommand(INDEX_SECOND_PERSON);

        // same object -> returns true
        assertTrue(copyFirstCommand.equals(copyFirstCommand));

        // same values -> returns true
        CopyCommand copyFirstCommandCopy = new CopyCommand(INDEX_FIRST_PERSON);
        assertTrue(copyFirstCommand.equals(copyFirstCommandCopy));

        // different types -> returns false
        assertFalse(copyFirstCommand.equals(1));

        // null -> returns false
        assertFalse(copyFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(copyFirstCommand.equals(copySecondCommand));
    }

}

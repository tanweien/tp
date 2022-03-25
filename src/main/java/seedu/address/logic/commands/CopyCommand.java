package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.ModelMemento;
import seedu.address.model.person.Person;

/**
 * Copies the email address of person identified using it's displayed index from the address book.
 */
public class CopyCommand extends Command {
    public static final String COMMAND_WORD = "copy";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Copies the email address of person identified by the index number used in the displayed person list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_COPY_PERSON_SUCCESS = "Copied email address: %1$s";

    private final Index targetIndex;
    private ModelMemento modelMemento;
    private Person copyPerson;

    public CopyCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToCopy = lastShownList.get(targetIndex.getZeroBased());
        this.copyPerson = personToCopy;
        this.modelMemento = new ModelMemento();
        modelMemento.setModel(new ModelManager(model.makeCopy()));

        String emailToCopy = copyPerson.getEmail().value;
        StringSelection stringSelection = new StringSelection(emailToCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        return new CommandResult(String.format(MESSAGE_COPY_PERSON_SUCCESS, emailToCopy));
    }

    @Override
    public CommandResult unExecute(Model model) throws CommandException {
        model.setAddressBook(this.modelMemento.getModel().getAddressBook());
        return new CommandResult("Copy of contact cannot be done.", false, false);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CopyCommand // instanceof handles nulls
                && targetIndex.equals(((CopyCommand) other).targetIndex)); // state check
    }
}

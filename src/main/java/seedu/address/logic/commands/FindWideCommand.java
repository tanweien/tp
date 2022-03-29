package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.ModelMemento;
import seedu.address.model.person.NameFacultyRoleContainsAnyKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindWideCommand extends Command {
    public static final String COMMAND_WORD = "find-wide";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose name, role or faculty contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob computing";

    private final NameFacultyRoleContainsAnyKeywordsPredicate predicate;
    private ModelMemento modelMemento;

    public FindWideCommand(NameFacultyRoleContainsAnyKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        this.modelMemento = new ModelMemento();
        modelMemento.setModel(new ModelManager(model.makeCopy()));

        model.updateFilteredPersonList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    @Override
    public CommandResult unExecute(Model model) throws CommandException {
        model.setAddressBook(this.modelMemento.getModel().getAddressBook());
        model.updateFilteredPersonList(this.predicate);
        return new CommandResult("Find contacts with specified keywords.");
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindWideCommand // instanceof handles nulls
                && predicate.equals(((FindWideCommand) other).predicate)); // state check
    }
}

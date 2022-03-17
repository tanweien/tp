package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.function.Predicate;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.ModelMemento;
import seedu.address.model.person.Person;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all persons";

    private ModelMemento modelMemento;
    private Predicate<Person> predicate = PREDICATE_SHOW_ALL_PERSONS;

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        this.modelMemento = new ModelMemento();
        modelMemento.setModel(new ModelManager(model.makeCopy()));
        this.predicate = model.getModelPredicate();

        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public CommandResult unExecute(Model model) throws CommandException {
        model.setAddressBook(this.modelMemento.getModel().getAddressBook());
        model.updateFilteredPersonList(this.predicate);
        return new CommandResult("List all contacts.", false, false);
    }
}

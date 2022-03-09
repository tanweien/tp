package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

import java.util.List;
import java.util.Set;

/**
 * Changes the favourite status of an existing person in the address book.
 */
public class UnfavouriteCommand extends Command {

    public static final String COMMAND_WORD = "unfav";

    private final Index targetIndex;

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Changes the favourite status of a person identified by the index number used in the displayed person list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_FAVOURITE_PERSON_SUCCESS = "Added to Favourites Person: %1$s";

    public UnfavouriteCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        // change this xddd
        Person personToUnfavourite = lastShownList.get(targetIndex.getZeroBased());
        Person unfavouritedPerson = createUnfavouritedPerson(personToUnfavourite);
        model.setPerson(personToUnfavourite, unfavouritedPerson);
        return new CommandResult(String.format(MESSAGE_FAVOURITE_PERSON_SUCCESS, unfavouritedPerson));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommand // instanceof handles nulls
                && targetIndex.equals(((UnfavouriteCommand) other).targetIndex)); // state check
    }

    private static Person createUnfavouritedPerson(Person personToUnfavourite) {
        assert personToUnfavourite != null;

        Name updatedName = personToUnfavourite.getName();
        Phone updatedPhone = personToUnfavourite.getPhone();
        Email updatedEmail = personToUnfavourite.getEmail();

        Address updatedAddress = personToUnfavourite.getAddress();
        Favourite updatedFavourite = new Favourite(false); // edit command does not allow editing favourite status
        Set<Tag> updatedTags = personToUnfavourite.getTags();


        return new Person(updatedName, updatedPhone, updatedEmail, updatedAddress, updatedFavourite, updatedTags);
    }
}

package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Favourite;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Changes the favourite status of an existing person in the address book.
 */
public class FavouriteCommand extends Command {

    public static final String COMMAND_WORD = "fav";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Changes the favourite status of a person identified "
            + "by the index number used in the displayed person list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";


    public static final String MESSAGE_FAVOURITE_PERSON_SUCCESS = "Added to Favourites Person: %1$s";

    public static final String MESSAGE_DUPLICATE_PERSON = "This person is already saved to favourites.";

    private final Index targetIndex;

    public FavouriteCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToFavourite = lastShownList.get(targetIndex.getZeroBased());
        Person favouritedPerson = createFavouritedPerson(personToFavourite);

        if (!personToFavourite.isSamePerson(favouritedPerson) && model.hasPerson(favouritedPerson)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.setPerson(personToFavourite, favouritedPerson);
        // model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_FAVOURITE_PERSON_SUCCESS, favouritedPerson));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FavouriteCommand // instanceof handles nulls
                && targetIndex.equals(((FavouriteCommand) other).targetIndex)); // state check
    }

    private static Person createFavouritedPerson(Person personToFavourite) {
        assert personToFavourite != null;

        Name updatedName = personToFavourite.getName();
        Phone updatedPhone = personToFavourite.getPhone();
        Email updatedEmail = personToFavourite.getEmail();

        Address updatedAddress = personToFavourite.getAddress();
        Favourite updatedFavourite = new Favourite(true); // edit command does not allow editing favourite status
        Set<Tag> updatedTags = personToFavourite.getTags();


        return new Person(updatedName, updatedPhone, updatedEmail, updatedAddress, updatedFavourite, updatedTags);
    }
}

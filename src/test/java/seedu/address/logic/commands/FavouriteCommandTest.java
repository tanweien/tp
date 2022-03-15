package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.*;
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
import seedu.address.testutil.PersonBuilder;

public class FavouriteCommandTest {

    @Test
    public void equals() {
        Person genericPerson = new PersonBuilder().build();

        // same person -> return true
        assertTrue(genericPerson.equals(genericPerson));

        // same favourite status -> return true
        assertTrue(genericPerson.equals(new PersonBuilder().withFavourite(false).build()));

        // different favourite status -> return true
        assertFalse(genericPerson.equals(new PersonBuilder().withFavourite(true).build()));

    }

}

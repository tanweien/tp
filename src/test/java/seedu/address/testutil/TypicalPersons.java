package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

import static seedu.address.logic.commands.CommandTestUtil.*;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline")
            .withTelegram("@AliceInBorderland9393").withEmail("alice@example.com").withFaculty("Business")
            .withRole("Professor").withPhone("94351253").withTags("friends").build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier")
            .withTelegram("@bendsons332").withEmail("johnd@example.com")
            .withPhone("98765432").withFaculty("Computing").withRole("TA").withFavourite(true)
            .withTags("owesMoney", "friends").build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withFaculty("Dentistry").withRole("Professor")
            .withTelegram("@ketchupMaster59").build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withFaculty("Law").withRole("Dean").withTelegram("@theDamnDaniel391")
            .withTags("friends").build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withFaculty("Nursing").withRole("Professor")
            .withTelegram("@wernerthepig32").build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withFaculty("Music").withRole("TA")
            .withTelegram("@100ladybugs").build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withFaculty("Pharmacy").withRole("Professor")
            .withTelegram("@theInventee").build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withFaculty("Business").withRole("Professor")
            .withTelegram("@bee83").build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withFaculty("Computing").withRole("TA")
            .withTelegram("@HoUSA").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withFaculty(VALID_FACULTY_AMY).withRole(VALID_ROLE_AMY)
            .withTelegram(VALID_TELEGRAM_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withFaculty(VALID_FACULTY_BOB).withRole(VALID_ROLE_BOB)
            .withTelegram(VALID_TELEGRAM_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static AddressBook getMinusAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersonsMinusAlice()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static AddressBook getEditedAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersonsEditedAlice()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }

    public static List<Person> getTypicalPersonsMinusAlice() {
        return new ArrayList<>(Arrays.asList(BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }

    public static List<Person> getTypicalPersonsEditedAlice() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }

    public static List<Person> getTypicalPersonsAddHoon() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE, HOON));
    }

    public static List<Person> getTypicalPersonsTaggedFriends() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, DANIEL));
    }
}

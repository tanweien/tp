package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class NameFacultyRoleContainsAnyKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        NameFacultyRoleContainsAnyKeywordsPredicate firstPredicate = new NameFacultyRoleContainsAnyKeywordsPredicate(
                firstPredicateKeywordList);
        NameFacultyRoleContainsAnyKeywordsPredicate secondPredicate = new NameFacultyRoleContainsAnyKeywordsPredicate(
                secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        NameFacultyRoleContainsAnyKeywordsPredicate firstPredicateCopy =
                new NameFacultyRoleContainsAnyKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_nameContainsKeywords_returnsTrue() {
        // One keyword
        NameFacultyRoleContainsAnyKeywordsPredicate predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(
                Collections.singletonList("Alice"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Multiple keywords
        predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(Arrays.asList("Alice", "Bob"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Only one matching keyword
        predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(Arrays.asList("Bob", "Carol"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Carol").build()));

        // Mixed-case keywords
        predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(Arrays.asList("aLIce", "bOB"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));
    }

    @Test
    public void test_nameDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        NameFacultyRoleContainsAnyKeywordsPredicate predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(
                Collections.emptyList());
        assertFalse(predicate.test(new PersonBuilder().withName("Alice").build()));

        // Non-matching keyword
        predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(Arrays.asList("Carol"));
        assertFalse(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

    }

    @Test
    public void test_facultyContainsKeywords_returnsTrue() {
        // One keyword
        NameFacultyRoleContainsAnyKeywordsPredicate predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(
                Collections.singletonList("Computing"));
        assertTrue(predicate.test(new PersonBuilder().withFaculty("Computing Business").build()));

        // Multiple keywords
        predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(Arrays.asList("Computing", "Business"));
        assertTrue(predicate.test(new PersonBuilder().withFaculty("Computing Business").build()));

        // Only one matching keyword
        predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(Arrays.asList("Business", "Arts"));
        assertTrue(predicate.test(new PersonBuilder().withFaculty("Computing Arts").build()));

        // Mixed-case keywords
        predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(Arrays.asList("cOmpUtinG", "bUsinEsS"));
        assertTrue(predicate.test(new PersonBuilder().withFaculty("Computing Business").build()));
    }

    @Test
    public void test_facultyDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        NameFacultyRoleContainsAnyKeywordsPredicate predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(
                Collections.emptyList());
        assertFalse(predicate.test(new PersonBuilder().withFaculty("Computing").build()));

        // Non-matching keyword
        predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(Arrays.asList("Arts"));
        assertFalse(predicate.test(new PersonBuilder().withFaculty("Computing Business").build()));

    }

    @Test
    public void test_roleContainsKeywords_returnsTrue() {
        // One keyword
        NameFacultyRoleContainsAnyKeywordsPredicate predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(
                Collections.singletonList("Professor"));
        assertTrue(predicate.test(new PersonBuilder().withRole("Professor TA").build()));

        // Multiple keywords
        predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(Arrays.asList("Professor", "TA"));
        assertTrue(predicate.test(new PersonBuilder().withRole("Professor TA").build()));

        // Only one matching keyword
        predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(Arrays.asList("TA", "Dean"));
        assertTrue(predicate.test(new PersonBuilder().withRole("Professor Dean").build()));

        // Mixed-case keywords
        predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(Arrays.asList("prOfesSor", "tA"));
        assertTrue(predicate.test(new PersonBuilder().withRole("Professor TA").build()));
    }

    @Test
    public void test_roleDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        NameFacultyRoleContainsAnyKeywordsPredicate predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(
                Collections.emptyList());
        assertFalse(predicate.test(new PersonBuilder().withRole("Professor").build()));

        // Non-matching keyword
        predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(Arrays.asList("Dean"));
        assertFalse(predicate.test(new PersonBuilder().withRole("Professor TA").build()));

    }

    @Test
    public void test_nameFacultyRoleContainKeywords_returnsTrue() {
        // Keywords match name, faculty and role but not email and Telegram.
        // Same keyword is present in name, faculty and role
        NameFacultyRoleContainsAnyKeywordsPredicate predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(
                Arrays.asList("Computing"));
        assertTrue(predicate.test(new PersonBuilder().withName("Ms Computing").withPhone("67891")
                .withEmail("doesNotMatch@gmail.com").withFaculty("Computing").withRole("Computing Professor")
                .withTelegram("@doesNotMatch").build()));
    }

    @Test
    public void test_nameFacultyRoleDoNotContainKeywords_returnsFalse() {
        // Keywords match phone, email and address, but does not match name, faculty and role
        NameFacultyRoleContainsAnyKeywordsPredicate predicate = new NameFacultyRoleContainsAnyKeywordsPredicate(
                Arrays.asList("12345", "alice@email.com", "Computing", "Professor", "Main", "Street"));
        assertFalse(predicate.test(new PersonBuilder().withName("Alice").withPhone("12345")
                .withEmail("alice@email.com").withFaculty("Business").withRole("Dishwasher")
                .withTelegram("@MainStreet").build()));
    }
}

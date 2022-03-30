package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class NameFacultyRoleContainsAllKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        NameFacultyRoleContainsAllKeywordsPredicate firstPredicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                firstPredicateKeywordList);
        NameFacultyRoleContainsAllKeywordsPredicate secondPredicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        NameFacultyRoleContainsAllKeywordsPredicate firstPredicateCopy =
                new NameFacultyRoleContainsAllKeywordsPredicate(firstPredicateKeywordList);
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
        NameFacultyRoleContainsAllKeywordsPredicate predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Collections.singletonList("Alice"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Multiple keywords
        predicate = new NameFacultyRoleContainsAllKeywordsPredicate(Arrays.asList("Alice", "Bob"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Mixed-case keywords
        predicate = new NameFacultyRoleContainsAllKeywordsPredicate(Arrays.asList("aLIce", "bOB"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));
    }

    @Test
    public void test_nameContainsKeywords_returnsFalse() {
        // Only one matching keyword
        NameFacultyRoleContainsAllKeywordsPredicate predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Arrays.asList("Bob", "Carol"));
        assertFalse(predicate.test(new PersonBuilder().withName("Alice Carol").build()));
    }

    @Test
    public void test_nameDoesNotMatchKeyword_returnsFalse() {
        NameFacultyRoleContainsAllKeywordsPredicate predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Collections.emptyList());
        // Non-matching keyword
        predicate = new NameFacultyRoleContainsAllKeywordsPredicate(Arrays.asList("Carol"));
        assertFalse(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

    }

    @Test
    public void test_facultyContainsKeywords_returnsTrue() {
        // One keyword
        NameFacultyRoleContainsAllKeywordsPredicate predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Collections.singletonList("Computing"));
        assertTrue(predicate.test(new PersonBuilder().withFaculty("Computing").build()));

        // Multiple keywords
        predicate = new NameFacultyRoleContainsAllKeywordsPredicate(Arrays.asList("Computing", "Business"));
        assertTrue(predicate.test(new PersonBuilder().withFaculty("Computing Business").build()));

        // Mixed-case keywords
        predicate = new NameFacultyRoleContainsAllKeywordsPredicate(Arrays.asList("cOmpUtinG", "bUsinEsS"));
        assertTrue(predicate.test(new PersonBuilder().withFaculty("Computing Business").build()));
    }

    @Test
    public void test_facultyContainsKeywords_returnsFalse() {
        // Only one matching keyword
        NameFacultyRoleContainsAllKeywordsPredicate predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Arrays.asList("Business", "Arts"));
        assertFalse(predicate.test(new PersonBuilder().withFaculty("Computing Arts").build()));

        // Multiple keywords
        predicate = new NameFacultyRoleContainsAllKeywordsPredicate(Arrays.asList("Computing", "Business"));
        assertFalse(predicate.test(new PersonBuilder().withFaculty("Computing").build()));
    }

    @Test
    public void test_facultyDoesNotContainKeywords_returnsFalse() {
        // Zero matching keyword
        NameFacultyRoleContainsAllKeywordsPredicate predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Arrays.asList("Computing"));
        assertFalse(predicate.test(new PersonBuilder().withFaculty("Business").build()));

        // Zero matching keywords
        predicate = new NameFacultyRoleContainsAllKeywordsPredicate(Arrays.asList("Arts"));
        assertFalse(predicate.test(new PersonBuilder().withFaculty("Computing Business").build()));

    }

    @Test
    public void test_roleContainsKeywords_returnsTrue() {
        // One keyword
        NameFacultyRoleContainsAllKeywordsPredicate predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Collections.singletonList("Professor"));
        assertTrue(predicate.test(new PersonBuilder().withRole("Professor TA").build()));

        // Multiple keywords
        predicate = new NameFacultyRoleContainsAllKeywordsPredicate(Arrays.asList("Professor", "TA"));
        assertTrue(predicate.test(new PersonBuilder().withRole("Professor TA").build()));

        // Mixed-case keywords
        predicate = new NameFacultyRoleContainsAllKeywordsPredicate(Arrays.asList("prOfesSor", "tA"));
        assertTrue(predicate.test(new PersonBuilder().withRole("Professor TA").build()));
    }

    @Test
    public void test_roleContainsKeywords_returnsFalse() {
        // Zero matching keywords
        NameFacultyRoleContainsAllKeywordsPredicate predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Arrays.asList("Professor"));
        assertFalse(predicate.test(new PersonBuilder().withRole("Dean").build()));
        // Only one matching keyword
        predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Arrays.asList("TA", "Dean"));
        assertFalse(predicate.test(new PersonBuilder().withRole("Professor Dean").build()));

        // One matching keyword but not a complete match
        predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Arrays.asList("Professor", "Dean"));
        assertFalse(predicate.test(new PersonBuilder().withRole("Professor").build()));
    }

    @Test
    public void test_roleDoesNotContainKeywords_returnsFalse() {
        // Non-matching keyword
        NameFacultyRoleContainsAllKeywordsPredicate predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Arrays.asList("Dean"));
        assertFalse(predicate.test(new PersonBuilder().withRole("Professor TA").build()));

    }

    @Test
    public void test_nameFacultyRoleContainAllKeywords_returnsTrue() {
        // All Keywords match name, faculty and role
        NameFacultyRoleContainsAllKeywordsPredicate predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Arrays.asList("Alice", "Computing", "Professor"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice").withPhone("67891")
                .withEmail("bryce@gmail.com").withFaculty("Computing").withRole("Professor")
                .withAddress("Baker street").build()));
    }

    @Test
    public void test_nameFacultyRoleDoNotContainAllKeywords_returnsFalse() {
        // Keywords match name and faculty but not role
        NameFacultyRoleContainsAllKeywordsPredicate predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Arrays.asList("Alice", "Business", "TA"));
        assertFalse(predicate.test(new PersonBuilder().withName("Alice").withPhone("12345")
                .withEmail("alice@email.com").withFaculty("Business").withRole("Professor")
                .withAddress("Main Street").build()));

        // Keywords match name and role but not faculty
        predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Arrays.asList("Alice", "Computing", "Professor"));
        assertFalse(predicate.test(new PersonBuilder().withName("Alice").withPhone("12345")
                .withEmail("alice@email.com").withFaculty("Business").withRole("Professor")
                .withAddress("Main Street").build()));

        // Keywords match faculty and role but not name
        predicate = new NameFacultyRoleContainsAllKeywordsPredicate(
                Arrays.asList("Benson", "Business", "Professor"));
        assertFalse(predicate.test(new PersonBuilder().withName("Alice").withPhone("12345")
                .withEmail("alice@email.com").withFaculty("Business").withRole("Professor")
                .withAddress("Main Street").build()));
    }
}

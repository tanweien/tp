package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class NameFacultyRoleContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public NameFacultyRoleContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getName().fullName, keyword) ||
                StringUtil.containsWordIgnoreCase(person.getFaculty().value, keyword) ||
                StringUtil.containsWordIgnoreCase(person.getRole().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NameFacultyRoleContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((NameFacultyRoleContainsKeywordsPredicate) other).keywords)); // state check
    }

}

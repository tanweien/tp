package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RoleTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Role(null));
    }

    @Test
    public void constructor_invalidRole_throwsIllegalArgumentException() {
        String invalidRole = "";
        assertThrows(IllegalArgumentException.class, () -> new Role(invalidRole));
    }

    @Test
    public void isValidRole() {
        // null address
        assertThrows(NullPointerException.class, () -> Role.isValidRole(null));

        // invalid faculties
        assertFalse(Role.isValidRole("")); // empty string
        assertFalse(Role.isValidRole(" ")); // spaces only

        // valid faculties
        assertTrue(Role.isValidRole("Professor"));
        assertTrue(Role.isValidRole("-")); // one character
        assertTrue(Role.isValidRole("Teaching Assistant")); // long role
    }

    @Test
    public void testEqualsSymmetric() {
        Role x = new Role("Professor"); // equals and hashCode check name field value
        Role y = new Role("Professor");
        assertTrue(x.equals(y) && y.equals(x));
        assertTrue(x.hashCode() == y.hashCode());
    }
}

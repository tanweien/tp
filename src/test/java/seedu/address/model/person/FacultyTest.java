package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class FacultyTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Faculty(null));
    }

    @Test
    public void constructor_invalidFaculty_throwsIllegalArgumentException() {
        String invalidFaculty = "";
        assertThrows(IllegalArgumentException.class, () -> new Faculty(invalidFaculty));
    }

    @Test
    public void isValidFaculty() {
        // null address
        assertThrows(NullPointerException.class, () -> Faculty.isValidFaculty(null));

        // invalid faculties
        assertFalse(Faculty.isValidFaculty("")); // empty string
        assertFalse(Faculty.isValidFaculty(" ")); // spaces only

        // valid faculties
        assertTrue(Faculty.isValidFaculty("Computing"));
        assertTrue(Faculty.isValidFaculty("-")); // one character
        assertTrue(Faculty.isValidFaculty("College of Humanities and Sciences")); // long faculty
    }

    @Test
    public void testEquals_Symmetric() {
        Faculty x = new Faculty("Computing");  // equals and hashCode check name field value
        Faculty y = new Faculty("Computing");
        assertTrue(x.equals(y) && y.equals(x));
        assertTrue(x.hashCode() == y.hashCode());
    }
}

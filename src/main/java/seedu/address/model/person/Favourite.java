package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Favourite {

    public static final String MESSAGE_IS_FAVOURTIE = "true";
    public static final String MESSAGE_NOT_FAVOURTIE = "false";
    public static final String MESSAGE_CONSTRAINTS = "Favourite status should either be true or false";

    public final boolean isFavourite;

    public Favourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

//    public Favourite(String isFavourite) {
//        requireNonNull(isFavourite);
//        checkArgument(isValidFavourite(isFavourite), MESSAGE_CONSTRAINTS);
//        if (isFavourite.toLowerCase().equals("true")) {
//            this.isFavourite = true;
//        } else {
//            this.isFavourite = false;
//        }
//    }

    @Override
    public String toString() {
        if (isFavourite) {
            return MESSAGE_IS_FAVOURTIE;
        } else {
            return MESSAGE_NOT_FAVOURTIE;
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Favourite // instanceof handles nulls
                && isFavourite == ((Favourite) other).isFavourite); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

//    public static Boolean isValidFavourite(String isFavourite) {
//        if (isFavourite.equals("true") || isFavourite.equals("false")) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}

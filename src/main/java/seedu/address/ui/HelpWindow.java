package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {
    public static final String USERGUIDE_URL =
        "https://github.com/AY2122S2-CS2103T-W11-4/tp/blob/master/docs/UserGuide.md";
    private static final String HELP_ADD_MESSAGE =
            "\nTo add contact:\n        add n/{name} e/{email} a/{address}\n";
    private static final String HELP_LIST_MESSAGE =
            "\nTo display all contacts:\n        list (IMPT: use 'list' to view index of contact when required)\n";
    private static final String HELP_EDIT_MESSAGE =
            "\nTo edit:\n        edit {index} [n/NAME] [p/PHONE] [e/EMAIL] [f/FACULTY] [r/ROLE] [t/TAG]\n";
    private static final String HELP_FAV_MESSAGE =
            "\nTo add a contact to favourites:\n        fav {index}\n";
    private static final String HELP_UNFAV_MESSAGE =
            "\nTo remove a contact from favourites:\n        unfav {index} (IMPT: use 'list-fav' to view index)\n";
    private static final String HELP_LISTFAV_MESSAGE =
            "\nTo display all favourite contacts:\n        list-fav\n";
    private static final String HELP_FIND_MESSAGE =
            "\nTo find contacts that contains any of the given keywords:\n        find {name} [MORE_KEYWORDS]\n";
    private static final String HELP_TAG_MESSAGE =
            "\nTo find contacts that contains any of the given tags:\n        tag {Keyword} [MORE_KEYWORDS]\n";
    private static final String HELP_DELETE_MESSAGE =
            "\nTo delete a contact:\n        delete {index}\n";
    private static final String HELP_CLEAR_MESSAGE =
            "\nTo delete all contacts:\n        clear\n";
    private static final String HELP_UNDO_MESSAGE =
            "\nTo undo command:\n        undo\n";
    private static final String HELP_REDO_MESSAGE =
            "\nTo redo an undo command:\n        redo\n";
    private static final String HELP_EXIT_MESSAGE =
            "\nTo exit:\n        exit\n";
    public static final String HELP_MESSAGE =
            "Refer to the user guide for more details: " + USERGUIDE_URL + "\n"
            + HELP_ADD_MESSAGE
            + HELP_LIST_MESSAGE
            + HELP_EDIT_MESSAGE
            + HELP_FAV_MESSAGE
            + HELP_UNFAV_MESSAGE
            + HELP_LISTFAV_MESSAGE
            + HELP_FIND_MESSAGE
            + HELP_TAG_MESSAGE
            + HELP_DELETE_MESSAGE
            + HELP_CLEAR_MESSAGE
            + HELP_UNDO_MESSAGE
            + HELP_REDO_MESSAGE
            + HELP_EXIT_MESSAGE;




    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private Button copyButton;

    @FXML
    private Label helpMessage;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(HELP_MESSAGE);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}

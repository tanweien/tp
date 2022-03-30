---
layout: page
title: NUSearch Developer Guide V1.3
---
--------------------------------------------------------------------------------------------------------------------

## **Acknowledgements**

* Adapted from [AddressBook3](https://github.com/nus-cs2103-AY2122S2/tp)

___________________________________________________________________________________________________________________

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

## Design

> :bulb: **TIP:** The `.puml` files used to create diagrams in this document can be found in the [diagrams](https://github.com/AY2122S2-CS2103T-W11-4/tp/tree/master/docs/diagrams) folder. Refer to the [_PlantUML Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/plantUml.html) to learn how to create and edit diagrams.  


### Architecture

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="images/ArchitectureDiagram.png" width="280"/>
  </a>
<h5 align="center">Fig 1.1. Architecture Diagram</h5>
</div>

The ***Architecture Diagram*** given above explains the high-level design of the App.


Given below is a quick overview of Main components and how they interact with each other.

**Main components of the architecture**

**`Main`** has two classes called [`Main`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java). It is responsible for,
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

The rest of the App consists of four components.

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.
* [`CommandManager`](#command-manager-component): Receives commands from the logic component and handles its execution/un-execution appropriately.

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command delete 1.

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="images/ArchitectureSequenceDiagram.png" width="280"/>
  </a>
<h5 align="center">Fig 1.2. Architecture Sequence Diagram (Delete command)</h5>
</div>

Each of the five main components (also shown in the diagram above),

* defines its *API* in an interface with the same name as the Component.
* implements its functionality using a concrete {Component Name}Manager class (which follows the corresponding API interface mentioned in the previous point.

> :bulb: Eg. The Model component defines its API in the Model.java interface and implements its functionality using the ModelManager.java class which follows the Model interface. Other components interact with a given component through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the implementation of a component), as illustrated in the (partial) class diagram below.

The following section gives more details of each component.

### Components

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="images/ComponentManagers.png" width="280" />
  </a>
<h5 align="center">Fig 1.3. Component Managers</h5>
</div>

**The UI Component**

**API** : [`Ui.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java)

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="images/UiClassDiagram.png" width="280" />
  </a>
<h5 align="center">Fig 2.1. UI Class Diagram</h5>
</div>

The UI consists of a MainWindow that is made up of parts e.g.CommandBox, ResultDisplay, PersonListPanel, StatusBarFooter etc. All these, including the MainWindow, inherit from the abstract UiPart class which captures the commonalities between classes that represent parts of the visible GUI.

The UI component uses the JavaFx UI framework. The layout of these UI parts are defined in matching .fxml files that are in the src/main/resources/view folder. For example, the layout of the [MainWindow](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [MainWindow.fxml](https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml)

The UI component,

* executes user commands using the Logic component.
* listens for changes to Model data so that the UI can be updated with the modified data.
* keeps a reference to the Logic component, because the UI relies on the Logic to execute commands.
* depends on some classes in the Model component, as it displays Person object residing in the Model.

> :memo: **NOTE** The Command Manager component is not reflected in the diagram since there are no direct dependencies with the UI component

**The Logic Component**

**API** : [`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java)

Here's a (partial) class diagram of the `Logic` component:

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="images/LogicClassDiagram.png" width="280" />
  </a>
<h5 align="center">Fig 2.2. Logic Class Diagram (Partial)</h5>
</div>

How the `Logic` component works:
1. When `Logic` is called upon to execute a command, it uses the `AddressBookParser` class to parse the user command.
1. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `AddCommand`) which is executed by the `LogicManager`.
1. The command can communicate with the `CommandManager` when it is executed (e.g. to add a person).
1. The result of the command execution is encapsulated as a `CommandResult` object which is returned from `Logic`.

The Sequence Diagram below illustrates the interactions within the `Logic` component for the `execute("delete 1")` API call.

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="images/DeleteSequenceDiagram.png" width="280" />
  </a>
<h5 align="center">Fig 2.3. Delete Command Sequence Diagram</h5>
</div>

> :memo: **NOTE:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

Here are the other classes in `Logic` (omitted from the class diagram above) that are used for parsing a user command:

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="images/ParserClasses.png" width="280" />
  </a>
<h5 align="center">Fig 2.4. Parser Class Diagram</h5>
</div>

How the parsing works:
* When called upon to parse a user command, the `AddressBookParser` class creates an `XYZCommandParser` (`XYZ` is a placeholder for the specific command name e.g., `AddCommandParser`) which uses the other classes shown above to parse the user command and create a `XYZCommand` object (e.g., `AddCommand`) which the `AddressBookParser` returns back as a `Command` object.
* All `XYZCommandParser` classes (e.g., `AddCommandParser`, `DeleteCommandParser`, ...) inherit from the `Parser` interface so that they can be treated similarly where possible e.g, during testing.

**The CommandManageable Component**

**API** : [`CommandManageable.java`](https://github.com/eugenechiaay/tp/blob/master/src/main/java/seedu/address/logic/commands/CommandManageable.java)

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="images/CMClassDiagram.png" width="280" />
  </a>
<h5 align="center">Fig 2.5. CM Class Diagram</h5>
</div>

The `CommandManageable` component,

* receives command objects from the `Logic` component e.g. a `DeleteCommand`.
* keeps track of commands and states in a stack.
* any `UndoCommand` or `RedoCommand` it receives will be processed differently from other commands.
* a component between logic and model, commands are executed and un-execute here.

> :bulb: **COOL:** The Command Manager component was built as a means to support the newly implemented undo and redo functions!

**The Model Component**

**API** : [`Model.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/model/Model.java)

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="images/ModelClassDiagram.png" width="280" />
  </a>
<h5 align="center">Fig 2.6.1. Model Class Diagram</h5>
</div>

The `Model` component,

* stores the NUSearch data i.e., all `Person` objects (which are contained in a `UniquePersonList` object).
* stores the currently 'selected' `Person` objects (e.g., results of a search query) as a separate _filtered_ list which is exposed to outsiders as an unmodifiable `ObservableList<Person>` that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.
* stores a `UserPref` object that represents the user’s preferences. This is exposed to the outside as a `ReadOnlyUserPref` objects.
* does not depend on any of the other three components (as the `Model` represents data entities of the domain, they should make sense on their own without depending on other components)

>:memo: **NOTE:** An alternative (arguably, a more OOP) model is given below. It has a `Tag` list in the `AddressBook`, which `Person` references. This allows `AddressBook` to only require one `Tag` object per unique tag, instead of each `Person` needing their own `Tag` objects.<br>

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="images/BetterModelClassDiagram.png" width="280" />
  </a>
<h5 align="center">Fig 2.6.2. Better Model Class Diagram</h5>
</div>

**The Storage Component**

**API** : [`Storage.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storage/Storage.java)

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="images/StorageClassDiagram.png" width="280" />
  </a>
<h5 align="center">Fig 2.6.2. Storage Class Diagram</h5>
</div>

The `Storage` component,
* can save both address book data and user preference data in json format, and read them back into corresponding objects.
* inherits from both `AddressBookStorage` and `UserPrefStorage`, which means it can be treated as either one (if only the functionality of only one is needed).
* depends on some classes in the `Model` component (because the `Storage` component's job is to save/retrieve objects that belong to the `Model`)

### Common classes

**The Command classes**

> //todo

Classes used by multiple components are in the `seedu.addressbook.commons` package.

--------------------------------------------------------------------------------------------------------------------

## **Implementation**

> //todo
> Add
> Favourite
> list favourite
> Find tag
> Undo
> Redo

--------------------------------------------------------------------------------------------------------------------

## **Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

## **Appendix**

**Requirements**

### Product scope

**Target user profile**:

* has a need to manage a significant number of contacts
* prefer desktop apps over other types
* can type fast
* prefers typing to mouse interactions
* is reasonably comfortable using CLI apps

**Value proposition**: manage NUS contacts faster than a typical mouse/GUI driven app


### User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …​                                    | I want to …​                                  | So that I can…​                                                             |
|-----| ------------------------------------------ |-----------------------------------------------|-----------------------------------------------------------------------------|
| `* * *` | new user                                   | see usage instructions                        | refer to instructions when I forget how to use the App                      |
| `* * *` | user                                       | add a new staff                               |                                                                             |
| `* * *` | user                                       | delete a staff                                | remove entries that I no longer need                                        |
| `* * *` | user                                       | find a staff by name                          | locate details of staff without having to go through the entire list        |
| `* * *` | user                                       | find a staff by tag                           | locate details of staff associated with the tag without knowing their names |
| `* * *` | user                                       | list all staff contacts                       | view all the staff contacts in NUSearch                                     |
| `* * ` | user                                       | add an existing staff to favourites list      |                                                                             |
| `* * ` | user                                       | delete an existing staff from favourites list |                                                                             |
| `* * ` | user                                       | list all favourite contacts                   | view all my favourite staff contacts                                        |
| `* *` | user                                       | hide private contact details                  | minimize chance of someone else seeing them by accident                     |
| `*` | user with many persons in the address book | sort persons by name                          | locate a person easily                                                      |
| `*` | user                                       | click on hyperlinks on a contact              | contact staff easily                                                        |

*{More to be added}*

### Use cases

(For all use cases below, the **System** is the `NUSearch` and the **Actor** is the `user`, unless specified otherwise)

**Use case 1: Viewing help**

**MSS**

1.  User requests to access the help page
2.  NUSearch shows list of commands and syntax on how to use them

    Use case ends.


**Use case 2: Adding a contact**

**MSS**

1. User requests to add contact to the list
2. NUSearch adds the contact in the database.

    Use case ends.

**Extensions**

* 2a. The given contact exist in the NUSearch database.

    * 2a1. NUSearch shows an error message.

      Use case resumes at step 2.



**Use case 3: Listing all contacts**

**MSS**

1.  User requests to list all contacts.
2.  NUSearch shows a list of contacts.

    Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.


**Use case 4: Locating contacts by name**

**MSS**

1.  User requests to find contacts with name.
2.  NUSearch shows a list of contacts with the name.

    Use case ends.

**Extensions**

* 2a. The given name does not exist in the NUSearch database.

    * 2a1. NUSearch shows an error message.

      Use case resumes at step 2.

**Use case 5: Locate contact by tag**

**MSS**

1.  User requests to list all contacts that contain the specified tag
2.  NUSearch shows a list of contacts

    Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.


**Use case 6: Add contacts to favourites list**

**MSS**

1.  User requests to add a contact to the favourites list
2.  NUSearch shows an updated list of the user's favourite contacts

    Use case ends.

**Extensions**

* 1a. The contact specified does not exist in the system.

  The system prompts the user to key in another contact to be added

**Use case 7: Remove contacts from favourites list**

**MSS**

1.  User requests to remove a contact from the favourites list
2.  NUSearch shows an updated list of the user's favourite contacts

    Use case ends.

**Extensions**

* 1a. The contact specified does not exist in the system.

  The system prompts the user to key in another contact to be added

* 2a. The list is empty.

  Use case ends.

**Use case 8: Listing all favourite contacts**

**MSS**

1.  User requests to list all favourite contacts.
2.  NUSearch shows a list of contacts.

    Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.


**Use case 9: Delete a contact**

**MSS**

1.  User requests to list contacts
2.  NUSearch shows a list of contacts
3.  User requests to delete a specific contact in the list
4.  NUSearch deletes the contact

    Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.

* 3a. The given index is invalid.

    * 3a1. NUSearch shows an error message.

      Use case resumes at step 2.

**Use case 10: Exit the program**

**MSS**

1.  User requests to exit the program
2.  NUSearch says bye

    Use case ends.

### Non-Functional Requirements

1. Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2. Should be able to hold up to 1000 persons without a noticeable sluggishness in performance for typical usage.
3. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.
4. Should be usable by a novice who is unfamiliar with typing commands.
5. Should quickly display requested information within 2 seconds.

*{More to be added}*

### Glossary

* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **Private contact detail**: A contact detail that is not meant to be shared with others
* **Command-line interface**: A command-line interface processes commands to a computer program in the form of lines of text
* **Student**: A student from NUS
* **Staff**: Staff member of NUS, including teaching assistants and administrative staff

--------------------------------------------------------------------------------------------------------------------

**Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</div>

### Launch and shutdown

1. Initial launch

    1. Download the jar file and copy into an empty folder

    1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

1. Saving window preferences

    1. Resize the window to an optimum size. Move the window to a different location. Close the window.

    1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

1. _{ more test cases …​ }_

### Deleting a person

1. Deleting a person while all persons are being shown

    1. Prerequisites: List all persons using the `list` command. Multiple persons in the list.

    1. Test case: `delete 1`<br>
       Expected: First contact is deleted from the list. Details of the deleted contact shown in the status message. Timestamp in the status bar is updated.

    1. Test case: `delete 0`<br>
       Expected: No person is deleted. Error details shown in the status message. Status bar remains the same.

    1. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
       Expected: Similar to previous.

1. _{ more test cases …​ }_

### Saving data

1. Dealing with missing/corrupted data files

    1. _{explain how to simulate a missing/corrupted file, and the expected behavior}_

1. _{ more test cases …​ }_

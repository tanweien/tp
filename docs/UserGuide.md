#NUSearch User guide v1.2

NUSearch is a **desktop app for managing NUS staff contacts, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). <br>
If you can type fast, NUSearch can get your contact management tasks done faster than traditional GUI apps.

<!-- TABLE OF CONTENTS -->
<details open>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#quick-start">Quickstart</a>
    </li>
    <li>
      <a href="#features">Features</a>
      <ul>
        <li><a href="#viewing-help">Viewing Help</a></li>
        <li><a href="#adding-a-person">Adding a person</a></li>
        <li><a href="#listing-all-contacts">Listing all contacts</a></li>
        <li><a href="#editing a person">Locating contacts by name</a></li>
        <li><a href="#adding-a-person-into-favourite-list">Locating contacts by tags</a></li>
        <li><a href="#remvoing-a-person-from-favourite-list">Listing favorite contacts</a></li>
        <li><a href="#list-all-favourite-contacts">Add to favorite list</a></li>
        <li><a href="#locating-contacts-by-tags">Remove from favorite list</a></li>
        <li><a href="#installation">Deleting a contact</a></li>
        <li><a href="#installation">Exiting the program</a></li>
      </ul>
    </li>
    <li>
        <a href="#getting-started">Future Features</a>
        <ul>
            <li><a href="#prerequisites">Filtering contacts: Mod, User name, Faculty, etc…</a></li>
            <li><a href="#prerequisites">Saving contacts to favourites</a></li>
            <li><a href="#prerequisites">Clearing the list</a></li>
            <li><a href="#prerequisites">Interacting with contact</a></li>
            <li><a href="#prerequisites">Addition of multiple modules and roles (eg /mod cs2030 cs2040)</a></li>
            <li><a href="#prerequisites">Improve on the delete feature to delete by name etc</a></li>
        </ul>
    </li>
  </ol>
</details>

## Quick start:

1. Ensure that you have Java `11` or above installed in your Computer.


2. Download the latest `NUSearch.jar` from [here](https://github.com/se-edu/NUSearch/releases).


3. Copy the file to the folder you want to use as the _home folder_ for your NUSearch.


4. Double-click the file to start the app. The GUI (aka Screen) similar to the below should appear in a few seconds. Note how the app already contains some sample data.<br>


<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="../docs/images/Ui.png" width="62%">
  </a>

  <h5 align="center">Fig 1. NUSearch home page</h3>
</div>


5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   > Some example commands you can try:
   > * **`list`** : Lists all contacts.
   > * **`add`**`n/John Doe p/98765432 e/johnd@example.com f/Computing a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the NUSearch.
   > * **`delete`**`3` : Deletes the 3rd contact shown in the current list.
   > * **`clear`** : Deletes all contacts.
   > * **`exit`** : Exits the app.
   
_____________________________________________________
## Notes before use:

<div markdown="block" class="alert alert-info">

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, 
  > `NAME` is a parameter which can be used as `add n/John Doe`.


* Items in square brackets are optional.<br>
  e.g `n/NAME [m/MODULE]`,
  > `[m/MODULE]` is an optional parameter, hence`n/John Doe m/CS2103T` and  `n/John Doe` are both valid commands.


* Items with `…`​ after them can be used multiple times or not at all (i.e zero times).<br>
  e.g. `[m/MODULE]…​`,
  > `[m/MODULE]…​` can be used as ` ` (i.e. 0 times), `m/cs2103T`, `m/CS2103T m/CS2100` etc.


* Parameters can be in any order.<br>
  > If the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.


* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  > If you specify `p/12341234 /56785678`, only `p/56785678` will be taken.


* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  > if the command specifies `help 123`, it will be interpreted as `help`.

</div>

__________________________________________________________________________________________________________________________________

## Commands:

<details open>
  <summary>Command list</summary>
  <ol>
    <li>
      <a href="#quick-start">Quickstart</a>
    </li>
    <li>
      <a href="#quick-start">Quickstart</a>
    </li>
    <li>
      <a href="#quick-start">Quickstart</a>
    </li>
    <li>
      <a href="#quick-start">Quickstart</a>
      <ul>
            <li><a href="#prerequisites">Filtering contacts: Mod, User name, Faculty, etc…</a></li>
            <li><a href="#prerequisites">Saving contacts to favourites</a></li>
            <li><a href="#prerequisites">Clearing the list</a></li>
            <li><a href="#prerequisites">Interacting with contact</a></li>
            <li><a href="#prerequisites">Addition of multiple modules and roles (eg /mod cs2030 cs2040)</a></li>
            <li><a href="#prerequisites">Improve on the delete feature to delete by name etc</a></li>
        </ul>
    </li>
    <li>
      <a href="#quick-start">Quickstart</a>
    </li>
    <li>
      <a href="#quick-start">Quickstart</a>
    </li>
  </ol>
</details>



### View help : `help`

Shows a summative list of available commands for you to input.

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="../docs/images/helpMessage.png" width="62%">
  </a>

  <h5 align="center">Fig 2. Help message screen</h3>
</div>

Format: `help`

> :bulb: **TIP:** Click on `Copy URL button to copy the link to our user guide.`

### Add a contact: `add ...`

Adds a contact to the contact list.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL f/FACULTY r/ROLE [t/TAG]…​`

> :bulb: **TIP:** A contact can have any number of tags, or none at all.

Examples:
* `add n/Shurvir Arora p/98765432 e/shurvir@example.com f/computing r/professor`
* `add n/Betsy Crowe p/98193898 e/betsycrowe@example.com f/arts r/TA t/CS2103T t/KentRidge`

### List all contacts : `list`

Displays all contacts in the contact list.

> :bulb: **TIP:** Contacts listed will be sorted according to the time of addition.

Format: `list`

### Edit a contact : `edit ...`

Edits an existing contact in NUSearch database.

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated according to the input values.
* When editing tags, the existing tags will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without specifying any tags after it.

> :bulb: **TIP** The edit command features multiple permutations, allowing you to edit multiple fields of a single contact in one command.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [f/FACULTY] [r/ROLE] [t/TAG]…​`

Examples:
* `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st contact to be `91234567` and `johndoe@example.com` respectively.
* `edit 2 n/Betsy Crower t/` Edits the name of the 2nd contact to be `Betsy Crower` and clears all existing tags.

### Favourite a contact : `fav ...`

Adds a contact to the favorite list.

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="../docs/images/fav.png" width="62%">
  </a>

<h5 align="center">Fig 3. Favourite contact</h3>
</div>

Format: `fav INDEX`

Examples:
* `fav 1`
* `fav 2`

### Un-favourite a contact : `unfav ...`

Removes a contact from the favorite list.

> NUSearch screen will appear somewhat similar to the image displayed above for the `fav` command

Format: `unfav INDEX`

Examples:
* `unfav 1`
* `unfav 2`

### List all favourite contacts : `list-fav`

Displays all favoured contacts in the contact list.

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="../docs/images/fav.png" width="62%">
  </a>

<h5 align="center">Fig 4. List favourite contacts</h3>
</div>

Format: `list-fav`

### Find contacts by name : `find ...`

Find contacts with names that contain any of the given keywords.

* The search is case-insensitive. e.g `shur` will match `Shur`
* The order of the keywords matter. e.g. `Wei En` will match `En Wei`
* Only the name is searched.
* Only full words will be matched e.g. `Jiamin` will not match `Jiaming`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Eug ene` will return `Eug in`, `Nal g ene`

Format: `find <NAME> [MORE_KEYWORDS]`

Examples:
* `find John` returns `john` and `John Doe`

### Find contacts by tags: `tag ...`

Find contacts whose attributed tags meet the given keywords.

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="../docs/images/tag-family.png" width="62%">
  </a>

<h5 align="center">Fig 5. Finding contacts with the 'family' tag</h3>
</div>

* The search is case-insensitive. e.g `shurvir` will match `Shurvir`
* Only tags are included in the search, other fields are ignored.

> :bulb: **TIP** Attaching tags to a contact are a way to attach your own meaning to the contact, e.g. Adding the `prof` tag to your professor's contact.

Format: `tag <Keyword> [MORE_KEYWORDS]`

Examples:
* `tag CS2103T` Lists all contacts that have CS2103T tag
* `tag Sheares` Lists all contacts that have Sheares tag

### Delete a contact : `delete ...`

Deletes a contact from the contact list by an index.

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="../docs/images/delete-contact.png" width="62%">
  </a>

<h5 align="center">Fig 5. Delete a contact</h3>
</div>

* Deletes the person at the specified `<index>`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

> :bulb: **TIP** Accidentally deleted the wrong contact? Don't worry checkout our <a href="#undo-a-command">undo</a> function!

Format: `delete <index>`

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the NUSearch database.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### Clear all entries : `clear`

Clears all entries from the NUSearch database.

> :exclamation: **WARNING** This command clears **ALL** contacts in the NUSearch database!
> 
> :bulb: **TIP** Accidentally cleared the database? Don't worry checkout our <a href="#undo-a-command">undo</a> function!

Format: `clear`

### Undo a command : `undo`

Undo a command that was <a href="#delete-a-contact">erroneously</a> keyed in.

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="../docs/images/undo-delete.png" width="62%">
  </a>

<h5 align="center">Fig 5. Undo a delete command</h3>
</div>

> :bulb: **TIP** This function only works if there are commands to undo.

Format: `undo

### Redo a command : `redo`

Redo a command that was <a href="#undo-a-command">erroneously</a> undone.

<div align="center">
  <a href="https://github.com/AY2122S2-CS2103T-W11-4/tp">
    <img src="../docs/images/redo-delete.png" width="62%">
  </a>

<h5 align="center">Fig 5. Undo a delete command</h3>
</div>

> :bulb: **TIP** This function only works if there are commands to redo.
> 
> If a command other than undo and redo are entered, all commands following the inserted command will be cleared and cannot my redid.

Format: `undo`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

NUSearch data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

NUSearch data are saved as a JSON file `[JAR file location]/data/NUSearch.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, NUSearch will discard all data and start with an empty data file at the next run.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous NUSearch home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary
Action | Format, Examples
 --------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com m/CS2103, f/Computing, r/TA`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Favourite** | `fav INDEX`<br> e.g., `fav 3`
**Unfavourite** | `unfav INDEX`<br> e.g., `unfav 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**List Favourites** | `list-fav`
**Help** | `help`

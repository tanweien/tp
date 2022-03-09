package seedu.address.model;

public class AddressBookMemento {
    AddressBook addressBook;

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public AddressBookMemento setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
        return this;
    }
}

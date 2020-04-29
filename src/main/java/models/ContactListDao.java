package models;

import java.util.ArrayList;
import java.util.List;

public class ContactListDao implements Contacts {
    //we need a list variable to hold all of the contacts

    private List<Contact> contacts = new ArrayList<>();

    //list  all the contacts
    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    //method for saving contacts
    //will essentially get the length of List<models.Contact> and + 1
    @Override
    public long saveContact(Contact contact) {
        // check to see if this is the first contact if so add 1
        if (contact.getId() == 0) {
            //if we are setting up a contact that hasnt been assigned an ID
            //(so it must have been constructed using the first last and phone )
            contact.setId(contacts.size() + 1);
            contacts.add(contact);
        } else {
            //we already have the correct ID coming fro the table so lets just set that contact in arrayList(contacts) with the ID that was passed
            contacts.set((int) contact.getId() - 1, contact);
        }
        //return the ID of the newly saved contact
        return contact.getId();

    }

    //method for deleting contacts
    @Override
    public void deleteContactById(long id) {
        //dont need a return value because it is void
        // do a .remove  on ID

        contacts.remove((int) id - 1);
    }

    //method for getting a contact by their id
    @Override
    public Contact getContactById(long id) {
        return contacts.get((int) id - 1);
    }

    public static void main(String[] args) {
Contacts contactDao = new ContactListDao();
        System.out.println("\n=== Testing getContacts()");
        List<Contact> allContacts = contactDao.getContacts();

        for (Contact contact : allContacts){
            System.out.println(contact.getFirstName());
        }
    }
}


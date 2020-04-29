package models;//INTERFACE FOR CONTACT BEAN(to be mpkemented by DAO)

import java.util.List;

public interface Contacts {

    //list  all the contacts
    List<Contact> getContacts();

    //method for saving contacts
    //will essentially get the length of List<models.Contact> and + 1
    long saveContact(Contact contact);
    //method for deleting contacts
    void deleteContactById(long id);

    //method for getting a contact by their id
    Contact getContactById(long id);

}

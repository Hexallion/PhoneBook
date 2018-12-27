/*
PhoneBook Demo Project - By Peter Cresswell

PhoneBook Service

Used to deal with all requests to the application - Logic center
 */

package App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PhoneBookService {
    @Autowired
    ContactRepository contactRepository;

    public List<ContactEntity> getAllContacts(){

        List<ContactEntity> contacts = new ArrayList<>();
        contactRepository.findAll().forEach(contacts::add);

        return contacts;
    }

    public List<ContactEntity> findByForename(String forename){

        List<ContactEntity> contacts = new ArrayList<>();
        contactRepository.findByForename(forename).forEach(contacts::add);

        return contacts;
    }

    /*
    public List<ContactEntity> findByName(String forename, String surname){
        List<ContactEntity> contacts = new ArrayList<>();
        contactRepository.findByName(forename, surname).forEach(contacts::add);

        return  contacts;
    }
    */

    public long addContact(ContactEntity contact){
        long uuid = 1;
        contact.setId(uuid);
        contactRepository.save(contact);
        return uuid;
    }

    public void deleteContact(String id){

        contactRepository.deleteById(id);
    }

    public void updateContact(ContactEntity contact){

        contactRepository.save(contact);
    }
}

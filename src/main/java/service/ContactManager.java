package service;

import dao.ContactRepository;
import model.Contact;
import service.Search.SearchFactory;

import java.util.*;

public class ContactManager {

    private final ContactRepository contactRepository;

    public ContactManager(){
        contactRepository = ContactRepository.getInstance();
    }

    public void addContact(Contact contact){
        contactRepository.addContact(contact);
    }

    public void updateContact(Contact contact){
        contactRepository.updateContact(contact);
    }

    public void removeContact(Contact... contact){
        Arrays.stream(contact).forEach(contactRepository::deleteContact);
    }

    public List<Contact> searchContact(String identifier, String searchType){
        return SearchFactory.getSearchResultsByType(searchType).search(identifier);
    }

    public void updatingFavourite(Contact contact){
        //LRU impl TODO
    }
}

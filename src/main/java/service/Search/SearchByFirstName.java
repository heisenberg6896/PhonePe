package service.Search;

import dao.ContactRepository;
import model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchByFirstName implements Search{

    ContactRepository contactRepository;

    public SearchByFirstName(){
        contactRepository = ContactRepository.getInstance();
    }

    @Override
    public List<Contact> search(String firstName) {
        List<Contact> contacts = contactRepository.getContactFirstName().get(firstName);

        if(Objects.isNull(contacts)){
            contacts = new ArrayList<>();
        }
        return contacts;
    }
}

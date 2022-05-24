package service.Search;

import dao.ContactRepository;
import model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchByLastName implements Search{
    ContactRepository contactRepository;

    public SearchByLastName(){
        contactRepository = ContactRepository.getInstance();
    }

    @Override
    public List<Contact> search(String lastName) {
        List<Contact> contacts = contactRepository.getContactLastName().get(lastName);

        if(Objects.isNull(contacts)){
            contacts = new ArrayList<>();
        }
        return contacts;
    }
}

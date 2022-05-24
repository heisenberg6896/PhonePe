package service.Search;

import dao.ContactRepository;
import model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchByPhoneNumber implements Search{
    ContactRepository contactRepository;

    public SearchByPhoneNumber(){
        contactRepository = ContactRepository.getInstance();
    }

    @Override
    public List<Contact> search(String phone) {
        List<Contact> contacts = contactRepository.getContactPhoneNumber().get(phone);

        if(Objects.isNull(contacts)){
            contacts = new ArrayList<>();
        }
        return contacts;
    }
}

package service.Search;

import model.Contact;

import java.util.List;

public interface Search {
    List<Contact> search(String identifier);
}

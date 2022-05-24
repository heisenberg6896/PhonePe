package service;

import constants.SearchType;
import dao.ContactRepository;
import model.Contact;
import service.Search.SearchFactory;

import java.util.List;

public class DialPadService {

    ContactRepository contactRepository;

    public Contact dialNumber(String number){
        List<Contact> foundContact = SearchFactory.getSearchResultsByType(SearchType.PHONE_NUMBER.name()).search(number);
        if(foundContact.size() != 0){
            //updateFavourites : TODO
            return foundContact.get(0);
        }
        return null;
    }

}

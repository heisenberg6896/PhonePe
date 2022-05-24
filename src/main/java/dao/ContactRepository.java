package dao;

import exception.ContactDoesNotExistsException;
import exception.DuplicateContactExists;
import model.Contact;

import java.util.*;

public class ContactRepository {

    private static volatile ContactRepository obj;
    private final Map<String, List<Contact>> contactFirstName;
    private final Map<String, List<Contact>> contactLastName;
    private final Map<String, List<Contact>> contactPhoneNumber;

    private final Map<String, Contact> contactMap;
    private ContactRepository(){
        contactFirstName = new HashMap<>();
        contactLastName = new HashMap<>();
        contactPhoneNumber = new HashMap<>();
        contactMap = new HashMap<>();
    }

    public static ContactRepository getInstance(){
        if(obj == null){
            synchronized (ContactRepository.class){
                if(obj == null){
                    obj = new ContactRepository();
                }
            }
        }
        return obj;
    }

    public void addContact(Contact contact){
        if(contactFirstName.containsKey(contact.getFirstName()) && contactLastName.containsKey(contact.getLastName()) && contactPhoneNumber.containsKey(contact.getPhone())){
            throw new DuplicateContactExists();
        }
        Contact cloneContact = contact.clone();
        if(Objects.nonNull(contact.getFirstName()))
            contactFirstName.computeIfAbsent(contact.getFirstName(), key -> new ArrayList<>()).add(cloneContact);

        if(Objects.nonNull(contact.getLastName()))
            contactLastName.computeIfAbsent(contact.getLastName(), key -> new ArrayList<>()).add(cloneContact);

        if(Objects.nonNull(contact.getPhone()))
            contactPhoneNumber.computeIfAbsent(contact.getPhone(), key -> new ArrayList<>()).add(cloneContact);
        contactMap.put(contact.getId(), cloneContact);
    }

    public void updateContact(Contact contact){
        if(!contactMap.containsKey(contact.getId())){
           throw new ContactDoesNotExistsException();
        }

        Contact oldContactInfo = contactMap.get(contact.getId());
        if(contactFirstName.containsKey(oldContactInfo.getFirstName())){
            contactFirstName.get(oldContactInfo.getFirstName()).remove(oldContactInfo);
        }
        if(contactLastName.containsKey(oldContactInfo.getLastName())){
            contactLastName.get(oldContactInfo.getLastName()).remove(oldContactInfo);
        }
        if(contactPhoneNumber.containsKey(oldContactInfo.getPhone())){
            contactPhoneNumber.get(oldContactInfo.getPhone()).remove(oldContactInfo);
        }

        addContact(contact);

    }

    public void deleteContact(Contact contact){
        if(!contactMap.containsKey(contact.getId())){
            throw new ContactDoesNotExistsException();
        }
        Contact oldContactInfo = contactMap.get(contact.getId());

        contactFirstName.getOrDefault(oldContactInfo.getFirstName(), new ArrayList<>()).remove(oldContactInfo);
        contactLastName.getOrDefault(oldContactInfo.getLastName(), new ArrayList<>()).remove(oldContactInfo);
        contactPhoneNumber.getOrDefault(oldContactInfo.getPhone(), new ArrayList<>()).remove(oldContactInfo);

        //Delete from Favourite : TODO

    }

    public Map<String, List<Contact>> getContactFirstName() {
        return new HashMap<>(contactFirstName);
    }

    public Map<String, List<Contact>> getContactLastName() {
        return new HashMap<>(contactLastName);
    }

    public Map<String, List<Contact>> getContactPhoneNumber() {
        return new HashMap<>(contactPhoneNumber);
    }

}

import model.Contact;
import service.ContactManager;

public class ContactApplication {
    public static void main(String[] args) {
        Contact contact1 = new Contact("Ashutosh", "Tiwari","999999999");

        Contact contact2 = new Contact("Ashish", "Kumar","000007777");

        Contact contact3 = new Contact("Harshit", "Pandey","1234567890");

        Contact contact4 = new Contact("Yogesh","90099999");

        Contact contact5 = new Contact("Gaurav", "Kumar","888888888", "gk@gmail.com");

        ContactManager contactManager = new ContactManager();
        contactManager.addContact(contact1);
        contactManager.addContact(contact2);
        contactManager.addContact(contact3);
        contactManager.addContact(contact4);
        contactManager.addContact(contact5);

        contact3.setPhone("76567576567");
        contactManager.updateContact(contact3);


        System.out.println(contactManager.searchContact("Kumar", "LAST_NAME"));
//        System.out.println(contactManager.searchContact("Kumar", "EMAIL"));
        contactManager.removeContact(contact4);


    }
}

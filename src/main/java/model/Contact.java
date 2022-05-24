package model;

import java.util.UUID;

public class Contact implements Cloneable {

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    public Contact(String firstName, String phone) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.firstName = firstName;
        this.phone = phone;
    }
    public Contact(String firstName, String lastName, String phone) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;

    }
    public Contact(String firstName, String lastName, String phone, String email) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public String getId(){
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public Contact clone() {
        try {
            Contact clone = (Contact) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

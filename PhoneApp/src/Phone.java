import java.util.ArrayList;

public class Phone {

    /*
       1- Create instance variables
       phoneBrand, phoneModel, SerialNumber, passCode and ArrayList<Contact> allContact
       2- Create constructor to initialize this variables
       3- Create the method to add new contact this method take one parameter as Contact
       4- Create the method to print all Contacts' first and last name with phone number
       5- Create the method to update person's phone number. This method takes two parameter old phone number and new phone number
       6- Create the method to search with phone number and print all other information for person
       7- create the method to search with name of person and print phone number of person
       8- Create the method to update city of person with new city, you need two parameter one is phone number of person another is new email address.
       9- Create the method to update email address for person with new email address, you need two parameter oldEmail and newEmail

       In this contact list only two things are unique Phone number and email address. You can not store same phone number and email address two times
       because of that before adding the new contact you need to make sure this phone number is not exist in your Contact arraylist.
     */

    // Task 1:
    String phoneBrand;
    String phoneModel;
    String serialNumber;
    String passCode;
    ArrayList<Contact> allContacts = new ArrayList<>();


    // Task 2:
    public Phone(String phoneBrand, String phoneModel, String serialNumber, String passCode) {
        this.phoneBrand = phoneBrand;
        this.phoneModel = phoneModel;
        this.serialNumber = serialNumber;
        this.passCode = passCode;
    }


    // Task 3:
    public boolean newContact(Contact contact) {
        for (int i=0; i<allContacts.size(); i++) {
            String currentPhoneNumber = allContacts.get(i).getPhoneNumber();
            String newContactPhoneNumber = contact.getPhoneNumber();
            String currentEmail = allContacts.get(i).getEmail();
            String newContactEmail = contact.getEmail();

            if (currentPhoneNumber.equals(newContactPhoneNumber)) {
                System.out.println("Contact with such phone number is already exists");
                return false;
            }

            if (currentEmail.equals(newContactEmail)) {
                System.out.println("Contact with such email is already exists");
                return false;
            }
        }

        allContacts.add(contact);
        return true;
    }


    // Task 4:
    public void printAllFullNamesWithNumbers() {
        for (int i=0; i<allContacts.size(); i++) {
            String phoneNumber = allContacts.get(i).getPhoneNumber();
            String fullName = getFullName(allContacts.get(i));
            String contactFullNameWithNumber = fullName+": "+phoneNumber;
            System.out.println(contactFullNameWithNumber);
        }
    }

    private String getFullName (Contact contact) {
        String firstName = contact.getFirstName();
        String lastName = contact.getLastName();
        String fullName = firstName+" "+lastName;
        return fullName;
    }


    // Task 5:
    public boolean updatePhoneNumber(String oldPhoneNumber, String newPhoneNumber) {
        for (int i=0; i<allContacts.size(); i++) {
            String currentPhoneNumber = allContacts.get(i).getPhoneNumber();
            if (currentPhoneNumber.equals(newPhoneNumber)) {
                System.out.println("Provided new phone number already being used by other contact");
                return false;
            }
        }

        for (int i=0; i<allContacts.size(); i++) {
            String currentPhoneNumber = allContacts.get(i).getPhoneNumber();
            if (currentPhoneNumber.equals(oldPhoneNumber)) {
                allContacts.get(i).setPhoneNumber(newPhoneNumber);
                return true;
            }
        }
        System.out.println("There is no contact with such phone number");
        return false;
    }


    // Task 6:
    public boolean printByPhoneNumber (String phoneNumber) {
        for (int i=0; i<allContacts.size(); i++) {
            String currentPhoneNumber = allContacts.get(i).getPhoneNumber();
            if (currentPhoneNumber.equals(phoneNumber)) {
                Contact contact = allContacts.get(i);
                System.out.println(contact);
                return true;
            }
        }
        return false;
    }


    // Task 7:
    public boolean printByFirstName (String name) {
        int sameNameContactCount = 0;
        ArrayList<Contact> sameNameContacts= new ArrayList<>();
        for (int i=0; i<allContacts.size(); i++) {
            String currentName = allContacts.get(i).getFirstName();
            if (currentName.equals(name)) {
                Contact contact = allContacts.get(i);
                sameNameContactCount++;
                sameNameContacts.add(contact);
            }
        }

        if (sameNameContactCount == 0){
            return false;
        }

        System.out.println(sameNameContactCount + " contacts found with name "+ name);

        for (int i=0; i<sameNameContacts.size(); ) {
            Contact contact = sameNameContacts.get(i);
            String fullName = getFullName(contact);
            String phoneNumber = contact.getPhoneNumber();
            System.out.println(++i +") "+ fullName+": "+phoneNumber);
        }

        return true;
    }


    // Task 8:
    public boolean updateCityByPhoneNumber(String phoneNumber, String newCity) {
        for (int i=0; i<allContacts.size(); i++) {
            String currentPhoneNumber = allContacts.get(i).getPhoneNumber();
            if (currentPhoneNumber.equals(phoneNumber)) {
                allContacts.get(i).setCity(newCity);
                return true;
            }
        }
        return false;
    }

    public boolean updateCityByEmail(String email, String newCity) {
        for (int i=0; i<allContacts.size(); i++) {
            String currentEmail = allContacts.get(i).getEmail();
            if (currentEmail.equals(email)) {
                allContacts.get(i).setCity(newCity);
                return true;
            }
        }
        return false;
    }


    // Task 9:
    public boolean updateEmail(String oldEmail, String newEmail) {
        for (int i=0; i<allContacts.size(); i++) {
            String currentEmail = allContacts.get(i).getEmail();
            if (currentEmail.equals(newEmail)) {
                System.out.println("Provided new email already being used by other contact");
                return true;
            }
        }

        for (int i=0; i<allContacts.size(); i++) {
            String currentEmail = allContacts.get(i).getEmail();
            if (currentEmail.equals(oldEmail)) {
                allContacts.get(i).setEmail(newEmail);
                return true;
            }
        }
        System.out.println("There is no contact with such phone number");
        return false;
    }
}

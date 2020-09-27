public class Contact {


    /*
    1-  Create the Private instance variables
    firstName, lastName, Company, phoneNumber, emails, city
    2- Create getters and setter for this variables
    3- Create the constructor to initialize your instance variables and constructor must be private
    4- Create one method to instantiate object of contact,
    otherwise since constructor is private you can not instantiate
     */

    // Task 1:
    private String firstName;
    private String lastName;
    private String company;
    private String phoneNumber;
    private String email;
    private String city;

    public static void main(String[] args) {
        System.out.println("redtfyguhijkol"); 
    }

    // Task 2:
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    // Task 3:
    private Contact(String firstName, String lastName, String company, String phoneNumber, String email, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
    }


    //Task 4:
    public static Contact createContact(String firstName, String lastName, String company, String phoneNumber, String email, String city) {
        Contact contact = new Contact(firstName, lastName, company, phoneNumber, email, city);
        return contact;
    }

    @Override
    public String toString() {
        return "First name: " + firstName +
                "\nLast name: " + lastName +
                "\nCompany: " + company +
                "\nEmail: " + email +
                "\nCity: " + city;
    }
}

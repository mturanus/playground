import java.util.Scanner;

public class PhoneAppRunner {

    // in here instantiate the Phone object

    static Phone phone = new Phone("Google","Pixel 2Xl","35803508744476","1570");
    public static void main(String[] args) {
        int attempts =3;
        if (goodPinCode(phone,attempts)) {
            welcome();
            printOptions1();
            Scanner scanner = new Scanner(System.in);
            String option;
            /*
            Implement the logic for passcode.
            You need to first ask the user passcode of the phone
            if the user input is not same with phone.passCode then the user
            should not be able to open the phone and see the below options
             */


            do {
                option=scanner.next();
                makeAChoice(option);
            }while(!option.equals("0"));
        }
        System.out.println("Thank you for working with us");
    }
    private static void makeAChoice(String choice) {
        Scanner input = new Scanner(System.in);
        int count =0;
        int attempts = 3;
        switch (choice) {

            case "1":
                String firstName = goodFirstName(count, attempts);
                if(firstName.isEmpty()){
                    System.out.println("You are out of attempts, new contact was not created");
                    System.out.println();
                    printOptions2();
                    break;
                }

                String lastName = goodLastName(count, attempts);
                if(lastName.isEmpty()){
                    System.out.println("You are out of attempts, new contact was not created");
                    System.out.println();
                    printOptions2();
                    break;
                }

                System.out.print("Please enter company: ");
                String company = input.nextLine();

                String phoneNumber = goodPhoneNumber(count, attempts);
                if(phoneNumber.isEmpty()){
                    System.out.println("You are out of attempts, new contact was not created");
                    System.out.println();
                    printOptions2();
                    break;
                }

                String email = goodEmail(count, attempts);
                if(email.isEmpty()){
                    System.out.println("You are out of attempts, new contact was not created");
                    System.out.println();
                    printOptions2();
                    break;
                }

                System.out.print("Please enter city name: ");
                String city = input.nextLine();
                city = startWithUpperCase(city);

                Contact contact = Contact.createContact(firstName,lastName,company,phoneNumber,email,city);
                if (phone.newContact(contact)){
                    System.out.println("New contact was successfully created");
                    System.out.println();
                    printOptions2();
                    break;
                }

                System.out.println("It was impossible to create new contact");
                System.out.println();
                printOptions2();
                break;
            case "2":
                System.out.println("Your contacts:");
                phone.printAllFullNamesWithNumbers();
                System.out.println();
                printOptions2();
                break;
            case "3":
                System.out.println("Old phone number:");
                String oldPhoneNumber = goodPhoneNumber(count, attempts);
                if(oldPhoneNumber.isEmpty()){
                    System.out.println("You are out of attempts, contact phone number was not updated");
                    System.out.println();
                    printOptions2();
                    break;
                }

                System.out.println("New phone number");
                String newPhoneNumber = goodPhoneNumber(count, attempts);
                if(newPhoneNumber.isEmpty()){
                    System.out.println("You are out of attempts, contact phone number was not updated");
                    System.out.println();
                    printOptions2();
                    break;
                }

                if (phone.updatePhoneNumber(oldPhoneNumber,newPhoneNumber)){
                    System.out.println("Contact phone number was successfully updated");
                    System.out.println();
                    printOptions2();
                    break;
                }

                System.out.println("It was impossible to update contact phone number");
                System.out.println();
                printOptions2();
                break;
            case "4":
                String searchPhoneNumber = goodPhoneNumber(count, attempts);
                if(searchPhoneNumber.isEmpty()){
                    System.out.println("You are out of attempts");
                    System.out.println();
                    printOptions2();
                    break;
                }

                if (phone.printByPhoneNumber(searchPhoneNumber)){
                    System.out.println();
                    printOptions2();
                    break;
                }

                System.out.println("There is no contact with such phone number");
                System.out.println();
                printOptions2();
                break;
            case "5":
                String searchFirstName = goodFirstName(count, attempts);
                if(searchFirstName.isEmpty()){
                    System.out.println("You are out of attempts");
                    System.out.println();
                    printOptions2();
                    break;
                }

                if (phone.printByFirstName(searchFirstName)){
                    System.out.println();
                    printOptions2();
                    break;
                }

                System.out.println("There is no contact with such first name");
                System.out.println();
                printOptions2();
                break;
            case "6":
                String numberOrEmail = goodNumberOrEmail(count, attempts);
                if(numberOrEmail.isEmpty()){
                    System.out.println("You are out of attempts, city was not updated");
                    System.out.println();
                    printOptions2();
                    break;
                }

                System.out.print("Please enter new city name: ");
                String newCity = input.nextLine();
                newCity = startWithUpperCase(newCity);

                if (checkMethod(numberOrEmail,newCity,phone)){
                    System.out.println("Contact city was successfully updated");
                    System.out.println();
                    printOptions2();
                    break;
                }

                System.out.println("There is no contact with such phone number or email");
                System.out.println();
                printOptions2();
                break;
            case "7":
                System.out.println("Old email:");
                String oldEmail = goodEmail(count, attempts);
                if(oldEmail.isEmpty()){
                    System.out.println("You are out of attempts, contact email was not updated");
                    System.out.println();
                    printOptions2();
                    break;
                }

                System.out.println("New email:");
                String newEmail = goodEmail(count, attempts);
                if(newEmail.isEmpty()){
                    System.out.println("You are out of attempts, contact email was not updated");
                    System.out.println();
                    printOptions2();
                    break;
                }

                if (phone.updateEmail(oldEmail,newEmail)){
                    System.out.println("Contact email was successfully updated");
                    System.out.println();
                    printOptions2();
                    break;
                }

                System.out.println("It was impossible to update contact email address");
                System.out.println();
                printOptions2();
                break;
            default:
                System.out.print("Invalid choice, try again (has to be number from 0 to 7): ");
        }


    }

    public static void welcome() {

        System.out.println("Welcome to the Phone Application");
    }

    public static void printOptions1() {

        System.out.println("Hello. Please choose on of the following options");
        System.out.println("1 - For new Contact");
        System.out.println("2 - To print all Contacts' Full Name  and Phone Number");
        System.out.println("3 - Update Contact Phone number");
        System.out.println("4 - Find Person information with Phone Number");
        System.out.println("5 - Find Phone number with Contact Name");
        System.out.println("6 - Update City information for Contact");
        System.out.println("7 - Update Email address information for Contact");
        System.out.println("0 - To exit");
    }

    public static void printOptions2() {

        System.out.println("Please choose on of the following options");
        System.out.println("1 - For new Contact");
        System.out.println("2 - To print all Contacts' Full Name  and Phone Number");
        System.out.println("3 - Update Contact Phone number");
        System.out.println("4 - Find Person information with Phone Number");
        System.out.println("5 - Find Phone number with Contact Name");
        System.out.println("6 - Update City information for Contact");
        System.out.println("7 - Update Email address information for Contact");
        System.out.println("0 - To exit");
    }

    private static boolean goodPinCode(Phone phone,int attempts) {
        String phoneName = phone.phoneBrand+" "+phone.phoneModel;
        System.out.print("Please enter Pin code for your "+phoneName+": ");
        String actualPinCode = phone.passCode;
        int count =0;
        if (checkPinCode(actualPinCode,count,attempts)) {
            return true;
        }
        return false;
    }

    private static boolean checkPinCode(String actualPinCode, int count, int attempts) {
        Scanner in = new Scanner(System.in);
        String expectedPinCode = in.next();

        if(actualPinCode.equals(expectedPinCode)) {
            return true;
        }
        count++;
        if (count<attempts) {
            System.out.print("Wrong Pin code, try again ("+(attempts-count)+" attempts left): ");
            return checkPinCode(actualPinCode,count,attempts);
        }
        System.out.println("Wrong Pin code, you are out of attempts");
        return false;
    }

    private static String goodFirstName(int count, int attempts) {
        count++;

        if (count>attempts)
            return "";

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter first name: ");
        String firstName = in.next();

        if (checkString(firstName)) {
            return startWithUpperCase(firstName);
        }

        System.out.println("Please try again ("+(attempts-count)+" attempts left)");
        return goodFirstName(count, attempts);
    }

    private static boolean checkString(String firstName) {
        for (int i=0; i<firstName.length(); i++) {
            char currentLetter = firstName.charAt(i);
            if (!Character.isLetter(currentLetter)) {
                System.out.println("It can't be something besides letters");
                return  false;
            }
        }

        return true;
    }

    private static String startWithUpperCase (String original) {
        if (original.length()==1) {
            return original.toUpperCase();
        }

        String firstLetter = (""+original.charAt(0)).toUpperCase();
        String other = original.substring(1).toLowerCase();
        String result = firstLetter+other;
        return result;
    }

    private static String goodLastName(int count, int attempts) {
        count++;

        if (count>attempts)
            return "";

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter last name: ");
        String lastName = in.next();

        if (checkString(lastName)) {
            return startWithUpperCase(lastName);
        }

        System.out.println("Please try again ("+(attempts-count)+" attempts left)");
        return goodLastName(count,attempts);
    }

    private static String goodPhoneNumber(int count,int attempts) {
        count++;

        if (count>attempts)
            return "";

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter phone number inclusive area code: ");
        String phoneNumber = in.next();

        if (checkNumber(phoneNumber)) {
            return phoneNumber;
        }

        System.out.println("Please try again ("+(attempts-count)+" attempts left)");
        return goodPhoneNumber(count,attempts);
    }

    private static boolean checkNumber(String phoneNumber) {
        for (int i=0; i<phoneNumber.length(); i++) {
            char currentLetter = phoneNumber.charAt(i);
            if (!Character.isDigit(currentLetter)) {
                System.out.println("It can't be something besides digits");
                return  false;
            }
        }

        if (phoneNumber.length() !=10) {
            System.out.println("Invalid phone number length");
            return false;
        }

        return true;
    }

    private static String goodEmail(int count,int attempts) {
        count++;

        if (count>attempts)
            return "";

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter email address: ");
        String email = in.next();

        if (checkEmail(email)) {
            return email;
        }

        System.out.println("Please try again ("+(attempts-count)+" attempts left)");
        return goodEmail(count,attempts);
    }

    private static boolean checkEmail(String email) {
        if (email.contains(" ")) {
            System.out.println("Invalid email address");
            return false;
        }
        if (email.contains("@")){
            int index1 = email.indexOf("@");
            String temp = email.substring(index1);
            if (temp.contains(".")){
                int index2 = temp.lastIndexOf(".");
                int lastIndex = temp.length()-1;
                if (index2 !=lastIndex) {
                    return true;
                }
            }
        }
        System.out.println("Invalid email address");
        return false;
    }

    private static String goodNumberOrEmail (int count, int attempts) {
        count++;

        if (count>attempts)
            return "";

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter email address or phone number: ");
        String numberOrEmail = in.next();

        if (checkEmail(numberOrEmail)) {
            return numberOrEmail;
        }

        if (checkNumber(numberOrEmail)) {
            return numberOrEmail;
        }

        System.out.println("Please try again ("+(attempts-count)+" attempts left)");
        return goodNumberOrEmail(count,attempts);
    }

    private static boolean checkMethod (String numberOrEmail, String newCity,Phone phone) {
        if (checkNumber(numberOrEmail)) {
            return phone.updateCityByPhoneNumber(numberOrEmail, newCity);
        }

        return phone.updateCityByEmail(numberOrEmail, newCity);
    }
}

package Contact_List_App;

import java.util.Scanner;

/*
    Created by Abhinav Bhardwaj on IntelliJ IDEA
    on   19-02-2020 ,  Time :-    19 : 17
 
 */
public class Main {
    public static void main(String[] args) {

            Scanner obj = new Scanner(System.in);
            Contacts objcontacts = new Contacts();
            String s;
            int n;
            boolean fl = true;
        while (fl) {
            System.out.println("Welcome to DBC's Contact List App  ");
            System.out.println("Press 1 to add a new contact.");
            System.out.println("Press 2 to view all contacts.");
            System.out.println("Press 3 to search for a contact");
            System.out.println("Press 4 to delete a contact");
            System.out.println("Press 5 to exit program");
            n = obj.nextInt();
            if (n == 1) {
                char C;
                String contact = "";
                String C_N;
                String emailadd = "";
                System.out.println("You have chosen to add a new contact:");
                System.out.println("Please enter the name of the Person");
                System.out.print("First Name: ");
                String F = obj.next();
                System.out.print("Last Name: ");
                String L = obj.next();
                System.out.print("Contact Number: ");
                contact = obj.next();
                System.out.print("Would you like to add another contact number? (y/n): ");
                C = obj.next().charAt(0);
                int m = 0;
                while (m == 0) {
                    if (C == 'y') {
                        System.out.print("Contact Number: ");
                        C_N = obj.next();
                        contact = contact + " , " + C_N;
                        System.out.print("Would you like to add another contact number? (y/n): ");
                        C = obj.next().charAt(0);
                        if (C == 'n') {
                            m++;
                        }
                    } else {
                        break;
                    }
                }
                System.out.print("Would you like to add email address? ");
                C = obj.next().charAt(0);
                if (C == 'y') {
                    emailadd = obj.next();
                }
                Person element = new Person(F, L, contact, emailadd);
                objcontacts.addContact(element);
            } else if (n == 2) {
                objcontacts.viewallcontacts();
            } else if (n == 3) {
                System.out.println("You could search for a contact from their first names:");
                s = obj.next();
                objcontacts.search(s);
            } else if (n == 4) {
                System.out.println("Here are all your contacts:");
                objcontacts.listofcontacts();
                System.out.print("Press the number against the contact to delete it:  ");
                int item = obj.nextInt();
                objcontacts.deleteElement(item);
            } else if (n == 5) {
                System.out.println("Thanks for using DBC's Contact List App ");
                fl = false;
            }
        }
    }
}
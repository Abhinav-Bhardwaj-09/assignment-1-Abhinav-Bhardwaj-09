package main;

import java.util.*;
import java.util.regex.Pattern;

import Contact_List_Nodes.*;

/*
    Created by Abhinav Bhardwaj on IntelliJ IDEA
    on   24-02-2020 ,  Time :-    16 : 52
 
 */
public class Main {
    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        Contacts objcontacts = new Contacts();
        String s;
        int n;
        boolean fl = true;
        while (fl) {
            int p =0;
            String e = "";
            System.out.println("Welcome to DBC's Contact List App  ");
            System.out.println("Press 1 to add a new contact.");
            System.out.println("Press 2 to view all contacts.");
            System.out.println("Press 3 to search for a contact");
            System.out.println("Press 4 to delete a contact");
            System.out.println("Press 5 to exit program");
            n = obj.nextInt();
            int k = 0;
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
                if (Pattern.matches("[789]{1}[0-9]{9}", contact)) {
                    System.out.print("Would you like to add another contact number? (y/n): ");
                    C = obj.next().charAt(0);
                    int m = 0;
                    while (m == 0) {
                        if (C == 'y') {
                            System.out.print("Contact Number: ");
                            C_N = obj.next();
                            if (Pattern.matches("[789]{1}[0-9]{9}", C_N)) {
                                contact = contact + " , " + C_N;
                                System.out.print("Would you like to add another contact number? (y/n): ");
                                C = obj.next().charAt(0);
                                if (C == 'n') {
                                    m++;
                                }
                            }
                            else {
                                System.out.println();
                                System.out.println();
                                System.out.println("Try again and enter a valid contact number...");
                                System.out.println();
                                System.out.println();
                                k++;
                                m++;
                                C = 'n';
                            }
                        }
                        else {
                            break;
                        }
                    }
                    if(k == 0) {
                        System.out.print("Would you like to add email address? ");
                        C = obj.next().charAt(0);
                    }
                    if (C == 'y') {
                        while (p == 0) {
                            e = obj.next();
                            if (Pattern.matches("[A-Za-z0-9+_.-]+@(.+)$", e)) {
                                emailadd = emailadd + e;
                                p++;
                            }
                            else {
                                System.out.println("Enter a valid email-id ... ");
                            }
                        }
                    }
                    Person element = new Person(F, L, contact, emailadd);
                    objcontacts.addContact(element);
                }
                else{
                    System.out.println();
                    System.out.println("Try again and enter a valid contact number...");
                    System.out.println();
                    System.out.println();
                }
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
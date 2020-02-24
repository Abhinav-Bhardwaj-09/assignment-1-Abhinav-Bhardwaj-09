package Contact_List_Nodes;
import main.*;

/*
    Created by Abhinav Bhardwaj on IntelliJ IDEA
    on   24-02-2020 ,  Time :-    18 : 00
 
 */
public class Person {
    String First_Name;
    String Last_Name;
    String Contact_Numb;
    String Email;
    Person next ;
    Person previous;

    public Person(String first_Name, String last_Name, String contact_Numb, String email) {
        First_Name = first_Name;
        Last_Name = last_Name;
        Contact_Numb = contact_Numb;
        Email = email;
        next = null;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getContact_Numb() {
        return Contact_Numb;
    }

    public void setContact_Numb(String contact_Numb) {
        Contact_Numb = contact_Numb;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
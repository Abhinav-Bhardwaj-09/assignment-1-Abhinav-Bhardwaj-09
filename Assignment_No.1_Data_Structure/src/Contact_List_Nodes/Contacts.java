package Contact_List_Nodes;
import main.*;
/*
    Created by Abhinav Bhardwaj on IntelliJ IDEA
    on   24-02-2020 ,  Time :-    16 : 51
 
 */
public class Contacts {
    Person front;
    Person rear;
    int count;

    public Contacts() {
        front = null;
        rear = null;
    }


    public void addContact(Person newcontact) {
        if (front == null && rear == null) {
            front = newcontact;
            rear = newcontact;
        }
        else {
            Person temp = front;
            int k = 0;
            if (front == rear) {
                k = newcontact.First_Name.compareToIgnoreCase(temp.First_Name);
                if (k < 0) {
                    newcontact.next = temp;
                    front = newcontact;
                    rear = temp;
                } else {
                    temp.next = newcontact;
                    rear = newcontact;
                    front = temp;
                }
            }
            else {
                Person prev = front;
                Person Rear = front;
                int l = newcontact.First_Name.compareToIgnoreCase(front.First_Name);
                int m = newcontact.First_Name.compareToIgnoreCase(rear.First_Name);
                if ( l < 0){
                    newcontact.next = front;
                    front = newcontact;
                    while (Rear.next!=null){
                        Rear = Rear.next;
                        rear = Rear;
                    }
                }
                else if ( l == 0){
                    newcontact.next = front.next;
                    front.next = newcontact;
                }
                else {
                    temp = front.next;
                    prev = front;
                    if( m >= 0){
                        rear.next = newcontact;
                        rear = newcontact;
                    } else {
                        while (temp != null) {
                            k = newcontact.First_Name.compareToIgnoreCase(temp.First_Name);
                            if (k < 0) {
                                Rear = front;
                                prev.next = newcontact;
                                newcontact.next = temp;
                                while (Rear.next != null) {
                                    Rear = Rear.next;
                                    rear = Rear;
                                }
                                return;
                            }
                            prev = temp;
                            temp = temp.next;
                        }
                    }
                }
            }
        }
    }



    public void search(String p) {
        int c = 0;
        int comma;
        Person temp = front;
        while (temp != null) {
            if (p.equals(temp.First_Name)) {
                c = c + 1;
            }
            temp = temp.next;
        }
        temp = front;
        if (c != 0) {
            while (temp != null) {
                if (p.equals(temp.First_Name)) {
                    comma = 0;
                    for (int i = 0; i < temp.Contact_Numb.length(); i++) {
                        if (temp.Contact_Numb.charAt(i) == ',') {
                            comma++;
                        }
                    }
                    System.out.println(c + " match found!");
                    System.out.println();
                    System.out.println();
                    System.out.println("-------- * -------- * -------- * --------");
                    System.out.println("First Name:  " + temp.First_Name);
                    System.out.println("Last Name:  " + temp.Last_Name);
                    if (comma > 0) {
                        System.out.println("Contact Number( s ):  " + temp.Contact_Numb);
                    } else {
                        System.out.println("Contact Number:  " + temp.Contact_Numb);
                    }
                    System.out.println("Email address:  " + temp.Email);
                    System.out.println();
                    System.out.println("-------- * -------- * -------- * --------");
                }
                temp = temp.next;
            }
        }else {
            System.out.println("NO RESULTS FOUND !");
        }
    }



    public void viewallcontacts() {
        Person temp = front;
        int comma;
        System.out.println("---Here are all your contacts---");

        if (temp == null) {
            System.out.println("Contact List is empty...");
        } else {
            while (temp != null) {
                comma = 0;
                for (int i = 0; i < temp.Contact_Numb.length(); i++) {
                    if (temp.Contact_Numb.charAt(i) == ',') {
                        comma++;
                    }
                }
                System.out.println();
                System.out.println("-------- * -------- * -------- * --------");
                System.out.println("First Name:  " + temp.First_Name);
                System.out.println("Last Name:  " + temp.Last_Name);
                if (comma > 0) {
                    System.out.println("Contact Number(s):  " + temp.Contact_Numb);
                } else {
                    System.out.println("Contact Number:  " + temp.Contact_Numb);
                }
                System.out.println("Email address:  " + temp.Email);
                System.out.println("-------- * -------- * -------- * --------");
                System.out.println();
                temp = temp.next;
            }
        }
    }

    public void listofcontacts(){
        Person f = front ;
        if (f==null){
            System.out.println("Contact List is empty...");
        }
        else {
            count = 0 ;
            while ( f != null ){
                count ++;
                System.out.println( count + ". " + f.First_Name + " " + f.Last_Name );
                f = f.next;
            }
        }
    }

    public void deleteElement(int item){
        int C = 1;
        Person a = front;
        Person previ = front;
        while ( a != null ){
            if (C == item){
                previ.next = a.next;
                System.out.println( a.First_Name + " " + a.Last_Name + "'s contact deleted from list!");
                return;
            }
            else {
                C ++;
            }
            previ = a;
            a = a.next;
        }
    }
}
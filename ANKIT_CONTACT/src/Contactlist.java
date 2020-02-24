import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contactlist {
    List<Person> contactList = new ArrayList<Person>();
    private int top = 0;

    public Contactlist() {
        this.contactList = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        int i = 0;
        Contactlist list = new Contactlist();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("enter 1 to Add new contact");
            System.out.println("enter 2 to View all contact");
            System.out.println("enter 3 for Search for a contact");
            System.out.println("enter 4 for Delete a contact");
            System.out.println("enter 5 fo exit");

            System.out.println("enter your choice");
            try {
                i = sc.nextInt();
            } catch (Exception e) {
                System.out.println("CustomException");
                break;
            }
            switch (i) {
                case 1:
                    list.insertcontact();
                    break;
                case 2:
                    list.viewcontact();
                    break;
                case 3:
                    list.searchcontact();
                    break;
                case 4:
                    list.deletenumber();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID CHOICE");
                    break;
            }
        }
    }

    public void insertcontact() {
        Scanner sc = new Scanner(System.in);
        String FName;
        String LName;
        String eMail;
        String Number;
        System.out.println("First Name:");
        FName = sc.next();
        System.out.println("Last Name:");
        LName = sc.next();
        System.out.println("Email:");
        eMail = sc.next();
        System.out.println("Phone Number:");
        Number = sc.next();
        Contact entry = new Contact(FName, LName, eMail, Number);
        contactList.add(entry);
        top++;
    }

    public void viewcontact() {
        if (top > 0) {
            for (int index = 0; index < top; index++) {
                System.out.println((index + 1) + "> First Name:-" + contactList.get(index).getFName());
                System.out.println("Last Name:-" + contactList.get(index).getLName());
                System.out.println("E-mail:-" + contactList.get(index).geteMail());
                System.out.println("Phone:-" + contactList.get(index).getNumber());
            }
        } else
            System.out.println("contact list is empty");
    }

    public void searchcontact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the searching name");
        String str = sc.next();
        if (top > 0) {
            for (int index = 0; index < top; index++) {
                if (contactList.get(index).getFName().equals(str)) {
                    System.out.println((index + 1) + "> First Name:-" + contactList.get(index).getFName());
                    System.out.println("Last Name:-" + contactList.get(index).getLName());
                    System.out.println("E-mail:-" + contactList.get(index).geteMail());
                    System.out.println("Phone:-" + contactList.get(index).getNumber());
                }
            }
        } else
            System.out.println("contact list empty");
    }

    public void deletenumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter contact name to delete");
        String s = sc.next();
        if (top > 0) {
            for (int index = 0; index < top; index++) {
                if (contactList.get(index).getFName().equals(s)) {
                    contactList.remove(contactList.get(index));
                    top--;
                    System.out.println("contact deleted");
                }
            }
        } else
            System.out.println("contact list is empty");
    }
}



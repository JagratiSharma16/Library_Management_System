
import java.util.*;

public class Allbooks {

    // book theBooks[] = new book[50];
    Book[] thebook = new Book[50];
    public static int count;
    Scanner sc = new Scanner(System.in);

    // Method 1 : Comparing books 
    public int comparebooks(Book b1, Book b2) {
        if (b1.bookname.equalsIgnoreCase(b2.bookname)) {
            System.out.println("Book of this name already exists.");
            return 0;
        }
        if (b1.sno == b2.sno) {
            System.out.println("Book of this Serial number already exists");
            return 0;
        }
        return 1;
    }

    // Method 2 : Adding books
    public void addbooks(Book b) {
        for (int i = 0; i < count; i++) {
            if (this.comparebooks(b, this.thebook[i]) == 0) {
                return;
            }
        }
        if (count < 50) {
            thebook[count] = b;
            count++;
        } else {
            System.out.println("No space to add more books.");
        }
    }

    // Method 3 : Searching books by their serial no.
    public void searchbysno() {

        System.out.println("\t\t\t Search by serial number:");
        int sno;
        System.out.println("Enter the serial number of the book:");
        sno = sc.nextInt();

        int flag = 0;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {
            if (sno == thebook[i].sno) {
                System.out.println(
                        thebook[i].sno + "\t\t"
                        + thebook[i].bookname + "\t\t"
                        + thebook[i].authorname + "\t\t"
                        + thebook[i].bookqtycopy + "\t\t"
                        + thebook[i].bookqty);
                flag++;
                return;
            }
        }
        if (flag == 0) {
            System.out.println("No book for serial number " + sno + " found");
        }
    }

    // Method 4: Search by author name
    public void searchbyauthor() {

        System.out.println("\t\t\t Search by Author name:");
        String authorname;
        System.out.println("Enter Author Name:");
        authorname = sc.nextLine();

        int flag = 0;
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {
            if (authorname.equalsIgnoreCase(thebook[i].authorname)) {
                System.out.println(
                        thebook[i].sno + "\t\t"
                        + thebook[i].bookname + "\t\t"
                        + thebook[i].authorname + "\t\t"
                        + thebook[i].bookqtycopy + "\t\t"
                        + thebook[i].bookqty);
                flag++;
                return;
            }
        }
        if (flag == 0) {
            System.out.println("No book of " + authorname + " found");
        }
    }

    // Method 5: Showing all books
    public void showallbooks() {
        System.out.println("\t\t\tDisplaying All Books");
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    thebook[i].sno + "\t\t"
                    + thebook[i].bookname + "\t\t"
                    + thebook[i].authorname + "\t\t"
                    + thebook[i].bookqtycopy + "\t\t"
                    + thebook[i].bookqty);
        }
    }

    // Method 6: To edit book (update the book quantity)    
    public void updatebookqty() {
        System.out.println("\t\t\tUpdate Book Quantity");
        System.out.println("Enter Serial no. of book: ");
        int sno = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (sno == thebook[i].sno) {
                System.out.println("Enter number of books to be added: ");

                int addingqty = sc.nextInt();
                thebook[i].bookqty += addingqty;
                thebook[i].bookqtycopy += addingqty;

                return;
            }
        }
    }

    // Method 7: displaying all books i.e menu
    public void displayMenu() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println("Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println("Press 0 to Exit Application.");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------");
    }

    // Method 8: To search the availability
    public int isavailable(int sno) {
        // System.out.println("")
        for (int i = 0; i < count; i++) {
            if (sno == thebook[i].sno) {
                if (thebook[i].bookqtycopy > 0) {
                    System.out.println("The book is available.");
                    return i;
                }
                System.out.println("Book is unavailable.");
                return -1;
            }
        }
        System.out.println("No Book of Serial Number " + sno + " Available in Library.");
        return -1;
    }

    // Method 9: Checkout 
    public Book checkOutBook() {
        System.out.println(
                "Enter Serial No of Book to be Checked Out.");
        int sno = sc.nextInt();

        int bookIndex = isavailable(sno);

        if (bookIndex != -1) {
            thebook[bookIndex].bookqtycopy--;
            return thebook[bookIndex];
        }
        return null;
    }

    // Method 10 : Checkin
    public void checkInBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (b.equals(thebook[i])) {
                thebook[i].bookqtycopy++;
                return;
            }
        }
    }
}


import java.util.*;

public class Student {

    String studentname;
    String regnum;

    Book[] borrowedbook = new Book[3];
    public int bookcount = 0;
    Scanner sc = new Scanner(System.in);

    public Student() {
        System.out.println("Enter Student Name: ");
        this.studentname = sc.nextLine();
        System.out.println("Enter Student Registration Number: ");
        this.regnum = sc.nextLine();
    }

    // Borrow a book
    public void borrowBook(Book b) {
        if (bookcount == 3) {
            System.out.println("Cannot borrow more than 3 books.");
            return;
        }
        borrowedbook[bookcount] = b;
        bookcount++;
        System.out.println("Book borrowed successfully: " + b.bookname);
    }

    // Return a book
    public void returnBook(String bookName) {
        for (int i = 0; i < bookcount; i++) {
            if (borrowedbook[i] != null && borrowedbook[i].bookname.equalsIgnoreCase(bookName)) {
                System.out.println("Returned: " + borrowedbook[i].bookname);
                borrowedbook[i] = null;
                // shift remaining books left
                for (int j = i; j < bookcount - 1; j++) {
                    borrowedbook[j] = borrowedbook[j + 1];
                }
                borrowedbook[bookcount - 1] = null;
                bookcount--;
                return;
            }
        }
        System.out.println("Book not found in borrowed list.");
    }

    // Show borrowed books
    public void showBorrowedBooks() {
        if (bookcount == 0) {
            System.out.println("No books borrowed.");
            return;
        }
        System.out.println(studentname + " has borrowed:");
        for (int i = 0; i < bookcount; i++) {
            System.out.println("- " + borrowedbook[i].bookname + " by " + borrowedbook[i].authorname);
        }
    }
}

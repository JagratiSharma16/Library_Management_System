
import java.util.*;

public class Book {

    public int sno;
    public String bookname;
    public String authorname;
    public int bookqty;
    public int bookqtycopy;

    Scanner sc = new Scanner(System.in);

    public Book() {
        System.out.println("Enter the Serial Number: ");
        this.sno = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the Book name: ");
        this.bookname = sc.nextLine();

        System.out.println("Enter the Author name: ");
        this.authorname = sc.nextLine();

        System.out.println("Enter Quantity of books: ");
        this.bookqty = sc.nextInt();
        bookqtycopy = this.bookqty;
    }
}

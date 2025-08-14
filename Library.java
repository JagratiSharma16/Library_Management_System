
import java.util.*;

public class Library {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("******************** Welcome to the Library! ********************");
        System.out.println("                  Select From The Following Options:               ");
        System.out.println("********************************************************************");

        Allbooks bookManager = new Allbooks();
        Allstudents studentManager = new Allstudents();

        int choice;
        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Add Book");
            System.out.println("2. Showsc All Books");
            System.out.println("3. Add Student");
            System.out.println("4. Show All Students");
            System.out.println("5. Student Borrows Book");
            System.out.println("6. Student Returns Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    Book b = new Book();
                    bookManager.addbooks(b);
                    break;

                case 2:
                    bookManager.showallbooks();
                    break;

                case 3:
                    Student s = new Student();
                    studentManager.addStudent(s);
                    break;

                case 4:
                    studentManager.showAllStudents();
                    break;

                case 5:
                    studentManager.checkOutBook(bookManager);
                    break;

                case 6:
                    studentManager.checkInBook(bookManager);
                    break;

                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter between 0 to 6.");
            }
        } while (choice != 0);

        sc.close();
    }
}


import java.util.*;

public class Allstudents {

    Scanner input = new Scanner(System.in);
    Student[] theStudents = new Student[50]; // Array of Student objects
    public static int count = 0; // Number of registered students

    // Add a new student
    public void addStudent(Student s) {
        for (int i = 0; i < count; i++) {
            if (s.regnum.equalsIgnoreCase(theStudents[i].regnum)) {
                System.out.println("Student with Reg Num " + s.regnum + " is already registered.");
                return;
            }
        }
        if (count < 50) {
            theStudents[count] = s;
            count++;
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Cannot add more students. Limit reached.");
        }
    }

    // Show all students
    public void showAllStudents() {
        System.out.println("Student Name\t\tReg Number");
        for (int i = 0; i < count; i++) {
            System.out.println(theStudents[i].studentname + "\t\t" + theStudents[i].regnum);
        }
    }

    // Check if student exists, return index
    public int isStudent() {
        System.out.println("Enter Reg Number:");
        String regnum = input.nextLine();
        for (int i = 0; i < count; i++) {
            if (theStudents[i].regnum.equalsIgnoreCase(regnum)) {
                return i;
            }
        }
        System.out.println("Student is not registered. Get registered first.");
        return -1;
    }

    // Student borrows a book
    public void checkOutBook(Allbooks bookManager) {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            bookManager.showallbooks();
            Book b = bookManager.checkOutBook();
            if (b != null) {
                theStudents[studentIndex].borrowBook(b);
            } else {
                System.out.println("Book is not available.");
            }
        }
    }

    // Student returns a book
    public void checkInBook(Allbooks bookManager) {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            Student s = theStudents[studentIndex];
            s.showBorrowedBooks();
            System.out.println("Enter Book Name to return:");
            String bookName = input.nextLine();
            s.returnBook(bookName);
        }
    }
}

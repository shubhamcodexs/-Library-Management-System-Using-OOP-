import java.util.*;

// Book Class
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void display() {
        System.out.println("ID: " + id + ", Title: " + title +
                ", Author: " + author +
                ", Issued: " + (isIssued ? "Yes" : "No"));
    }
}

// User Class
class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("User ID: " + id + ", Name: " + name);
    }
}

// Library Class
class Library {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    void addBook(Book b) {
        books.add(b);
        System.out.println("Book added!");
    }

    void addUser(User u) {
        users.add(u);
        System.out.println("User added!");
    }

    void viewBooks() {
        for (Book b : books) {
            b.display();
        }
    }

    void viewUsers() {
        for (User u : users) {
            u.display();
        }
    }

    void issueBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued!");
                } else {
                    System.out.println("Already issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    void returnBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned!");
                } else {
                    System.out.println("Book was not issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }
}

// Main Class (ONLY public class)
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n===== Library System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. View Books");
            System.out.println("4. View Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    lib.addBook(new Book(bid, title, author));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    lib.addUser(new User(uid, name));
                    break;

                case 3:
                    lib.viewBooks();
                    break;

                case 4:
                    lib.viewUsers();
                    break;

                case 5:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    lib.issueBook(issueId);
                    break;

                case 6:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    lib.returnBook(returnId);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
import java.util.Scanner;

public class mainLibrary {
    public static void main(String[] args) {
        Book[] book = new Book[3];
        User user = new User(null, 0);
        Scanner scan = new Scanner(System.in);
        Library lib = new Library();

        String[] title = {"Harry Potter", "Lord of the Rings", "Percy Jackson"};
        String[] author = {"J. K. Rowling", "J.R.R. Tolkien", "Rick Riordan"};
        String[] isbn = {"abc123", "def456", "ghi789"};

        for(int i=0; i<title.length; i++){
            book[i] = new Book(title[i], author[i], isbn[i]);
            lib.addBook(book[i]);
        }

        System.out.print("Name: ");
        String name = scan.next();
        System.out.print("Age: ");
        int age = scan.nextInt();
        scan.nextLine();

        lib.displayLibrary();

        System.out.print("Book to borrow: ");
        String buku = scan.nextLine();

        user = new User(name, age);
        user.setBookTitle(buku);

        lib.borrowBook(buku);
        user.displayDetails();

    }
}

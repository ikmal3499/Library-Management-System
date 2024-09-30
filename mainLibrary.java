import java.util.Scanner;

public class mainLibrary {

    public static void populateLibrary(Library lib){
        String[] title = {"Harry Potter", "Lord of the Rings", "Percy Jackson", "Narnia"};
        String[] author = {"J. K. Rowling", "J.R.R. Tolkien", "Rick Riordan", "C. S. Lewis"};
        String[] isbn = {"abc123", "def456", "ghi789", "jkl012"};

        for(int i=0; i<title.length; i++){
            Book book = new Book(title[i], author[i], isbn[i]);
            lib.addBook(book);
        }
    }

    public static void main(String[]args) {
        User user;
        Scanner scan = new Scanner(System.in);
        Library lib = new Library();
        
        int op;
        String buku, returnBuku;

        populateLibrary(lib);

        System.out.println();
        System.out.println("WELCOME TO ONLINE LIBRARY BORROWING SYSYTEM");
        System.out.println("___________________________________________");
        System.out.println();
        System.out.print( "Name: ");
        String name = scan.next();
        System.out.print("Age: ");
        int age = scan.nextInt();
        scan.nextLine();

        user = new User(name, age);

        do{
            
            System.out.println("-------------------------------------------");
            System.out.println("-----------------MAIN MENU-----------------");
            System.out.println("-------------------------------------------");
            System.out.println();
            System.out.println("  1 - Borrow Books");
            System.out.println("  2 - Return Books");
            System.out.println("  3 - Search Books");
            System.out.println("  9 - Exit");
            System.out.println();
            System.out.print("  Type in the number to choose: ");
            op = scan.nextInt();
            scan.nextLine();

            String yn = "yes";

            if(op == 1){
                System.out.println("-------------------------------------------");
                System.out.println("----------------Borrow Book----------------");
                System.out.println();
                while(yn.equalsIgnoreCase("yes")){
                    System.out.print("  Book to borrow: ");
                    buku = scan.nextLine();
                    lib.borrowBook(buku, user);
                    System.out.println();
                    System.out.print("  Would you like to borrow another book? [yes/no]: ");
                    yn = scan.nextLine();
                }
                
            }else if(op == 2){
                System.out.println("-------------------------------------------");
                System.out.println("----------------Return Book----------------");
                System.out.println();
                while(yn.equalsIgnoreCase("yes")){
                    System.out.print("  Book to return: ");
                    returnBuku = scan.nextLine();
                    user.returnBook(returnBuku);
                    System.out.println();
                    System.out.print("  Would you like to return another book? [yes/no]: ");
                    yn = scan.nextLine();
                }
    
            }else if(op == 3){
                System.out.println("-------------------------------------------");
                System.out.println("----------------Search Book----------------");
                System.out.println();
                while(yn.equalsIgnoreCase("yes")){
                    System.out.print("  What book to search: ");
                    String uTitile = scan.nextLine();
                    lib.serachByTitle(uTitile);
                    lib.displayLibrary();
                    System.out.print("  Would you like to search another book? [yes/no]: ");
                    yn = scan.nextLine();
                }
            }

        }while(op != 9);

        user.displayDetails();
        System.out.println();
        System.out.print("  Thank You. Have a nice day :) ");
        System.out.println();
        System.out.println("----------------End of System----------------");
        System.out.println("_____________________________________________");
    }
}

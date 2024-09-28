import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> b = new ArrayList<>();
    LocalDate now = LocalDate.now();

    public void addBook(Book book){
            b.add(book);
    }
    
    public void serachByTitle(String title){
        boolean found =false;
        int i=0;
        while(i<b.size() && !found){
            if (title.equalsIgnoreCase(b.get(i).getTitle())) {
                System.out.println("The book is available");
                found = true;
            }
            i++;
        }
        if(!found){
            System.out.println("\nSorry, the book is not found.");
        }
    }

    public void borrowBook(String userB, User user){
        boolean found =false;
        int i=0;
        while(i<b.size() && !found){
            if (userB.equalsIgnoreCase(b.get(i).getTitle())) {
                if (b.get(i).getIsAvailable()) {
                    b.get(i).setIsAvailable(false);
                    user.updateBook(b.get(i).getTitle());
                    user.updateDate(now);
                    System.out.println("\nYou have successfully borrowed: " + b.get(i).getTitle());
                }else{
                    System.out.println("\nSorry, the book is currently unavailable.");
                }
                found = true;
            }
            i++;
        }
        if(!found){
            System.out.println("\nSorry, the book is not found.");
        }
    }

    public void displayLibrary() {
        System.out.println();
        System.out.println("Available Books in Library");
        for (Book book : b) {
            book.printBookInfo();
        }
        System.out.println();
    }
    
}

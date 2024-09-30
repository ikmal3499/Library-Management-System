import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> b = new ArrayList<>();
    LocalDate now = LocalDate.now();

    //---add books into library
    public void addBook(Book book){
            b.add(book);
    }
    
    //---search book method
    public void serachByTitle(String title){
        boolean found =false;
        int i=0;
        while(i<b.size() && !found){
            if (title.equalsIgnoreCase(b.get(i).getTitle())) {
                if (b.get(i).getIsAvailable()){
                    System.out.println("  The book is available");
                    
                }else{
                    System.out.println("  The book is unavailable");
                }
                found = true;
            }
            i++;
        }
        if(!found){
            System.out.println("  Sorry, the book is not found.");
        }
    }

    //---borrow book method
    public void borrowBook(String userB, User user){
        boolean found =false;
        int i=0;
        while(i<b.size() && !found){
            if (userB.equalsIgnoreCase(b.get(i).getTitle())) {
                if (b.get(i).getIsAvailable()) {
                    b.get(i).setIsAvailable(false);

                    user.updateBook(b.get(i).getTitle());
                    user.updateDate(now);
                    
                    LocalDate DueDate = LocalDate.now().plusDays(14);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM-dd-yyy");
                    String Due = formatter.format(DueDate);

                    System.out.println("  You have successfully borrowed: " + b.get(i).getTitle());
                    System.out.println("                        Due Date: " + Due);
                }else{
                    System.out.println("  Sorry, the book is currently unavailable.");
                }
                found = true;
            }
            i++;
        }
        if(!found){
            System.out.println("  Sorry, the book is not found.");
        }
    }

    //---display list of books in the library
    public void displayLibrary() {
        System.out.println();
        System.out.println("Available Books in Library");
        for (Book book : b) {
            book.printBookInfo();
        }
        System.out.println();
    }
}
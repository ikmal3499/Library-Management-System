import java.util.ArrayList;

public class Library {

    private ArrayList<Book> b = new ArrayList<>();

    Book book = new Book(null, null, null);
    User user = new User(null, 0);

    public void addBook(Book book){
            b.add(book);
    }
    
    // public void displayLibrary(){
    //     for(Book bo: b){
    //         System.err.println("Book : " + bo.getTitle());
    //     }
    // }

    // public void serachByTitle(String title){
    //     for(Book bo: b){
    //         if (user.getBookTitle().equalsIgnoreCase(bo.getTitle())){
                
    //         }
            
    //     }
    // }

    public void borrowBook(String userB){
        for(Book bo: b){
            if (userB.equalsIgnoreCase(bo.getTitle())) {
                System.out.println("The book is available");
                if (book.getIsAvailable()) {
                    book.setIsAvailable(false);
                    user.setBook(bo.getTitle());
                    System.out.println("\nYou have successfully borrowed: " + bo.getTitle());
                    break;
                } else {
                    System.out.println("\nSorry, the book is currently unavailable.");
                    break;
                }
            }else{
                System.out.println("\nSorry, the book is currently unavailable.");
                break;
            }
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

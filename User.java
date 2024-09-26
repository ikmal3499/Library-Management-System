import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private String  bookTitle;
    private String book;
    // ArrayList<String> borrowedBooks = new ArrayList<>();

    

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyy");
    LocalDate now = LocalDate.now().plusDays(14);
    String Date = formatter.format(now);

    //---constructer
    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    //---Getter
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getBookTitle(){
        return bookTitle;
    }

    //---Setter
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setBookTitle(String bookTitle){
        this.bookTitle = bookTitle;
    }
    public void setBook(String book){
        this.book = book;
    }

    //---method
    // public void borrowBook(String bookTitle){
    //     borrowedBooks.add(bookTitle);
    // }

    // public void returnBook(String bookTitle){
    //     for(String b: borrowedBooks){
    //         borrowedBooks.remove(bookTitle);
    //     }
    // }

    // public void checkedOverDueDates(){
    //     for(int i=0; i<borrowedBooks.size(); i++){

    //     }
    // }

    // public void displayDetails(){
    //     System.out.println("User: " + name);
    //     for(int i=0; i<borrowedBooks.size(); i++){
    //         System.out.println("Borrowed " + borrowedBooks.get(i));
    //     }
    //     System.out.println("Due date : " + now);
    // }

    public void displayDetails() {
        System.out.println("\nUser: " + name);
        System.out.println("Borrowed Books: " + bookTitle);
        System.out.println("Due date : " + Date);
        // if (borrowedBooks.size() > 0) {
        //     System.out.println("Borrowed Books: ");
        //     for (String b : borrowedBooks) {
        //         System.out.println("- " + b);
        //     }
        //     System.out.println("Due Date: " + Date);
        // } else {
        //     System.out.println("No borrowed books.");
        // }
    }
}

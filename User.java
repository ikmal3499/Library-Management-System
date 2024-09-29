import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private String  bookTitle;
    ArrayList<String> borrowedBooks = new ArrayList<>();
    ArrayList<LocalDate> borrowedDate = new ArrayList<>();
    ArrayList<LocalDate> borrowedDue = new ArrayList<>();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM-dd-yyy");
    
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
    public String getBook(){
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

    // ---method
    public void updateBook(String bookTitle){
        borrowedBooks.add(bookTitle);
    }

    public void updateDate(LocalDate newDate){
        borrowedDate.add(newDate);
        updateDue();
    }

    public void updateDue(){
        for(int i=0; i<borrowedDate.size(); i++){
            LocalDate due = borrowedDate.get(i).plusDays(14);
            borrowedDue.add(due);
        }
    }

    public void returnBook(String bukuTitle){
        boolean found =false;
        int i=0;
        while(i<borrowedBooks.size() && !found){
            if(bukuTitle.equalsIgnoreCase(borrowedBooks.get(i))){
                found = true;
                
                System.out.println("The book " + borrowedBooks.get(i) + " has been returned");
                borrowedBooks.remove(i);
                checkedOverDueDates(borrowedDate.get(i), borrowedDue.get(i));
                
            }
            i++;
        }
        if(!found){
            System.out.println("The book was not found");
        }
            
    }

    //sambung later
    public void checkedOverDueDates(LocalDate date, LocalDate due){
        boolean found =false;
        int i=0;
        while(i<borrowedDate.size() && !found){
            if(date.compareTo(due)>0){
                System.out.println("This book is overdue");
                
            }else{
                System.out.println("The book have been returned within due");
                
            }
            found = true;
            i++;
        }
        if(!found){
            System.out.println("The book was not found");
        }
           


        // for(int i=0; i<borrowedDate.size(); i++){
        //     if(date.compareTo(due)>0){
        //         System.out.println("This book is overdue");
        //     }else{
        //         System.out.println("The book have been returned within due");
        //     }
        // }
    }

    public void displayDetails() {
        System.out.println("\nUser: " + name);
        if (borrowedBooks.size() > 0){
            System.out.println("Borrowed Books:- ");
            for(int i=0; i<borrowedBooks.size(); i++){
                String book = borrowedBooks.get(i);
                String Due = formatter.format(borrowedDue.get(i));
                String Date = formatter.format(borrowedDate.get(i));
                System.out.println(" - " + book + "   Date borrowed: " + Date + "   Due Date: " + Due);
            }
            
        }else{
            System.out.println("No borrowed books.");
        }
        
    }
}

public class Book {
    private String title;
    private String author;
    private String isbn;
    Boolean isAvailable = true;

    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getIsbn(){
        return isbn;
    }
    public boolean getIsAvailable(){
        return isAvailable;
    } 

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public void printBookInfo(){
        
        System.out.println("Title: " + title + ". Author: " + author + ". ISBN: " + isbn + ". Available: " + isAvailable);
    }

}

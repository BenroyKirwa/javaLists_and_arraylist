import java.util.Date;

public class Book {
    /*
    Create a class called Book, with the following properties
    and Include appropriate constructors, getters, setters:
Int bookId, String bookName, String bookAuthor, int numberOfCopies, Date datePublished
    */
    private int bookId, numberOfCopies;
    private String bookName, bookAuthor;
    private Date datePublished;

    // Creating default constructor
    public Book(){

    }
    // Creating parametized constructor
    public Book(int bookId, String bookName, String bookAuthor, int numberOfCopies, Date datePublished){
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.numberOfCopies = numberOfCopies;
        this.datePublished = datePublished;
    }

    // Creating getter and setter for bookId
    public int getBookId(){
        return bookId;
    }
    public void setBookId(int bookId){
        this.bookId = bookId;
    }
    // Creating getter and setter for bookName
    public String getBookName(){
        return bookName;
    }
    public void setBookName(String bookName){
        this.bookName = bookName;
    }
    // Creating getter and setter for bookAuthor
    public String getBookAuthor(){
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor){
        this.bookAuthor = bookAuthor;
    }
    // Creating getter and setter for numberOfCopies
    public int getNumberOfCopies(){
        return numberOfCopies;
    }
    public void setNumberOfCopies(int numberOfCopies){
        this.numberOfCopies = numberOfCopies;
    }
    // Creating getter and setter for datePublished
    public Date getDatePublished() {
        return datePublished;
    }
    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    // Overriding toString() method for proper object printing
    @Override
    public String toString(){
        return "Book{id=" + bookId + ", name='" + bookName + "', author='" +
                bookAuthor + "', copies=" + numberOfCopies + ", published=" + datePublished + "}";
    }
}
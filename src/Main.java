public class Main {
    public static void main(String[] args){
        BookFunctions bk = new BookFunctions();
        bk.addBook();
//        bk.addBook();
//        bk.displayOrderedBooks();
//        bk.deleteBook();
        for (Book book : bk.books) {
            bk.books.remove(0);
        }
    }
}

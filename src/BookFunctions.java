import java.util.*;
import java.util.stream.Stream;

public class BookFunctions {
    // Creating a List of Strings using ArrayList to store books
    public List<Book> books;

    public BookFunctions(){

        this.books = new ArrayList<>();
    }

    public void addBook(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter book name: ");
        String name = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        System.out.print("Enter number of copies: ");
        int copies = scanner.nextInt();

        // For now, let's use current date
        Date publishDate = new Date();

        // Create new Book object
        Book newBook = new Book(id, name, author, copies, publishDate);

        // Add to list
        books.add(newBook);
        System.out.println("Here are the current books in the library :" + books);
    }
    public Book getBook(){
        System.out.println("Here are the current books in the library :" + books);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which book do you want per index with 0 being the first book? ");
        try {
            int n = scanner.nextInt();
            scanner.close();
            return books.get(n);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index. No book exists at this position.");
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
            return null;
        }
    }
    public void updateBook() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Here are the current books in the library :" + books);
            // Get the book to update
            System.out.println("What book do you want to update starting with 0 as first book?");
            int selectedBook = scanner.nextInt();
            Book bookToUpdate = books.get(selectedBook);

            System.out.println("The menu for updating a book!");
            System.out.println("------------------------------");
            System.out.println("0. Update book ID");
            System.out.println("1. Update book Name");
            System.out.println("2. Update book Author");
            System.out.println("3. Update book Number Of Copies");
            System.out.println("4. Update the Date Published");
            System.out.println("5. Exit");

            System.out.println("What do you want to change? ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 0:
                    System.out.println("What is the new book ID?");
                    int id = scanner.nextInt();
                    bookToUpdate.setBookId(id);
                    break;

                case 1:
                    System.out.println("What is the new book name?");
                    String name = scanner.nextLine();
                    bookToUpdate.setBookName(name);
                    break;

                case 2:
                    System.out.println("What is the new author?");
                    String author = scanner.nextLine();
                    bookToUpdate.setBookAuthor(author);
                    break;

                case 3:
                    System.out.println("What is the new number of copies?");
                    int copies = scanner.nextInt();
                    bookToUpdate.setNumberOfCopies(copies);
                    break;

                case 4:
                    // For now using current date - you might want to add date parsing
                    bookToUpdate.setDatePublished(new Date());
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }

            System.out.println("Book updated successfully!");
            System.out.println("Updated book details: " + bookToUpdate.toString());

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid book index!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid input!");
        }
    }

    public void deleteBook() {
        System.out.println("Here are the current books in the library :" + books);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("HOw do you want to delete the book? ");
            System.out.println("Option 1 is by its index starting form 0");
            System.out.println("Option 2 is by its book name");
            System.out.println("What option do you choose ?");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("What book do you want to delete 0 being the first book ?");
                    int selectedBook = scanner.nextInt();
                    Book bookToDelete = books.remove(selectedBook);
                    System.out.println("Book deleted successfully!");
                    break;
                case 2:
                    System.out.println("What book do you want to delete (state the book name)?");
                    String selectedName = scanner.nextLine();
                    // Find and remove the book with matching name
                    boolean found = books.removeIf(book ->
                            book.getBookName().equalsIgnoreCase(selectedName));

                    if (found) {
                        System.out.println("Book deleted successfully!");
                    } else {
                        System.out.println("No book found with that name!");
                    }
                    break;
                default:
                    System.out.println("Wrong Input !!");
                    break;
            }

        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid book index!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid input!");
        }
    }
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library!");
            return;
        }

        System.out.println("\nBooks available in the library:");
        System.out.println("--------------------------------");

        for (int i = 0; i < books.size(); i++) {
            System.out.println("Book #" + i + ": " + books.get(i));
        }
        System.out.println("--------------------------------");
        System.out.println("Total books: " + books.size());
    }
    public void displayOrderedBooks(){
        System.out.println("The menu for ordering a book!");
        System.out.println("------------------------------");
        System.out.println("0. Order by book ID");
        System.out.println("1. Order by book Name");
        System.out.println("2. Order by book Author");
        System.out.println("3. Order by book Number Of Copies");
        System.out.println("4. Order by the Date Published");
        System.out.println("5. Exit");
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to order by? ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.println("Choose order direction:");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        int direction = scanner.nextInt();

        List<Book> sortedBooks = new ArrayList<>(books); // Create a copy to sort

        switch(choice) {
            case 0:
                books.sort((b1, b2) -> direction == 1 ?
                        b1.getBookId() - b2.getBookId() :
                        b2.getBookId() - b1.getBookId());
                break;
            case 1:
                books.sort((b1, b2) -> direction == 1 ?
                        b1.getBookName().compareTo(b2.getBookName()) :
                        b2.getBookName().compareTo(b1.getBookName()));
                break;
            case 2:
                books.sort((b1, b2) -> direction == 1 ?
                        b1.getBookAuthor().compareTo(b2.getBookAuthor()) :
                        b2.getBookAuthor().compareTo(b1.getBookAuthor()));
                break;
            case 3:
                books.sort((b1, b2) -> direction == 1 ?
                        b1.getNumberOfCopies() - b2.getNumberOfCopies() :
                        b2.getNumberOfCopies() - b1.getNumberOfCopies());
                break;
            case 4:
                books.sort((b1, b2) -> direction == 1 ?
                        b1.getDatePublished().compareTo(b2.getDatePublished()) :
                        b2.getDatePublished().compareTo(b1.getDatePublished()));
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        // Display the sorted books
        System.out.println("\nBooks ordered " + (direction == 1 ? "ascending" : "descending") + ":");
        System.out.println("--------------------------------");
        for (int i = 0; i < sortedBooks.size(); i++) {
            System.out.println("Book #" + i + ": " + sortedBooks.get(i));
        }
        System.out.println("--------------------------------");
        System.out.println("Total books: " + sortedBooks.size());
    }
    public void displayFilteredBooks() {
        if (books.isEmpty()) {
            System.out.println("No books to filter - library is empty!");
            return;
        }

        System.out.println("The menu for filtering books!");
        System.out.println("------------------------------");
        System.out.println("0. Filter by book ID");
        System.out.println("1. Filter by book Name");
        System.out.println("2. Filter by book Author");
        System.out.println("3. Filter by Number Of Copies");
        System.out.println("4. Filter by Date Published");
        System.out.println("5. Exit");

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to filter by? ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch(choice) {
                case 0:
                    System.out.println("Enter book ID to filter by: ");
                    int id = scanner.nextInt();
                    books.stream()
                            .filter(book -> book.getBookId() == id)
                            .forEach(System.out::println);
                    break;

                case 1:
                    System.out.println("Enter book name to filter by: ");
                    String name = scanner.nextLine();
                    books.stream()
                            .filter(book -> book.getBookName().toLowerCase().contains(name.toLowerCase()))
                            .forEach(System.out::println);
                    break;

                case 2:
                    System.out.println("Enter author name to filter by: ");
                    String author = scanner.nextLine();
                    books.stream()
                            .filter(book -> book.getBookAuthor().toLowerCase().contains(author.toLowerCase()))
                            .forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Enter minimum number of copies: ");
                    int copies = scanner.nextInt();
                    books.stream()
                            .filter(book -> book.getNumberOfCopies() >= copies)
                            .forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("Enter date to filter by (current date will be used for demo): ");
                    Date filterDate = new Date(); // You might want to add date parsing here
                    books.stream()
                            .filter(book -> book.getDatePublished().after(filterDate))
                            .forEach(System.out::println);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
                    return;
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid input!");
        }
    }
}

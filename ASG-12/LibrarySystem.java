import library.Book;

public class LibrarySystem {
    public static void main(String[] args) {
        Book book = new Book("BK1023", "Head First Java", "Kathy Sierra", 650.0);
        book.display();
    }
}
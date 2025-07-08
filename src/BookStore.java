import java.util.*;

public class BookStore {
    private Map<String, Book> inventory;
    private static final int CURRENT_YEAR = 2025;

    public BookStore() {
        this.inventory = new HashMap<>();
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added book - " + book.toString());
    }

    public List<Book> removeOutdatedBooks(int yearsThreshold) {
        List<Book> outdatedBooks = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();

            if (book.isOutdated(CURRENT_YEAR, yearsThreshold)) {
                outdatedBooks.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book - " + book.toString());
            }
        }

        return outdatedBooks;
    }

    public PurchaseResult buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);

        if (book == null) {
            return new PurchaseResult(false, 0, "Quantum book store: Book not found with ISBN: " + isbn);
        }

        if (!book.isPurchasable()) {
            return new PurchaseResult(false, 0, "Quantum book store: Book is not available for purchase");
        }

        return book.purchase(quantity, email, address);
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }

    public void listAllBooks() {
        System.out.println("Quantum book store: Current inventory:");
        if (inventory.isEmpty()) {
            System.out.println("Quantum book store: No books in inventory");
            return;
        }

        for (Book book : inventory.values()) {
            System.out.println("Quantum book store: " + book.toString());
        }
    }

    public int getInventorySize() {
        return inventory.size();
    }
}

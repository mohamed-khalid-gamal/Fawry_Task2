public class QuantumBookstoreFullTest {

    public static void main(String[] args) {
        System.out.println("Quantum book store: Starting comprehensive test suite");
        System.out.println("=".repeat(60));

        BookStore store = new BookStore();

        testAddingBooks(store);

        testListingBooks(store);

        testSuccessfulPurchases(store);

        testFailedPurchases(store);

        testRemovingOutdatedBooks(store);

        testFinalInventory(store);

        System.out.println("=".repeat(60));
        System.out.println("Quantum book store: Test suite completed");
    }

    private static void testAddingBooks(BookStore store) {
        System.out.println("\nQuantum book store: TEST 1 - Adding Books");
        System.out.println("-".repeat(40));

        store.addBook(new PaperBook("PB001", "Java Programming", "John Smith", 2020, 45.99, 10));
        store.addBook(new PaperBook("PB002", "Data Structures", "Jane Doe", 2019, 39.99, 5));
        store.addBook(new PaperBook("PB003", "Old Programming Guide", "Bob Wilson", 2015, 29.99, 3));

        store.addBook(new EBook("EB001", "Digital Marketing", "Alice Johnson", 2021, 25.99, "PDF"));
        store.addBook(new EBook("EB002", "Web Development", "Mike Brown", 2022, 35.99, "EPUB"));
        store.addBook(new EBook("EB003", "Ancient Coding Practices", "Old Author", 2010, 19.99, "PDF"));

        store.addBook(new ShowcaseBook("SB001", "Upcoming Novel", "Future Author", 2024, 49.99));
        store.addBook(new ShowcaseBook("SB002", "Demo Book", "Demo Author", 2023, 0.00));
    }

    private static void testListingBooks(BookStore store) {
        System.out.println("\nQuantum book store: TEST 2 - Listing All Books");
        System.out.println("-".repeat(40));
        store.listAllBooks();
    }

    private static void testSuccessfulPurchases(BookStore store) {
        System.out.println("\nQuantum book store: TEST 3 - Successful Purchases");
        System.out.println("-".repeat(40));

        PurchaseResult result1 = store.buyBook("PB001", 2, "customer@email.com", "123 Main St, City");
        System.out.println("Quantum book store: " + result1);

        PurchaseResult result2 = store.buyBook("EB001", 1, "customer@email.com", "456 Oak Ave");
        System.out.println("Quantum book store: " + result2);

        PurchaseResult result3 = store.buyBook("PB002", 3, "another@email.com", "789 Pine Rd, Town");
        System.out.println("Quantum book store: " + result3);
    }

    private static void testFailedPurchases(BookStore store) {
        System.out.println("\nQuantum book store: TEST 4 - Failed Purchase Attempts");
        System.out.println("-".repeat(40));

        // Try to buy non-existent book
        PurchaseResult result1 = store.buyBook("INVALID", 1, "test@email.com", "Test Address");
        System.out.println("Quantum book store: " + result1);

        // Try to buy showcase book
        PurchaseResult result2 = store.buyBook("SB001", 1, "test@email.com", "Test Address");
        System.out.println("Quantum book store: " + result2);

        // Try to buy more than available stock
        PurchaseResult result3 = store.buyBook("PB001", 20, "test@email.com", "Test Address");
        System.out.println("Quantum book store: " + result3);

        // Try to buy with invalid quantity
        PurchaseResult result4 = store.buyBook("EB001", 0, "test@email.com", "Test Address");
        System.out.println("Quantum book store: " + result4);
    }

    private static void testRemovingOutdatedBooks(BookStore store) {
        System.out.println("\nQuantum book store: TEST 5 - Removing Outdated Books");
        System.out.println("-".repeat(40));

        System.out.println("Quantum book store: Removing books older than 10 years...");
        var outdatedBooks = store.removeOutdatedBooks(10);

        System.out.println("Quantum book store: Removing books older than 5 years...");
        outdatedBooks.addAll(store.removeOutdatedBooks(5));

        if (outdatedBooks.isEmpty()) {
            System.out.println("Quantum book store: No outdated books found");
        } else {
            System.out.println("Quantum book store: Total outdated books removed: " + outdatedBooks.size());
        }
    }

    private static void testFinalInventory(BookStore store) {
        System.out.println("\nQuantum book store: TEST 6 - Final Inventory Check");
        System.out.println("-".repeat(40));

        System.out.println("Quantum book store: Books remaining in inventory: " + store.getInventorySize());
        store.listAllBooks();

        Book book = store.getBook("PB001");
        if (book != null && book instanceof PaperBook) {
            PaperBook paperBook = (PaperBook) book;
            System.out.println("Quantum book store: PB001 remaining stock: " + paperBook.getStock());
        }

        book = store.getBook("PB002");
        if (book != null && book instanceof PaperBook) {
            PaperBook paperBook = (PaperBook) book;
            System.out.println("Quantum book store: PB002 remaining stock: " + paperBook.getStock());
        }
    }
}


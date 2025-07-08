public class MailService {
    public static void sendEBook(EBook book, int quantity, String email) {
        System.out.println(String.format("Quantum book store: Sending %d copy(ies) of '%s' (%s) to email: %s",
                                        quantity, book.getTitle(), book.getFileType(), email));
    }
}


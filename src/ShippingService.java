public class ShippingService {

    public static void ship(PaperBook book, int quantity, String address) {
        System.out.println(String.format("Quantum book store: Shipping %d copy(ies) of '%s' to address: %s",
                                        quantity, book.getTitle(), address));
    }
}


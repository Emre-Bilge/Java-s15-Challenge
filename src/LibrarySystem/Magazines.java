package LibrarySystem;

import java.util.Date;

public class Magazines extends Book{

    public Magazines(int bookId, String author, String name, double price, String edition, Date dateOfPurchase) {
        super(bookId, author, name, price, edition, dateOfPurchase);
    }
}

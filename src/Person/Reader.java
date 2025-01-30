package Person;


import ENUMS.BookStatus;
import LibrarySystem.Book;
import Member.MemberRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reader extends Person{
    private final int bookLimit = 5   ;
    private List<Book> borrowedBooks;
    private int readerID;
    private LocalDate currentDate ;
    private MemberRecord memberRecord; // bunu ekledim reader bir member mı dıye kontrol edeceğim.


    public Reader(String name,MemberRecord memberRecord) {
        super(name);
        this.borrowedBooks = new ArrayList<>();
        this.memberRecord=memberRecord;
    }

    public MemberRecord getMemberRecord() {
        return memberRecord;
    }

    public boolean isMember() {
        return memberRecord != null;
    }

    public int getBookLimit() {
        return bookLimit;

    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);

    }

public int getReaderId(){
        return this.readerID;
}


    public void purchaseBook(Book book) {
        if (book == null) {
            System.out.println("Geçersiz kitap nesnesi.");
            return;
        }
        System.out.println(name + " tarafından satın alınan kitap: " + book.getTitle());
    }

    public void borrowBook(Book book) {

        if (book.getStatus() == BookStatus.AVAILABLE) {
            if (borrowedBooks.size() < bookLimit) {
                borrowedBooks.add(book);
                book.setStatus(BookStatus.BORROWED); // Kitap durumu kalıcı olarak BORROWED yapılıyor
                System.out.println(name + " kişisi tarafından ödünç alınan kitap: " + book);
                currentDate = LocalDate.now();

            } else {
                System.out.println(name + " kişisi kitap limitine ulaştı yeni kitap alamaz.");
            }
        } else {
            System.out.println("Kitap ödünç alınamaz. Mevcut durum: " + book.getStatus());
        }
    }
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book); // Kitap listeden çıkarılır.
            book.setStatus(BookStatus.AVAILABLE); // kitabın statusu değiştirildi artık library içinde
            System.out.println(name + " tarafından kitap iade edildi: " + book);
        } else {
            System.out.println(book + "Kitap zaten listede mevcut!");
        }

    }

    public void showBook() {
        if(borrowedBooks == null || borrowedBooks.isEmpty()){
     System.out.println(name + " kullanıcının ödünç aldığı kitap bulunmamaktadır.");
     return ;
}
        Iterator<Book> iter = borrowedBooks.iterator();

        while(iter.hasNext()){
            System.out.println(name + "İsimli tarafından ödünç alınan kitaplar : " + iter.next());
        }
/*   --------------------->>>  istersek foreach ile de dönebiliriz Iterator yerine .

    borrowedBooks.forEach(book ->
        System.out.println(name + " isimli kişi tarafından ödünç alınan kitap: " + book)
    );
}
        */
    }

    @Override
    public String whoYouAre() {
       return ("ben  bir okuyucuyum : " + name);
    }
}

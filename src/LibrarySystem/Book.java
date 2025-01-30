package LibrarySystem;


import ENUMS.BookStatus;
import Person.Reader;

import java.util.Date;
import java.util.Objects;

public class Book {
    private int bookId;
    private String author ;
    private String name ;
    private double price;
    private BookStatus status;
    private String edition;
    private Date dateOfPurchase;



    public Book(int bookId, String author, String name,
                double price,  String edition, Date dateOfPurchase) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = BookStatus.AVAILABLE;// default olarak böyle olsun .
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;         // yazarı burada dönuyorum .
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public BookStatus getStatus() {
        return status;
    }

    public String getEdition() {
        return edition;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getTitle(){
        return this.name;  // kitap başlığı isim olarak aldım . ***********
    }

    public String getOwner(Book book ,Reader reader) {
        if (reader.getBorrowedBooks().contains(book)) {
            return reader.getName(); // persondaki getterden kimde olduğunu anlıyorum kitapın.**********
        } else {
            return "kitap bu okuyucuda değil.";
        }
    }
    public void changeOwner(Book book,Reader reader) {
        if (book.getStatus() == BookStatus.AVAILABLE && reader.getBookLimit() <= 5) {
            book.setStatus(BookStatus.BORROWED);
            reader.borrowBook(book); // readerdeki methoda atama yaptım
            System.out.println(reader.getName() + " adlı kişi " + book.getTitle() + " kitabını ödünç aldı.");
        } else {
            System.out.println("Kitap şu anda işlem için uygun değil.");
        }
    }              // ***************************

public String updateStatus(Book book , Reader reader){
        if(!reader.getBorrowedBooks().contains(book)){
           book.setStatus(BookStatus.AVAILABLE);
            System.out.println(book +" adlı kitabın statüsü güncellenmiştir.");
        }
      else {
          book.setStatus(BookStatus.BORROWED);
        }
return book +" adlı kitabın statusu guncellenmıstır." ;
     /*   if(reader.getBorrowedBooks().contains(book)){
            book.setStatus(BookStatus.BORROWED);
            System.out.println(reader.getName() + "adlı kullanıcıda " + book + " adlı kitap mevcut");
        }else if(reader.returnBook(book)){
            book.setStatus(BookStatus.AVAILABLE);
            System.out.println(reader.getName() + "adlı kullanıcı "+ book + "kitabını teslim etti.");
        }*/
} //*************************

    public String display() {
        StringBuilder text = new StringBuilder();

        text.append("bookID: ").append(bookId).append("\n");
        text.append("Author: ").append(author).append("\n");
        text.append("Name: ").append(name).append("\n");
        text.append("Price: ").append(price).append("\n");
        text.append("Status: ").append(status).append("\n");
        text.append("Edition: ").append(edition).append("\n");
        text.append("Date of Purchasing: ").append(dateOfPurchase).append("\n");

        return text.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && Double.compare(price, book.price) == 0 && Objects.equals(author, book.author) && Objects.equals(name, book.name) && status == book.status && Objects.equals(edition, book.edition) && Objects.equals(dateOfPurchase, book.dateOfPurchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, author, name, price, status, edition, dateOfPurchase);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition='" + edition + '\'' +
                ", dateOfPurchase=" + dateOfPurchase +
                '}';
    }
}



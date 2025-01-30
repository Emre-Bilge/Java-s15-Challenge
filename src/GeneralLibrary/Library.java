package GeneralLibrary;

import ENUMS.BookStatus;
import LibrarySystem.Book;
import Person.Reader;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Library {

    private Map<Integer, Book> books;
    private Map<Integer, Reader> readers;

    public Library() {
      this.books = new HashMap<>();
      this.readers=new HashMap<>();
    }

    public Map<Integer, Book> getBooks() {
        return new HashMap<>(books);
    }

    public Map<Integer, Reader> getReaders() {
        return new HashMap<>(readers) ;
    }
    public Map<Integer,Book> newBook(Book book){
   if(book == null ) {
       throw new IllegalArgumentException("Kitap nesnesi null olamaz.");
   }
   if(books.containsKey(book.getBookId())){
       throw new IllegalArgumentException("Bu kitap ID'si zaten kullanılıyor.");
   }
   books.put(book.getBookId(),book);
   return books;
    }
public void lendBook(Book book , Reader reader) {
    if (book == null || reader == null) {
        throw new IllegalArgumentException("kitap veya üyeik bilgisi bulunamadı.");
    }
    if (!books.containsKey(book.getBookId())) {
        throw new IllegalArgumentException("böyle bir kitap yok");
    }

    if (books.get(book.getBookId()).getStatus() == BookStatus.BORROWED) {
        //if(book.getStatus() == BookStatus.BORROWED){
        throw new IllegalArgumentException("bu kitap ödünç alınmıştır şu an da mevcut değil");
    }
    if (reader.getBorrowedBooks().size() >= reader.getBookLimit()) {
        throw new IllegalArgumentException(reader.getName() + "adlı kullanıcı limit kitap ulaşmıştır.");
    }
    if (reader.getBorrowedBooks().size() < reader.getBookLimit() && books.get(book.getBookId()).getStatus() == BookStatus.AVAILABLE) {
        System.out.println("kullanıcı kitabı ödünç alabilir.");
        reader.getBorrowedBooks().add(book);
        books.get(book.getBookId()).setStatus(BookStatus.BORROWED);
        //books.remove(book.getBookId()); ---> listeden tamamen cıkartmak ıstemedıgım ıcın sildim.
    }
}

public Map<Integer,Book> takeBackBook(Book book , Reader reader){

        if(book != null && reader != null){
            // books.put(book.getBookId(),book); ----> yeni kitap eklenmediği için buna gerek yok yani asıl listeden kaldırmıyorum .
            books.get(book.getBookId()).setStatus(BookStatus.AVAILABLE);
            reader.getBorrowedBooks().remove(book);
        }
        return books;
}

public void showBooks(){
        for(Map.Entry<Integer,Book> entry : books.entrySet()){
            System.out.println("Kitap ID : " + entry.getKey() + "kitap ismi : " + entry.getValue().getTitle());
        }
}

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readers=" + readers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(books, library.books) && Objects.equals(readers, library.readers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, readers);
    }
}

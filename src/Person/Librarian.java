package Person;


import ENUMS.BookStatus;
import LibrarySystem.Book;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import GeneralLibrary.Library;


public class Librarian {
    private String name ;
    private String password;
    final double DAILY_FINE_RATE = 1.0;
    private Library library;


    public Librarian(String name, String password,Library library) {
        this.name = name;
        this.password = password;
        this.library=library;
    }
    public Librarian(String name, String password){
        this.name = name;
        this.password = password;
    }

    public void searchBook(int bookId){
        Book book = library.getBooks().get(bookId);
        if (book != null) {
            System.out.println("Kitap bulundu: " + book);
        } else {
            System.out.println("Bu ID'ye sahip kitap bulunamadı.");
        }
    }
    public void verifyMember(Reader reader){
if(reader.isMember()){
    System.out.println(reader.getName() + " kayıtlı bir üyemizdir kitap alabilir ");
}else{
   throw new IllegalArgumentException (reader.getName()+ "kayıtlı üye değildir");
}
    }

    public void issueBook(Reader reader,Book book){
        if(book.getStatus()== BookStatus.AVAILABLE && reader.isMember() ){
            reader.borrowBook(book);
        }
        else{
            System.out.println("kitap statusu available değildir.");
        }

    }
    public double calculateFine(Reader reader) {

        LocalDate currentDate = LocalDate.now();
        LocalDate borrowDate = reader.getCurrentDate();
        long daysLate = ChronoUnit.DAYS.between(borrowDate, currentDate); // iki tarih arasındaki fark gün olarak .
        double fine = 0.0;
        if (daysLate > 15) { // ceza olması ıcın 15 gun kabul ettım .
            fine = (daysLate - 15) * DAILY_FINE_RATE;
        } else {
            System.out.println("Geçikme olmadığı için cezası yoktur.");
        }

        return fine;
    }

    public double createBill(Book book,Reader reader){
        double billAmount = 0 ;
        if(!reader.getBorrowedBooks().contains(book)){
            System.out.println(reader.getName() + " adlı üyede kayıtlı değil");
        }else {
            System.out.println(reader.getName() + " adlı üyeye " + book.getPrice()+calculateFine(reader) +" ücreti kadar fatura kesilmiştir.");
            billAmount = book.getPrice()+calculateFine(reader);
        }
       return billAmount ;

    }
    public void returnBook(Reader reader , Book book){
    reader.returnBook(book);

    }

}

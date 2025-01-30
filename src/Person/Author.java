package Person;



import LibrarySystem.Book;

import java.util.ArrayList;
import java.util.List;

class Author extends Person{

private List<Book> writtenBooks ;

    public Author(String name) {
        super(name);
        this.writtenBooks = new ArrayList<>();
    }

    public void newBook(Book book){
        if(!writtenBooks.contains(book)) {

            writtenBooks.add(book);
            System.out.println(name + " yazarın kitabı listeye eklendi" + book);
        }else{
            System.out.println("Sistemde kitap mevcut : " + book);
        }
    }

    public List<Book> showBook(){
        if( writtenBooks != null && !writtenBooks.isEmpty() ) {
    return writtenBooks;
        }else {
            System.out.println("yazarın kitabı yok");
        }
    return new ArrayList<>() ;
    }

    @Override
    public String whoYouAre() {
        return "ben yazarım adım : "+ name;
    }
}

package br.edu.ifsp.arq.tsi.deoo.controller;

import br.edu.ifsp.arq.tsi.deoo.model.Book;
import br.edu.ifsp.arq.tsi.deoo.model.dao.BookDao;
import br.edu.ifsp.arq.tsi.deoo.model.dao.BookDaoImpl;
import br.edu.ifsp.arq.tsi.deoo.view.UserView;

import java.util.Set;

public class BookController {

    private BookDao bookDao;
    private UserView view;

    Set<Book> books = bookDao.getAll();

    public BookController(UserView view) {
        this.view = view;
        bookDao = BookDaoImpl.getInstance();
    }

    public boolean registerBook(Book book) {
        if(bookDao.findBookById(book.getId()) == null) {
            bookDao.insertBook(book);
            return true;
        }
        return false;
    }

    public void allBooks() {
        for(Book book : books) {
            view.showBook(book);
        }
    }

    public void lentBooks() {
        for (Book book : books) {
            if(book.getLentTimes() > 0) {
                view.showLentBook(book);
            }
        }
    }

    private void load() {
        bookDao.insertBook(new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", "1st Edition"));
        bookDao.insertBook(new Book("The Pragmatic Programmer: Your Journey to Mastery", "Andrew Hunt, David Thomas", "2nd Edition"));
        bookDao.insertBook(new Book("Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1st Edition"));
        bookDao.insertBook(new Book("Cracking the Coding Interview: 189 Programming Questions and Solutions", "Gayle Laakmann McDowell", "6th Edition"));
        bookDao.insertBook(new Book("Introduction to Algorithms", "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein", "3rd Edition"));
    }
}

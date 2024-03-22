package br.edu.ifsp.arq.tsi.deoo.controller;

import br.edu.ifsp.arq.tsi.deoo.model.Book;
import br.edu.ifsp.arq.tsi.deoo.model.dao.BookDao;
import br.edu.ifsp.arq.tsi.deoo.model.dao.BookDaoImpl;
import br.edu.ifsp.arq.tsi.deoo.view.UserView;

import java.util.Iterator;
import java.util.Set;

public class BookController {

    private BookDao bookDao;
    private UserView view;

    public BookController(UserView view) {
        this.view = view;
        bookDao = new BookDaoImpl.getInstance();
    }

    public boolean registerBook(Book book) {
        if(bookDao.findById(book.getId()) == null) {
            bookDao.insert(book);
            return true;
        }
        return false;
    }

    public void allBooks() {
        Book book;
        Iterator<Book> iterator = bookDao.getAll().iterator();
        while(iterator.hasNext()) {
            book = iterator.next();
            view.showAllBooks();
        }
    }

    public void lentBooks() {
        Book book;
        Iterator<Book> iterator = bookDao.getAll().iterator();
        while(iterator.hasNext()) {
            book = iterator.next();
            if(!bookDao.isAvailable()) {
                view.showLentBooks();
            }
        }
    }

    public void bookLentQuantity() {
        Book book;
        Iterator<Book> iterator = bookDao.getAll().iterator();
        while(iterator.hasNext()) {
            book = iterator.next();
            if(book.getLentTimes() > 0) {
                view.showBookLentQuantity();
            }
        }
    }
}

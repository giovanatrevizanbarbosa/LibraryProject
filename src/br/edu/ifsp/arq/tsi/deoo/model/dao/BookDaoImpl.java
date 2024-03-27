package br.edu.ifsp.arq.tsi.deoo.model.dao;

import br.edu.ifsp.arq.tsi.deoo.model.Book;

import java.util.HashSet;
import java.util.Set;

public class BookDaoImpl implements BookDao {
    private static BookDaoImpl instance;
    private Set<Book> books;

    private BookDaoImpl(){
        books = new HashSet<>();
    }

    public static BookDaoImpl getInstance(){
        if(instance == null) instance = new BookDaoImpl();
        return instance;
    }
    
    @Override
    public Set<Book> getAll() {
        return books;
    }

    @Override
    public Book findBookById(int id) {
        for(Book b : books){
            if(b.getId() == id) return b;
        }
        return null;
    }

    @Override
    public boolean insertBook(Book book) {
        for (Book b : books){
            if(b.equals(book)) return false;
        }
        return books.add(book);
    }

    @Override
    public boolean deleteBook(int id) {
        for (Book b : books){
            if(b.equals(b)) books.remove(b);
            return true;
        }
        return false;
    }
}
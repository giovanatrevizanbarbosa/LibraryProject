package br.edu.ifsp.arq.tsi.deoo.model;

import br.edu.ifsp.arq.tsi.deoo.model.dao.BookDao;

public class Book implements BookDao {
    @Override
    public Set<Book> getAll() {
        return null;
    }

    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public boolean insert(Book book) {
        return false;
    }

    @Override
    public boolean update(Book currentBook, Book newBook) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}

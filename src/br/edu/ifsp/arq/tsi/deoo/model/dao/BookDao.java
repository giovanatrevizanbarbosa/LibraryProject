package br.edu.ifsp.arq.tsi.deoo.model.dao;

import br.edu.ifsp.arq.tsi.deoo.model.Book;

public interface BookDao {
    Set<Book> getAll();

    Book findById(int id);

    boolean insert(Book book);

    boolean update(Book currentBook, Book newBook);

    boolean delete(int id);
}
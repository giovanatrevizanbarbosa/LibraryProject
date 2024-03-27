package br.edu.ifsp.arq.tsi.deoo.model.dao;

import java.util.Set;

import br.edu.ifsp.arq.tsi.deoo.model.Book;

public interface BookDao {
    Set<Book> getAll();

    Book findBookById(int id);

    boolean insertBook(Book book);

    boolean deleteBook(int id);
}
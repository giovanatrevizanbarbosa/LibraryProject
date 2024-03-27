package br.edu.ifsp.arq.tsi.deoo.view;

import br.edu.ifsp.arq.tsi.deoo.model.Book;
import br.edu.ifsp.arq.tsi.deoo.model.Loan;
import br.edu.ifsp.arq.tsi.deoo.model.User;

public interface UserView {
    void showBook(Book book);

    void showLentBook(Book book);

    void showLoan(Loan loan, String returnDate);

    void showLateLoan(Loan loan, String returnDate);

    void showUser(User user);

    void showUsersWithLentBook(User user);

    void showUsersServingPenalty(User user);
}

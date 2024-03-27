package br.edu.ifsp.arq.tsi.deoo.view;

import br.edu.ifsp.arq.tsi.deoo.model.Book;
import br.edu.ifsp.arq.tsi.deoo.model.Loan;
import br.edu.ifsp.arq.tsi.deoo.model.User;

public class ConsoleView implements UserView {
    @Override
    public void showBook(Book book) {
        System.out.println("\t>>> Book " + book.getId() + " <<<");
        System.out.println("Title......: " + book.getTitle());
        System.out.println("Author.....: " + book.getAuthor());
        System.out.println("Edition....: " + book.getEdition());
        System.out.println("Available..: " + (book.isAvailable() ? "Yes" : "No"));
        System.out.println("Times Lent.: " + book.getLentTimes());
        System.out.println("*****************************");
    }

    @Override
    public void showLentBook(Book book) {
        // System.out.println("\t>>> Lent Book " + book.getId() + " <<<");
        showBook(book);
    }

    @Override
    public void showLoan(Loan loan, String returnDate) {
        System.out.println("\t>>> Loan " + loan.getUser().getName() + ", " + loan.getBook().getTitle() + " <<<");
        System.out.println("Book Title..: " + loan.getBook().getTitle());
        System.out.println("User Name...: " + loan.getUser().getName());
        System.out.println("Return Date.: " + returnDate);
        System.out.println("Late Days...: " + loan.getLateDays());
        System.out.println("*****************************");
        
    }

    @Override
    public void showLateLoan(Loan loan, String returnDate) {
        // System.out.println("\t>>> Late Loans <<<");
        showLoan(loan, returnDate);
    }

    @Override
    public void showUser(User user) {
        System.out.println("\t>>> User " + user.getId() + " <<<");
        System.out.println("Name..........: " + user.getName());
        System.out.println("Email.........: " + user.getEmail());
        System.out.println("Phone Number..: " + user.getPhoneNumber());
        System.out.println("Penalty.......: " + (user.hasPenalty() ? "Yes" : "No"));
        System.out.println("Lent Books....: " + user.getLentBooks().size());
        System.out.println("*****************************");
    }

    @Override
    public void showUsersWithLentBook(User user) {
        // System.out.println("\t>>> Users With Lent Books <<<");
        showUser(user);
    }

    @Override
    public void showUsersServingPenalty(User user) {
        // System.out.println("\t>>> Users Serving Penalties <<<");
        showUser(user);
    }
}

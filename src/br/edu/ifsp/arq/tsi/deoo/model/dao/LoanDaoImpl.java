package br.edu.ifsp.arq.tsi.deoo.model.dao;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.arq.tsi.deoo.model.Book;
import br.edu.ifsp.arq.tsi.deoo.model.Loan;
import br.edu.ifsp.arq.tsi.deoo.model.User;

public class LoanDaoImpl implements LoanDao {
    private static LoanDaoImpl instance;
    private Set<Loan> loans;

    UserDao userDao;
    BookDao bookDao;

    public static LoanDao getInstance(){
        if(instance == null) instance = new LoanDaoImpl();
        return instance;
    }

    private LoanDaoImpl(){
        loans = new HashSet<>();
        userDao = UserDaoImpl.getInstance();
        bookDao = BookDaoImpl.getInstance();
    }

    @Override
    public Loan findLoanById(int loanId) {
        for(Loan loan : loans){
            if(loan.getId() == loanId) 
                return loan;
        }
        return null;
    }

    @Override
    public Set<Loan> getAll() {
        return loans;
    }

    @Override
    public boolean isLate(Loan loan) {
        return loan.getLateDays() >= 1;
    }

    @Override
    public boolean rentBook(int bookId, int userId) {
        Book book = bookDao.findBookById(bookId);
        User user = userDao.findUserById(userId);
        
        if (book != null && user != null && book.isAvailable()) {
            Loan loan = new Loan(book, user);
            loans.add(loan);
            book.setAvailable(false);
            return true;
        }

        return false;
    }

    @Override
    public boolean returnBook(int bookId, int userId) {
        Loan loanToRemove = null;
        for (Loan loan : loans) {
            if (loan.getBook().getId() == bookId && loan.getUser().getId() == userId) {
                loanToRemove = loan;
                break;
            }
        }

        if (loanToRemove != null) {
            loans.remove(loanToRemove);
            loanToRemove.getBook().setAvailable(true);
            return true;
        }

        return false;
    }
}

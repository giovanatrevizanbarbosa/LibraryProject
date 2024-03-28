package br.edu.ifsp.arq.tsi.deoo.controller;

import java.time.format.DateTimeFormatter;
import java.util.Set;

import br.edu.ifsp.arq.tsi.deoo.model.Book;
import br.edu.ifsp.arq.tsi.deoo.model.Loan;
import br.edu.ifsp.arq.tsi.deoo.model.User;
import br.edu.ifsp.arq.tsi.deoo.model.dao.LoanDao;
import br.edu.ifsp.arq.tsi.deoo.model.dao.LoanDaoImpl;
import br.edu.ifsp.arq.tsi.deoo.view.UserView;

public class LoanController {

    private LoanDao loanDao;
    private UserView view;

    Set<Loan> loans = loanDao.getAll();
    
    public LoanController(UserView view) {
        this.view = view;
        loanDao = LoanDaoImpl.getInstance();
    }

    public boolean createLoan(Book book, User user) {
        if(book.isAvailable() && !user.hasPenalty()) {
            loanDao.rentBook(book.getId(), user.getId());
            return true;
        }
        return false;
    }

    public void lateLoans() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Loan loan : loans) {
            if(loanDao.isLate(loan)) {
                view.showLoan(loan.getId(), 
                            loan.getBook().getTitle(), 
                            loan.getUser().getName(),
                            loan.getRentDate().format(formatter),
                            loan.getReturnDate().format(formatter),
                            loan.getLateDays());
            }
        }
    }
}

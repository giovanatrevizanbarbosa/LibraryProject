package br.edu.ifsp.arq.tsi.deoo.controller;

import java.util.Iterator;

import br.edu.ifsp.arq.tsi.deoo.model.Book;
import br.edu.ifsp.arq.tsi.deoo.model.Loan;
import br.edu.ifsp.arq.tsi.deoo.model.User;
import br.edu.ifsp.arq.tsi.deoo.model.dao.LoanDao;
import br.edu.ifsp.arq.tsi.deoo.model.dao.LoanDaoImpl;
import br.edu.ifsp.arq.tsi.deoo.view.UserView;

public class LoanController {

    private LoanDao loanDao;
    private UserView view;
    
    public LoanController(UserView view) {
        this.view = view;
        loanDao = new LoanDaoImpl.getInstance();
    }

    public boolean createLoan(Book book, User user) {
        if(book.isAvailable() && !user.getHasPenalty()) {
            loanDao.rentBook(book.getId(), user.getId());
            return true;
        }
        return false;
    }

    public void lateLoans() {
        Loan loan;
        Iterator<Loan> iterator = loanDao.getAll().iterator();
        while(iterator.hasNext()) {
            loan = iterator.next();
            if (loanDao.isLate(loan)) {
                view.showLateLoans();
            }
        }
    }
}

package br.edu.ifsp.arq.tsi.deoo.model.dao;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifsp.arq.tsi.deoo.model.Loan;

public class LoanDaoImpl implements LoanDao {
    private static LoanDaoImpl instance;
    private Set<Loan> loans;

    public static LoanDao getInstance(){
        if(instance == null) instance = new LoanDaoImpl();
        return instance;
    }

    private LoanDaoImpl(){
        loans = new HashSet<>();
    }

    @Override
    public Loan findLoanById(int loanId) {
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
        for(Book b : books){
            
        }
        
        return false;
    }

    @Override
    public boolean returnBook(int bookId, int userId) {
        return false;
    }

    
}
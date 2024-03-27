package br.edu.ifsp.arq.tsi.deoo.model.dao;

import java.util.Set;

import br.edu.ifsp.arq.tsi.deoo.model.Loan;

public interface LoanDao{
    Set<Loan> getAll();

    Loan findLoanById(int loanId);

    boolean rentBook(int bookId, int userId);

    boolean returnBook(int bookId, int userId);

    boolean isLate(Loan loan);
}
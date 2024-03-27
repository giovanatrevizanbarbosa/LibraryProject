package br.edu.ifsp.arq.tsi.deoo.model;

import java.time.LocalDate;

public class Loan{
    private LocalDate rentDate;
    private Book book;
    private User user;
    private LocalDate returnDate;
    private int lateDays;

    public LocalDate getRentDate() {
        return rentDate;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public int getLateDays() {
        return lateDays;
    }
}
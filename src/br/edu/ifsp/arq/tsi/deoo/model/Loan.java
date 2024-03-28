package br.edu.ifsp.arq.tsi.deoo.model;

import java.time.LocalDate;

public class Loan{
    private static int nextId = 1;
    private int id;
    private Book book;
    private User user;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private int lateDays;

    public Loan(Book book, User user) {
        this.id = nextId++;
        this.book = book;
        this.user = user;
        this.rentDate = LocalDate.now();
        this.returnDate = rentDate.plusDays(user.returnDeadlineMaxDay());
        this.lateDays = 0;
    }

    public int getId() {
        return id;
    }

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
        return rentDate.plusDays(user.returnDeadlineMaxDay());
    }

    public int getLateDays() {
        if (getRentDate().compareTo(getReturnDate()) > 0) {
            return getRentDate().compareTo(getReturnDate());
        }
        return 0;
    }
}
package br.edu.ifsp.arq.tsi.deoo.view;

public interface UserView {
    void showBook(int id, String title, String author, String edition, boolean available, int lentTimes);

    void showLoan(int id, String username, String bookTitle, String rentDate, String returnDate, int lateDays);

    void showUser(int id, String name, String email, String phoneNumber, boolean hasPenalty, int lentBooks);
}

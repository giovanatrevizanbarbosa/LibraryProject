package br.edu.ifsp.arq.tsi.deoo.view;

public class ConsoleView implements UserView {
    @Override
    public void showBook(int id, String title, String author, String edition, boolean available, int lentTimes) {
        System.out.println("\t>>> Book " + id + " <<<");
        System.out.println("Title......: " + title);
        System.out.println("Author.....: " + author);
        System.out.println("Edition....: " + edition);
        System.out.println("Available..: " + (available ? "Yes" : "No"));
        System.out.println("Times Lent.: " + lentTimes);
        System.out.println("*****************************");
    }

    @Override
    public void showLoan(int id, String username, String bookTitle, String rentDate, String returnDate, int lateDays) {
        System.out.println("\t>>> Loan " + id + " <<<");
        System.out.println("User........: " + username);
        System.out.println("Book Title..: " + bookTitle);
        System.out.println("Rent Date...: " + rentDate);
        System.out.println("Return Date.: " + returnDate);
        System.out.println("Late Days...: " + lateDays);
        System.out.println("*****************************");
        
    }

    @Override
    public void showUser(int id, String name, String email, String phoneNumber, boolean hasPenalty, int lentBooks) {
        System.out.println("\t>>> User " + id + " <<<");
        System.out.println("Name.........: " + name);
        System.out.println("Email........: " + email);
        System.out.println("Phone Number.: " + phoneNumber);
        System.out.println("Penalty......: " + (hasPenalty ? "Yes" : "No"));
        System.out.println("Lent Books...: " + lentBooks);
        System.out.println("*****************************");
    }
}

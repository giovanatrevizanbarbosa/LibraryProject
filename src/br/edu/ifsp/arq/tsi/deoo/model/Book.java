package br.edu.ifsp.arq.tsi.deoo.model;

public class Book{
    private static int bookSequence = 0;
    private int id;
    private String title;
    private String author;
    private String edition;
    private boolean isAvailable;
    private int lentTimes = 0;

    public Book(String title, String author, String edition) {
        this.id = nextVal();
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.isAvailable = true;
    }

    private int nextVal() {
        return ++bookSequence;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getLentTimes(){
        return lentTimes;
    }
    
    public void setLentTimes(int lentValue){
        lentTimes = lentValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) && edition.equals(book.edition);
    }
}
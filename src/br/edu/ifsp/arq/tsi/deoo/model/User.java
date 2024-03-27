package br.edu.ifsp.arq.tsi.deoo.model;

import java.util.Set;

public abstract class User{
    
    private static int userSequence = 0;
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private boolean hasPenalty;
    private Set<Book> lentBooks;

    public User(String name, String email, String phoneNumber){
        this.id = nextVal();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    private int nextVal() {
        return ++userSequence;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public boolean getHasPenalty(){
        return hasPenalty;
    }

    public Set<Book> getLentBooks(){
        return lentBooks;
    }

    public abstract int returnDeadlineMaxDay();
}
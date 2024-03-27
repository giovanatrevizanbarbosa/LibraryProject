package br.edu.ifsp.arq.tsi.deoo.model;

public class Student extends User{

    public Student(String name, String email, String phoneNumber){
        super(name, email, phoneNumber);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    @Override
    public int returnDeadlineMaxDay(){
        return 5;
    }
}
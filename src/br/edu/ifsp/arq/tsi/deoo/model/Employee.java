package br.edu.ifsp.arq.tsi.deoo.model;

import java.util.Set;

public class Employee extends User{

    public Employee(String name, String email, String phoneNumber){
        super(name, email, phoneNumber);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public Set<Book> getLentBooks() {
        return super.getLentBooks();
    }

    @Override
    public boolean hasPenalty() {
        return super.hasPenalty();
    }

    @Override
    public void setPenalty(boolean penalty) {
        super.setPenalty(penalty);
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
        return 15;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return this.getId() == employee.getId();
    }
}
package br.edu.ifsp.arq.tsi.deoo.model.dao;

import br.edu.ifsp.arq.tsi.deoo.model.User;

import java.util.Set;

public class UserDaoImpl implements UserDao{
    private static UserDaoImpl instance;
    private Set<User> users;

    public static UserDao getInstance(){
        if(instance == null) instance = new UserDaoImpl();
        return instance;
    }

    @Override
    public Set<User> getAll() {
        return users;
    }

    @Override
    public User findUserById(int id) {
        for(User u : users){
            if(u.getId() == id) return u;
        }
        return null;
    }

    @Override
    public boolean insertUser(User user) {
        for (User u : users){
            if(u.equals(user)) return false;
        }
        return users.add(user);
    }

    @Override
    public boolean deleteUser(int id) {
        for (User u : users){
            if(u.equals(u)) users.remove(u);
            return true;
        }
        return false;
    }
}

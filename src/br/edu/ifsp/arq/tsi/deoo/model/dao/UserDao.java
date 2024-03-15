package br.edu.ifsp.arq.tsi.deoo.model.dao;

public interface UserDao {
    Set<User> getAll();

    User findById(int id);

    boolean insert(User user);

    boolean update(User currentUser, User newUser);

    boolean delete(int id);
}

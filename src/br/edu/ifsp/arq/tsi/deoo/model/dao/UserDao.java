package br.edu.ifsp.arq.tsi.deoo.model.dao;

import br.edu.ifsp.arq.tsi.deoo.model.User;

import java.util.Set;

public interface UserDao {
    Set<User> getAll();

    User findUserById(int id);

    boolean insertUser(User user);

    boolean deleteUser(int id);
}
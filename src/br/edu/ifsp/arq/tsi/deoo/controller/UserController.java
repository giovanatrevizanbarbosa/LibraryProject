package br.edu.ifsp.arq.tsi.deoo.controller;

import java.util.Set;

import br.edu.ifsp.arq.tsi.deoo.model.User;
import br.edu.ifsp.arq.tsi.deoo.model.dao.UserDao;
import br.edu.ifsp.arq.tsi.deoo.model.dao.UserDaoImpl;
import br.edu.ifsp.arq.tsi.deoo.view.UserView;

public class UserController {

    private UserDao userDao;
    private UserView view;

    Set<User> users = userDao.getAll();

    public UserController(UserView view) {
        this.view = view;
        userDao = UserDaoImpl.getInstance();
    }

    public boolean registerUser(User user) {
        if(userDao.findUserById(user.getId()) == null) {
            userDao.insertUser(user);
            return true;
        }
        return false;
    }

    public void allUsers() {
        for (User user : users) {
            view.showUser(user.getId(), 
                        user.getName(), 
                        user.getEmail(),
                        user.getPhoneNumber(),
                        user.hasPenalty(),
                        user.getLentBooks().size());
        }
    }

    public void usersWithLentBooks() {
        for (User user : users) {
            if(user.getLentBooks().size() > 0) {
                view.showUser(user.getId(), 
                            user.getName(), 
                            user.getEmail(),
                            user.getPhoneNumber(),
                            user.hasPenalty(),
                            user.getLentBooks().size());
            }
        }
    }

    public void usersServingPenalties() {
        for (User user : users) {
            if(user.hasPenalty()) {
                view.showUser(user.getId(), 
                            user.getName(), 
                            user.getEmail(),
                            user.getPhoneNumber(),
                            user.hasPenalty(),
                            user.getLentBooks().size());
            }
        }
    }
}

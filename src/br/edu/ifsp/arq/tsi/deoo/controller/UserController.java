package br.edu.ifsp.arq.tsi.deoo.controller;

import java.util.Iterator;

import br.edu.ifsp.arq.tsi.deoo.model.User;
import br.edu.ifsp.arq.tsi.deoo.model.dao.UserDao;
import br.edu.ifsp.arq.tsi.deoo.model.dao.UserDaoImpl;
import br.edu.ifsp.arq.tsi.deoo.view.UserView;

public class UserController {

    private UserDao userDao;
    private UserView view;

    public UserController(UserView view) {
        this.view = view;
        userDao = new UserDaoImpl.getInstance();
    }

    public boolean registerUser(User user) {
        if(userDao.findById(user.getId()) == null) {
            userDao.insert(user);
            return true;
        }
        return false;
    }

    public void usersWithLentBooks() {
        User user;
        Iterator<User> iterator = userDao.getAll().iterator();
        while(iterator.hasNext()) {
            user = iterator.next();
            if(user.getLentBooks().size() > 0) {
                view.showUsersServingPenalties();
            }
        }
    }

    public void usersServingPenalties() {
        User user;
        Iterator<User> iterator = userDao.getAll().iterator();
        while(iterator.hasNext()) {
            user = iterator.next();
            if(user.getHasPenalty()) {
                view.showUsersServingPenalties();
            }
        }
    }
}

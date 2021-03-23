package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    void update(User user);
    void remove(Long id);
    List<User> getUsers();
    User findById(Long id);
    User getUserByName(String name);
}

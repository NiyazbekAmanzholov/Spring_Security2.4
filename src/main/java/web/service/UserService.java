package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    void add(User user);
    void update(User user);
    void remove(Long id);
    List<User> getUsers();
    User findById(Long id);
    User getUserByName(String name);
    Set<Role> getSetOfRoles(List<String> rolesId);
}

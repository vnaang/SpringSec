package dao;

import model.User;

import java.util.List;

public interface DaoUser {

    void addUser(User user);

    User getUserById(long id);

    void removeUserById(User user);

    List<User> getAllUsers();

    void updateUser(User userChanges);
}

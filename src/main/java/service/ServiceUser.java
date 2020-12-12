package service;

import model.User;
import java.util.List;


public interface ServiceUser {

    void addUser(User user);

    User getUserById(long id);

    void deleteUser(User user);

    public void saveUser(User user);

    List<User> getAllUsers();

    void updateUser(User userChanges);

    User getUserByName(String name);
}

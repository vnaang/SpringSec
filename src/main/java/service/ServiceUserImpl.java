package service;

import dao.DaoUser;
import model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceUserImpl implements ServiceUser {

    private DaoUser daoUser;

    public ServiceUserImpl(DaoUser daoUser){
        this.daoUser = daoUser;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        daoUser.addUser(user);
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        return daoUser.getUserById(id);
    }

    @Transactional
    @Override
    public void removeUserById(User user) {
        daoUser.removeUserById(user);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return daoUser.getAllUsers();
    }

    @Transactional
    @Override
    public void updateUser(User userChanges) {
        daoUser.updateUser(userChanges);
    }
}

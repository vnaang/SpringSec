package service;

import dao.DaoUser;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import java.util.List;


@Service
@Transactional
public class ServiceUserImpl implements ServiceUser {

    private DaoUser daoUser;

    public ServiceUserImpl(DaoUser daoUser){
        this.daoUser = daoUser;
    }

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public void addUser(User user) { daoUser.addUser(user); }

    @Transactional
    @Override
    public User getUserById(long id) {
        return daoUser.getUserById(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) throws UsernameNotFoundException { //exception
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(new Role(3L,"ROLE_USER")));
        daoUser.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        daoUser.deleteUser(user);
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

    @Override
    public User getUserByName(String name) {
        return daoUser.getUserByName(name);
    }
}

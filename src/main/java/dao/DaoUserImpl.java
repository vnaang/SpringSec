package dao;

import model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class DaoUserImpl implements DaoUser {


    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery(" FROM User ", User.class).getResultList();
    }

    @Transactional
    @Override
    public void updateUser(User userChanges) {
        entityManager.merge(userChanges);

    }

    @Override
    public User getUserByName(String name) {
        Query query= entityManager.createQuery("FROM User where name=: name",User.class);
        query.setParameter("name",name);
        User user = (User) query.getSingleResult();
        return user;
    }

}

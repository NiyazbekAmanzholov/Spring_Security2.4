package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "em")
    private EntityManager entityManager;

    @Override
    public User getUserByName(String name) {
        Query q = entityManager.createQuery("select u from User u where  u.username=:name");
        q.setParameter("name",name);
        return (User) q.getSingleResult();
        //return entityManager.find(User.class,name);
    }

    @Override
    public void add(User user) {

        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void remove(Long id) {
        Query q = entityManager.createQuery("delete from User u where  u.id=:id");
        q.setParameter("id",id);
        q.executeUpdate();
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class,id);
    }

}

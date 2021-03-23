package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDao {

    @PersistenceContext(unitName = "em")
    private EntityManager entityManager;

    public List<Role> getRolesList() {

        return entityManager.createQuery("select r from Role r").getResultList();
    }

    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }
}

package repozitory;

import com.example.pproprojekt.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmploeeyDao {
    @PersistenceContext
    private EntityManager em;

    public void add(final Employee employee) {
        em.persist(employee);
    }

    public List<Employee> getAll() {
        return em.createQuery("SELECT s FROM Employee s", Employee.class).getResultList();
    }

    public Employee getById(long id) {
        return em.find(Employee.class, id);
    }

    public void remove(final Employee sm) {
        Employee ps = em.merge(sm);
        em.remove(ps);
    }

    public void update(Employee employee) {
        add(employee);
    }
}

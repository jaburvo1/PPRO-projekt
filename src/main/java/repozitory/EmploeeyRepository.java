package repozitory;

import com.example.pproprojekt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
import com.example.pproprojekt.entity.Employee;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class EmploeeyRepository {
    @PersistenceContext
    private EntityManager entityManager = new EntityManager() {
        @Override
        public void persist(Object o) {

        }

        @Override
        public <T> T merge(T t) {
            return null;
        }

        @Override
        public void remove(Object o) {

        }

        @Override
        public <T> T find(Class<T> aClass, Object o) {
            return null;
        }

        @Override
        public <T> T find(Class<T> aClass, Object o, Map<String, Object> map) {
            return null;
        }

        @Override
        public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType) {
            return null;
        }

        @Override
        public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType, Map<String, Object> map) {
            return null;
        }

        @Override
        public <T> T getReference(Class<T> aClass, Object o) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public void setFlushMode(FlushModeType flushModeType) {

        }

        @Override
        public FlushModeType getFlushMode() {
            return null;
        }

        @Override
        public void lock(Object o, LockModeType lockModeType) {

        }

        @Override
        public void lock(Object o, LockModeType lockModeType, Map<String, Object> map) {

        }

        @Override
        public void refresh(Object o) {

        }

        @Override
        public void refresh(Object o, Map<String, Object> map) {

        }

        @Override
        public void refresh(Object o, LockModeType lockModeType) {

        }

        @Override
        public void refresh(Object o, LockModeType lockModeType, Map<String, Object> map) {

        }

        @Override
        public void clear() {

        }

        @Override
        public void detach(Object o) {

        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public LockModeType getLockMode(Object o) {
            return null;
        }

        @Override
        public void setProperty(String s, Object o) {

        }

        @Override
        public Map<String, Object> getProperties() {
            return null;
        }

        @Override
        public Query createQuery(String s) {
            return null;
        }

        @Override
        public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
            return null;
        }

        @Override
        public <T> TypedQuery<T> createQuery(String s, Class<T> aClass) {
            return null;
        }

        @Override
        public Query createNamedQuery(String s) {
            return null;
        }

        @Override
        public <T> TypedQuery<T> createNamedQuery(String s, Class<T> aClass) {
            return null;
        }

        @Override
        public Query createNativeQuery(String s) {
            return null;
        }

        @Override
        public Query createNativeQuery(String s, Class aClass) {
            return null;
        }

        @Override
        public Query createNativeQuery(String s, String s1) {
            return null;
        }

        @Override
        public void joinTransaction() {

        }

        @Override
        public <T> T unwrap(Class<T> aClass) {
            return null;
        }

        @Override
        public Object getDelegate() {
            return null;
        }

        @Override
        public void close() {

        }

        @Override
        public boolean isOpen() {
            return false;
        }

        @Override
        public EntityTransaction getTransaction() {
            return null;
        }

        @Override
        public EntityManagerFactory getEntityManagerFactory() {
            return null;
        }

        @Override
        public CriteriaBuilder getCriteriaBuilder() {
            return null;
        }

        @Override
        public Metamodel getMetamodel() {
            return null;
        }
    };

    public void add(final Employee employee) {
        entityManager.persist(employee);
    }

    public Employee getEmploeeLogin(String email, String password) {
        Employee em= new Employee();
        List<Employee> employees  = entityManager.createQuery("SELECT em.role  FROM Employee em WHERE em.email LIKE :email AND em.password LIKE :password"  ,
                Employee.class).setParameter("email", email).setParameter("password", password).getResultList();


        Employee emploeey =employees.get(0);
        return  emploeey;
    }

    public Employee getEmploeeByEmail(String email, String password) {
        List<Employee> employees  = entityManager.createQuery("SELECT em FROM Employee em WHERE em.email LIKE :email"  ,
                Employee.class).setParameter("email", email).getResultList();


        Employee emploeey =employees.get(0);
        return  emploeey;
    }
    public void updatePasswprd(String email, String newPassword) {

        entityManager.createQuery("UPDATE Employee em SET em.password=:newPassword WHERE em.email = :email", Employee.class).setParameter("newPassword", newPassword)
                .setParameter("email", email).executeUpdate();

    }


}
*/
public interface EmploeeyRepository  extends JpaRepository<Employee, Long> {

    List<Employee> find(String email, String password);
}
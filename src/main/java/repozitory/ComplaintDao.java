package repozitory;

import com.example.pproprojekt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintDao extends JpaRepository<Employee, Integer> {
}

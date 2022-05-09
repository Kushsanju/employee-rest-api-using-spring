package rancom.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rancom.example.demo.model.Employee;

@Repository
public interface Employee_Repository extends JpaRepository<Employee,Long> {
}

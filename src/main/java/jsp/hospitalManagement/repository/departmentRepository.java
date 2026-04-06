package jsp.hospitalManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.hospitalManagement.entity.Department;

public interface departmentRepository extends JpaRepository<Department,Integer>{
      
	List<Department> findByDepartmentName(String departmentName);
	boolean existsByDepartmentNameIgnoreCase(String departmentName);

	
}

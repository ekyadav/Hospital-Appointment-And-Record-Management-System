package jsp.hospitalManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import jsp.hospitalManagement.entity.Department;
import jsp.hospitalManagement.exception.IdNotFoundException;
import jsp.hospitalManagement.exception.NoDepartmentFoundException;
import jsp.hospitalManagement.repository.departmentRepository;


@Repository
public class DepartmentDao {
    
	@Autowired
	private departmentRepository departmentRepo;
	 public Department createDepartment(Department department) {
		    return departmentRepo.save(department);
		 
	 }
	 public List<Department> fetchAllDepartment(){
		 List<Department> depmts = departmentRepo.findAll();
		 
		 if(depmts.isEmpty()) {
			 throw new NoDepartmentFoundException("No departments founded in database");
		 }
		 return depmts;
	 }
	 public Department fetchDepartmentById(Integer id) {
		 Optional<Department> opt = departmentRepo.findById(id);
		 if(opt.isPresent()) {
				return opt.get();
		 }
			else {
				throw new IdNotFoundException("Id does not exist in DB.");	
			} 
	 }
	 public Department updateDepartment(Department department) {
		 if(department.getDepartmentId()== null) {
			 throw new IdNotFoundException("Id does not exist in DB.");
		 }
		 Optional<Department> opt = departmentRepo.findById(department.getDepartmentId());
		 if(opt.isPresent()) {
			 return departmentRepo.save(department);
		 }
		 else {
			 throw new IdNotFoundException("Id does not exist in DB.");
		 }
	 }
	 public void deleteDepartment(Integer id) {
		 Optional<Department> opt = departmentRepo.findById(id);
		 if(opt.isPresent()) {
			  departmentRepo.delete(opt.get());
		 }
		 else {
			 throw new IdNotFoundException("Id does not exist in DB.");
		 }
	 }
	 public List<Department> fetchDepartmentByDepartmentName(String departmentName) {
		 List<Department> dept = departmentRepo.findByDepartmentName(departmentName);
		 if(dept.isEmpty()) {
			  throw new NoDepartmentFoundException("Department " + departmentName +" does not exist in DB.");
		 }
		 return dept;
	 }
}

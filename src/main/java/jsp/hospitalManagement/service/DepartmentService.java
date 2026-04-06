package jsp.hospitalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import jsp.hospitalManagement.dao.DepartmentDao;
import jsp.hospitalManagement.entity.Department;
import jsp.hospitalManagement.exception.DuplicateDepartmentException;
import jsp.hospitalManagement.repository.departmentRepository;

@Service
public class DepartmentService {
     @Autowired
     private DepartmentDao departmentDao;
     @Autowired
     private departmentRepository departmentRepo;
     
     public ResponseEntity<ResponseStructure<Department>> createDepartment(Department department){
    	    //  Validation added
    	    if(departmentRepo.existsByDepartmentNameIgnoreCase(department.getDepartmentName())){
                   throw new DuplicateDepartmentException("Department already exists.");
    	    }
    	    ResponseStructure<Department> response = new ResponseStructure<>();
    	    response.setStatusCode(HttpStatus.CREATED.value());
    	    response.setMessage("Department created successfully.");
    	    response.setData(departmentDao.createDepartment(department));
    	    return new ResponseEntity<ResponseStructure<Department>>(response,HttpStatus.CREATED);
     }
     public ResponseEntity<ResponseStructure<List<Department>>> fetchAllDepartment(){
    	    ResponseStructure<List<Department>> response = new ResponseStructure<>();
    	    response.setStatusCode(HttpStatus.FOUND.value());
    	    response.setMessage("All Departments fetched successfully.");
    	    response.setData(departmentDao.fetchAllDepartment());
    	    return new ResponseEntity<ResponseStructure<List<Department>>>(response,HttpStatus.FOUND);
    	    }
     public ResponseEntity<ResponseStructure<Department>> fetchDepartmentById( Integer id){
    	    ResponseStructure<Department> response = new ResponseStructure<>();
 	        response.setStatusCode(HttpStatus.FOUND.value());
 	        response.setMessage("All Departments fetched successfully.");
 	        response.setData(departmentDao.fetchDepartmentById(id));
 	        return new ResponseEntity<ResponseStructure<Department>>(response,HttpStatus.FOUND);
     }
     public ResponseEntity<ResponseStructure<Department>> updateDepartment(Department department){
    	    ResponseStructure<Department> response = new ResponseStructure<>();
    	    response.setStatusCode(HttpStatus.OK.value());
    	    response.setMessage("Department updated successfully.");
    	    response.setData(departmentDao.updateDepartment(department));
    	    return new ResponseEntity<ResponseStructure<Department>>(response,HttpStatus.OK);
     }
     public ResponseEntity<ResponseStructure<String>> deleteDepartment(Integer id){
    	    ResponseStructure<String> response = new ResponseStructure<>();
    	    departmentDao.deleteDepartment(id);
    	    response.setStatusCode(HttpStatus.OK.value());
    	    response.setMessage("Department deleted successfully.");
    	    response.setData("Deleted");
    	    return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.OK);
    	    
     }
     public ResponseEntity<ResponseStructure<List<Department>>> fetchDepartmentByDepartmentName(String departmentName){
    	    ResponseStructure<List<Department>> response = new ResponseStructure<>();
    	    response.setStatusCode(HttpStatus.OK.value());
    	    response.setMessage("All Departments fetched successfully.");
    	    response.setData(departmentDao.fetchDepartmentByDepartmentName(departmentName));
    	    return new ResponseEntity<ResponseStructure<List<Department>>>(response,HttpStatus.OK);
     }
}

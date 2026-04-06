package jsp.hospitalManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.hospitalManagement.entity.Department;
import jsp.hospitalManagement.repository.departmentRepository;
import jsp.hospitalManagement.service.DepartmentService;
import jsp.hospitalManagement.service.ResponseStructure;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	   @Autowired
       private departmentRepository departmentRepo;
	   @Autowired
       private DepartmentService departmentService;
	   @PostMapping
	   public ResponseEntity<ResponseStructure<Department>> createDepartment(@RequestBody Department department){
		   return departmentService.createDepartment(department);
	   }
	   @GetMapping("/all/dept")
	   public ResponseEntity<ResponseStructure<List<Department>>> fetchAllDepartment(){
		   return departmentService.fetchAllDepartment();
	   }
	   @GetMapping("/{id}")
	   public ResponseEntity<ResponseStructure<Department>> fetchDepartmentById(@PathVariable("id") Integer id){
		   return departmentService.fetchDepartmentById(id);
	   }
	   @PutMapping("/{id}")
	   public ResponseEntity<ResponseStructure<Department>> updateDepartment(@RequestBody Department department){
		   return departmentService.updateDepartment(department);
	   }
	   @DeleteMapping("/{id}")
	   public ResponseEntity<ResponseStructure<String>> deleteDepartment(@PathVariable("id") Integer id){
		   return departmentService.deleteDepartment(id);
	   }
	   @GetMapping("/dName/{departmentName}")
	   public ResponseEntity<ResponseStructure<List<Department>>> fetchDepartmentByDepartmentName(@PathVariable("departmentName") String departmentName){
		   return departmentService.fetchDepartmentByDepartmentName(departmentName);
	   }
}

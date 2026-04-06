package jsp.hospitalManagement.controller;

import java.time.LocalDate;
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
import jsp.hospitalManagement.entity.Doctor;
import jsp.hospitalManagement.repository.doctorRepository;
import jsp.hospitalManagement.service.DoctorService;
import jsp.hospitalManagement.service.ResponseStructure;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
       @Autowired
       private doctorRepository doctorRepo;
       @Autowired
       private DoctorService doctorService;
       
       @PostMapping
       public ResponseEntity<ResponseStructure<Doctor>> addDoctor(@RequestBody Doctor doctor){
    	      return doctorService.addDoctor(doctor);
       }
       @GetMapping("/all")
       public ResponseEntity<ResponseStructure<List<Doctor>>> getAllDoctors(){
    	      return doctorService.getAllDoctors();
       }
       @GetMapping("/{id}")
       public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorById(@PathVariable("id")Integer id){
    	      return doctorService.fetchDoctorById(id);
       }
       @GetMapping("/spec/{specialization}")
       public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorsBySpecialization(@PathVariable("specialization") String specialization){
    	      return doctorService.fetchDoctorsBySpecialization(specialization);
       }
       @GetMapping("/dept/{departmentId}")
       public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorsInADepartment(@PathVariable("departmentId") Integer departmentId){
    	      return doctorService.fetchDoctorsInADepartment(departmentId);
       }
       @GetMapping("/{patientId}")
       public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByPatient(@PathVariable("patientId") Integer patientId){
    	      return doctorService.fetchDoctorByPatient(patientId);
       }
       @GetMapping("/appointment/{appointmentId}")
       public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorByAppointment(@PathVariable("appointmentId") Integer appointmentId){
    	      return doctorService.fetchDoctorByAppointment(appointmentId);
       }
       @GetMapping("/available/{date}")
       public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByAvailableDays(@PathVariable String date){
              LocalDate localDate = LocalDate.parse(date);
              return doctorService.fetchDoctorByAvailableDays(localDate);
       }
       @PutMapping("/{id}")
	   public ResponseEntity<ResponseStructure<Doctor>> updateDoctorInfo(@RequestBody Doctor doctor){
		   return doctorService.updateDoctorInfo(doctor);
	   }
       @DeleteMapping("/{id}")
       public ResponseEntity<ResponseStructure<String>> deleteDoctor(@PathVariable("id") Integer doctorId){
		   return doctorService.deleteDoctor(doctorId);
	   }
}

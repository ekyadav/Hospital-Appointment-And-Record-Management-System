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

import jsp.hospitalManagement.entity.Patient;
import jsp.hospitalManagement.repository.patientRepository;
import jsp.hospitalManagement.service.PatientService;
import jsp.hospitalManagement.service.ResponseStructure;

@RestController
@RequestMapping("/patient")
public class PatientController {
	   @Autowired
	   private patientRepository patientRepo;
       @Autowired
       private PatientService patientService;
       
       @PostMapping
       public ResponseEntity<ResponseStructure<Patient>> registerPatient(@RequestBody Patient patient){
    	      return patientService.registerPatient(patient);
       }
       @GetMapping("/all")
       public ResponseEntity<ResponseStructure<List<Patient>>> fetchAllPatients(){
    	      return patientService.fetchAllPatients();
       }
       @GetMapping("/{id}")
       public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(@PathVariable("id") Integer id){
    	      return patientService.fetchPatientById(id); 
       }
       @GetMapping("/phone/{phone}")
       public ResponseEntity<ResponseStructure<Patient>> fetchPatientByPhoneNo(@PathVariable("phone")String phone){
    	      return patientService.fetchPatientByPhoneNo(phone);
       }
       @GetMapping("/age/{age}")
       public ResponseEntity<ResponseStructure<List<Patient>>> fetchPatientWhereAgeIsGreaterThan(@PathVariable("age") Integer age){
    	      return patientService.fetchPatientWhereAgeIsGreaterThan(age);
       }
       @GetMapping("/appointments/{appointmentId}")
       public ResponseEntity<ResponseStructure<Patient>> fetchPatientByAppointment(@PathVariable("appointmentId") Integer appointmentId){
    	      return patientService.fetchPatientByAppoinment(appointmentId);
       }
       @GetMapping("/medicalrecord/{recordId}/patient")
       public ResponseEntity<ResponseStructure<Patient>> fetchPatientByMedicalRecord(@PathVariable Integer recordId){
              return patientService.fetchPatientByMedicalRecords(recordId);
    	}
       @PutMapping("/{id}")
       public ResponseEntity<ResponseStructure<Patient>> updatePatientInfo(@RequestBody Patient patient){
 	      return patientService.updatePatientInfo(patient);
       }
       @DeleteMapping("/{id}")
       public ResponseEntity<ResponseStructure<String>> deletePatientInfo(@PathVariable("id")Integer id){
 	      return patientService.deletePatientInfo(id);
    }
       
       
}

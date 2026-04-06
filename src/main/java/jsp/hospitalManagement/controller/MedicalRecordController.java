package jsp.hospitalManagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.hospitalManagement.entity.MedicalRecord;
import jsp.hospitalManagement.repository.medicalRecordRepository;
import jsp.hospitalManagement.service.MedicalRecordService;
import jsp.hospitalManagement.service.ResponseStructure;

@RestController
@RequestMapping("/record")
public class MedicalRecordController {
	   @Autowired
	   private medicalRecordRepository recordRepo;
       @Autowired
       private MedicalRecordService recordService;
       
       @PostMapping("/save/All")
       public ResponseEntity<ResponseStructure<List<MedicalRecord>>> createRecord(@RequestBody List<MedicalRecord> records){
    	      return recordService.createRecord(records);
       }
       @GetMapping
       public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchAllRecord(){
              return recordService.fetchAllRecord();
       }
       @GetMapping("/{id}")
       public ResponseEntity<ResponseStructure<MedicalRecord>> fetchRecordById(@PathVariable("id") Integer id){
    	      return recordService.fetchRecordById(id);
       }
       @GetMapping("/patient/{patientId}")
       public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchRecordByPatient(@PathVariable Integer patientId){
              return recordService.fetchRecordByPatient(patientId);
       }
       @GetMapping("/doctor/{doctorId}")
       public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchRecordByDoctor(@PathVariable Integer doctorId){
              return recordService.fetchRecordByDoctor(doctorId);
       }
       @GetMapping("/appointment/{appointmentId}")
       public ResponseEntity<ResponseStructure<MedicalRecord>> fetchRecordByAppointment(@PathVariable Integer appointmentId){
              return recordService.fetchRecordByAppointment(appointmentId);
       }
       @GetMapping("/date/{visitDate}")
       public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchRecordByVisitDate(@PathVariable LocalDate visitDate){
              return recordService.fetchRecordByVisitDate(visitDate);
       }
       @DeleteMapping("/medicalRecords")
       public ResponseEntity<ResponseStructure<String>> deleteAllRecords(){
           return recordService.deleteAllRecords();
       }
}

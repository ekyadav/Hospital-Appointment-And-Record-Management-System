package jsp.hospitalManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.hospitalManagement.entity.Prescription;
import jsp.hospitalManagement.repository.prescriptionRepository;
import jsp.hospitalManagement.service.PrescriptionService;
import jsp.hospitalManagement.service.ResponseStructure;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
	   @Autowired
	   private prescriptionRepository prescriptionRepo;
       @Autowired 
       private PrescriptionService prescriptionService;
       @PostMapping
       public ResponseEntity<ResponseStructure<Prescription>> createPrescription(@RequestBody Prescription prescription){
              return prescriptionService.createPrescription(prescription);
       }
       @GetMapping
       public ResponseEntity<ResponseStructure<List<Prescription>>> fetchAllPrescription() {
           return prescriptionService.fetchAllPrescription();
       }
       @GetMapping("/{id}")
       public ResponseEntity<ResponseStructure<Prescription>> fetchPrescriptionById(@PathVariable Integer id) {
           return prescriptionService.fetchPrescriptionById(id);
       }
       @GetMapping("/record/{recordId}")
       public ResponseEntity<ResponseStructure<Prescription>> fetchPrescriptionByMedicalRecord(@PathVariable Integer recordId) {
              return prescriptionService.fetchPrescriptionByMedicalRecord(recordId);
       }
       @GetMapping("/patient/{patientId}")
       public ResponseEntity<ResponseStructure<List<Prescription>>> fetchPrescriptionByPatient(@PathVariable Integer patientId) {
              return prescriptionService.fetchPrescriptionByPatient(patientId);
       }
}

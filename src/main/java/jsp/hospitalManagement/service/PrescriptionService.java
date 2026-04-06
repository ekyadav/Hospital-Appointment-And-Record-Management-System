package jsp.hospitalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.hospitalManagement.dao.PrescriptionDao;
import jsp.hospitalManagement.entity.Prescription;
import jsp.hospitalManagement.repository.prescriptionRepository;

@Service
public class PrescriptionService {
       @Autowired
       private PrescriptionDao prescriptionDao;
       @Autowired
       private prescriptionRepository prescriptionRepo;
       public ResponseEntity<ResponseStructure<Prescription>> createPrescription(Prescription prescription){
              ResponseStructure<Prescription> response = new ResponseStructure<>();
              response.setStatusCode(HttpStatus.CREATED.value());
    	      response.setMessage("Prescription created successfully");
    	      response.setData(prescriptionDao.createPrescription(prescription));
              return new ResponseEntity<>(response, HttpStatus.CREATED);
    	}
       public ResponseEntity<ResponseStructure<List<Prescription>>> fetchAllPrescription() {
              List<Prescription> prescriptions = prescriptionDao.fetchAllPrescription();
              ResponseStructure<List<Prescription>> response = new ResponseStructure<>();
              response.setStatusCode(HttpStatus.OK.value());
              response.setMessage("All prescriptions fetched successfully");
              response.setData(prescriptions);
              return new ResponseEntity<>(response, HttpStatus.OK);
       }
       public ResponseEntity<ResponseStructure<Prescription>> fetchPrescriptionById(Integer id) {
              Prescription prescription = prescriptionDao.fetchPrescriptionById(id);
              ResponseStructure<Prescription> response = new ResponseStructure<>();
              response.setStatusCode(HttpStatus.OK.value());
              response.setMessage("Prescription fetched successfully");
              response.setData(prescription);
              return new ResponseEntity<>(response, HttpStatus.OK);
       }
       public ResponseEntity<ResponseStructure<Prescription>> fetchPrescriptionByMedicalRecord(Integer recordId) {
              Prescription prescription = prescriptionDao.fetchPrescriptionByMedicalRecord(recordId);
              ResponseStructure<Prescription> response = new ResponseStructure<>();
              response.setStatusCode(HttpStatus.OK.value());
              response.setMessage("Prescription fetched successfully by medical record");
              response.setData(prescription);
              return new ResponseEntity<>(response, HttpStatus.OK);
       }
       public ResponseEntity<ResponseStructure<List<Prescription>>> fetchPrescriptionByPatient(Integer patientId) {
              List<Prescription> prescriptions = prescriptionDao.fetchPrescriptionByPatient(patientId);
              ResponseStructure<List<Prescription>> response = new ResponseStructure<>();
              response.setStatusCode(HttpStatus.OK.value());
              response.setMessage("Prescriptions fetched successfully by patient");
              response.setData(prescriptions);
              return new ResponseEntity<>(response, HttpStatus.OK);
       }
}

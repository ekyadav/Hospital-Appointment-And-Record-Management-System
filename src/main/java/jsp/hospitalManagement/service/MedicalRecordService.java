package jsp.hospitalManagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.hospitalManagement.dao.MedicalRecordDao;
import jsp.hospitalManagement.entity.Department;
import jsp.hospitalManagement.entity.MedicalRecord;

@Service
public class MedicalRecordService {
       @Autowired
       private MedicalRecordDao medicalRecordDao;
       
       public ResponseEntity<ResponseStructure<List<MedicalRecord>>> createRecord(List<MedicalRecord> records){
  	     ResponseStructure<List<MedicalRecord>> response = new ResponseStructure<>();
  	     response.setStatusCode(HttpStatus.OK.value());
  	     response.setMessage("Medical Record created successfully.");
  	     response.setData(medicalRecordDao.createRecord(records));
  	     return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(response,HttpStatus.OK);
       }
       public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchAllRecord(){
    	     ResponseStructure<List<MedicalRecord>> response = new ResponseStructure<>();
    	     response.setStatusCode(HttpStatus.OK.value());
    	     response.setMessage("Medical Record created successfully.");
    	     response.setData(medicalRecordDao.fetchAllRecord());
    	     return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(response,HttpStatus.OK);
      }
       public ResponseEntity<ResponseStructure<MedicalRecord>> fetchRecordById( Integer id){
   	         ResponseStructure<MedicalRecord> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.FOUND.value());
	        response.setMessage("Medical Record by ID fetched successfully.");
	        response.setData(medicalRecordDao.fetchRecordById(id));
	        return new ResponseEntity<ResponseStructure<MedicalRecord>>(response,HttpStatus.FOUND);
      }
       public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchRecordByPatient(Integer patientId){
              ResponseStructure<List<MedicalRecord>> response = new ResponseStructure<>();
              response.setStatusCode(HttpStatus.OK.value());
    	      response.setMessage("Medical records by patient fetched successfully");
    	      response.setData(medicalRecordDao.fetchRecordByPatient(patientId));
              return new ResponseEntity<>(response, HttpStatus.OK);
    	}
       public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchRecordByDoctor(Integer doctorId){
              ResponseStructure<List<MedicalRecord>> response = new ResponseStructure<>();
              response.setStatusCode(HttpStatus.OK.value());
    	      response.setMessage("Medical records by doctor fetched successfully");
    	      response.setData(medicalRecordDao.fetchRecordByDoctor(doctorId));
              return new ResponseEntity<>(response, HttpStatus.OK);
    	}
       public ResponseEntity<ResponseStructure<MedicalRecord>> fetchRecordByAppointment(Integer appointmentId){
              ResponseStructure<MedicalRecord> response = new ResponseStructure<>();
              response.setStatusCode(HttpStatus.OK.value());
    	      response.setMessage("Medical record fetched successfully by appointment");
    	      response.setData(medicalRecordDao.fetchRecordByAppointment(appointmentId));
              return new ResponseEntity<>(response, HttpStatus.OK);
    	}
       public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchRecordByVisitDate(LocalDate visitDate){
              ResponseStructure<List<MedicalRecord>> response = new ResponseStructure<>();
              response.setStatusCode(HttpStatus.OK.value());
              response.setMessage("Medical records fetched successfully by visit date");
    	      response.setData(medicalRecordDao.fetchRecordByVisitDate(visitDate));
              return new ResponseEntity<>(response, HttpStatus.OK);
    	}
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       public ResponseEntity<ResponseStructure<String>> deleteAllRecords(){

           medicalRecordDao.deleteAllRecords();

           ResponseStructure<String> response = new ResponseStructure<>();
           response.setStatusCode(HttpStatus.OK.value());
           response.setMessage("All medical records deleted successfully");
           response.setData("Success");

           return new ResponseEntity<>(response, HttpStatus.OK);
       }
}

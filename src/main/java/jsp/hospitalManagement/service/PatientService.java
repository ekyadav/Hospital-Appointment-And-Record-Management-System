package jsp.hospitalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.hospitalManagement.dao.MedicalRecordDao;
import jsp.hospitalManagement.dao.PatientDao;
import jsp.hospitalManagement.entity.Department;
import jsp.hospitalManagement.entity.Patient;

@Service
public class PatientService {
    @Autowired
    private PatientDao patientDao;
   
    public ResponseEntity<ResponseStructure<Patient>> registerPatient(Patient patient){
    	   ResponseStructure<Patient> response = new ResponseStructure<>();
    	   response.setStatusCode(HttpStatus.CREATED.value());
    	   response.setMessage("Patient added successfully.");
    	   response.setData(patientDao.registerPatient(patient));
    	   return new ResponseEntity<ResponseStructure<Patient>>(response,HttpStatus.CREATED);
    	   
    }
    public ResponseEntity<ResponseStructure<List<Patient>>> fetchAllPatients(){
    	   ResponseStructure<List<Patient>> response = new ResponseStructure<>();
 	       response.setStatusCode(HttpStatus.OK.value());
 	       response.setMessage("All Patients fetched successfully.");
 	       response.setData(patientDao.fetchAllPatients());
 	       return new ResponseEntity<ResponseStructure<List<Patient>>>(response,HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(Integer id){
    	   ResponseStructure<Patient> response = new ResponseStructure<>();
	       response.setStatusCode(HttpStatus.FOUND.value());
	       response.setMessage("Patient by id fetched successfully.");
	       response.setData(patientDao.fetchPatientById(id));
	       return new ResponseEntity<ResponseStructure<Patient>>(response,HttpStatus.FOUND);
    }
    public ResponseEntity<ResponseStructure<Patient>> fetchPatientByPhoneNo(String phone){
    	   ResponseStructure<Patient> response = new ResponseStructure<>();
	       response.setStatusCode(HttpStatus.FOUND.value());
	       response.setMessage("Patient by Phone Number fetched successfully.");
	       response.setData(patientDao.fetchPatientByPhoneNo(phone));
	       return new ResponseEntity<ResponseStructure<Patient>>(response,HttpStatus.FOUND);
    }
    public ResponseEntity<ResponseStructure<List<Patient>>> fetchPatientWhereAgeIsGreaterThan(Integer age){
 	       ResponseStructure<List<Patient>> response = new ResponseStructure<>();
	       response.setStatusCode(HttpStatus.OK.value());
	       response.setMessage("All Patients fetched successfully.");
	       response.setData(patientDao.fetchPatientWhereAgeIsGreaterThan(age));
	       return new ResponseEntity<ResponseStructure<List<Patient>>>(response,HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<Patient>> fetchPatientByAppoinment(Integer appointmentId){
	       ResponseStructure<Patient> response = new ResponseStructure<>();
	       response.setStatusCode(HttpStatus.OK.value());
	       response.setMessage("Patients fetched successfully.");
	       response.setData(patientDao.fetchPatientByAppointment(appointmentId));
	       return new ResponseEntity<ResponseStructure<Patient>>(response,HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<Patient>> fetchPatientByMedicalRecords(Integer recordId){
 	   ResponseStructure<Patient> response = new ResponseStructure<>();
	       response.setStatusCode(HttpStatus.FOUND.value());
	       response.setMessage("Patient by Medical Record fetched successfully.");
	       response.setData(patientDao.fetchPatientByMedicalRecords(recordId));
	       return new ResponseEntity<ResponseStructure<Patient>>(response,HttpStatus.FOUND);
    }
    public ResponseEntity<ResponseStructure<Patient>> updatePatientInfo(Patient patient){
	       ResponseStructure<Patient> response = new ResponseStructure<>();
	       response.setStatusCode(HttpStatus.OK.value());
	       response.setMessage("Patients fetched successfully.");
	       response.setData(patientDao.updatePatientInfo(patient));
	       return new ResponseEntity<ResponseStructure<Patient>>(response,HttpStatus.OK);
   }
    public ResponseEntity<ResponseStructure<String>> deletePatientInfo(Integer patientId){
  	  ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Patient deleted successfully.");
        response.setData("Deleted");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
}

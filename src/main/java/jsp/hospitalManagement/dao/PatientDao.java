package jsp.hospitalManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.hospitalManagement.entity.Department;
import jsp.hospitalManagement.entity.Doctor;
import jsp.hospitalManagement.entity.Patient;
import jsp.hospitalManagement.exception.IdNotFoundException;
import jsp.hospitalManagement.exception.NoAppointmentFoundException;
import jsp.hospitalManagement.exception.NoMedicalRecordFoundException;
import jsp.hospitalManagement.exception.NoPatientFoundException;
import jsp.hospitalManagement.repository.patientRepository;

@Repository
public class PatientDao {
     @Autowired
     private patientRepository patientRepo;
     public Patient registerPatient(Patient patient) {
    	    return patientRepo.save(patient);
     }
     public List<Patient> fetchAllPatients(){
    	    return patientRepo.findAll();
     }
     public Patient fetchPatientById(Integer id) {
    	 Optional<Patient> opt = patientRepo.findById(id);
		 if(opt.isPresent()) {
				return opt.get();
		 }
			else {
				throw new IdNotFoundException("Id does not exist in DB.");	
			} 
     }
     public Patient fetchPatientByPhoneNo(String phone) {
    	 Optional<Patient> opt = patientRepo.findByPhone(phone);
    	 if(opt.isPresent()) {
    		    return opt.get();
    	 }
    	 else {
    		 throw new NoPatientFoundException("Patient with phone number doesn't exist.");
    	 }
     }
     public List<Patient> fetchPatientWhereAgeIsGreaterThan(Integer age){
    	    List<Patient> pt = patientRepo.findByAgeIsGreaterThan(age);
    	    if(pt.isEmpty()) {
    	    	 throw new NoPatientFoundException("Patient with age " + age +"greater than no found.");
    	    }
    	    return pt;
     }
     public Patient fetchPatientByAppointment(Integer appointmentId){
    	    Optional<Patient> opt = patientRepo.findByAppointments_AppointmentId(appointmentId);
    	    if(opt.isPresent()) {
    	    	 return opt.get();
    	    }
    	    else {
    	    	throw new NoAppointmentFoundException("Patient with appointment id " + appointmentId +" doesn't found.");
    	    }
     }
     public Patient fetchPatientByMedicalRecords(Integer recordId) {
    	   Patient patient = patientRepo.findPatientByMedicalRecordId(recordId);
    	   if(patient != null) {
    		   return patient;
    	   }
    	   else {
    		     throw new NoMedicalRecordFoundException("Medical record not found.");
    	   }
     }
     public Patient updatePatientInfo(Patient patient) {
    	 if(patient.getPatientId() == null) {
	    	 throw new IdNotFoundException("Id does not exist in DB.");
	     }
	     Optional<Patient> opt = patientRepo.findById(patient.getPatientId());
	     if(opt.isPresent()) {
	    	 return patientRepo.save(patient);
	     }
	     else {
	    	 throw new IdNotFoundException("Id does not exist in DB.");
	     }
     }
     public void deletePatientInfo(Integer patientId) {
 		 Optional<Patient> opt = patientRepo.findById(patientId);
 		 if(opt.isPresent()) {
 			  patientRepo.delete(opt.get());
 		 }
 		 else {
 			 throw new IdNotFoundException("Id does not exist in DB.");
 		 }
 	 }
     
}

package jsp.hospitalManagement.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.hospitalManagement.entity.Appointment;
import jsp.hospitalManagement.entity.Doctor;
import jsp.hospitalManagement.entity.MedicalRecord;
import jsp.hospitalManagement.entity.Patient;
import jsp.hospitalManagement.exception.IdNotFoundException;
import jsp.hospitalManagement.exception.NoAppointmentFoundException;
import jsp.hospitalManagement.exception.NoMedicalRecordFoundException;
import jsp.hospitalManagement.repository.appointmentRepository;
import jsp.hospitalManagement.repository.doctorRepository;
import jsp.hospitalManagement.repository.medicalRecordRepository;
import jsp.hospitalManagement.repository.patientRepository;

@Repository
public class MedicalRecordDao {

      @Autowired
      private medicalRecordRepository medicalRecordRepo;
      @Autowired
      private doctorRepository doctorRepo;
      @Autowired
      private appointmentRepository appointmentRepo;
      @Autowired
      private patientRepository patientRepo;
      public List<MedicalRecord> createRecord(List<MedicalRecord> records) {
    	  for(MedicalRecord record : records){

              Integer doctorId = record.getDoctor().getDoctorId();
              Integer patientId = record.getPatient().getPatientId();

              Doctor doctor = doctorRepo.findById(doctorId).get();
              Patient patient = patientRepo.findById(patientId).get();

              record.setDoctor(doctor);
              record.setPatient(patient);
          }
    	     return medicalRecordRepo.saveAll(records);
      }
      public List<MedicalRecord> fetchAllRecord(){
    	     List<MedicalRecord> records = medicalRecordRepo.findAll();
    	     if(records.isEmpty()) {
    	    	  throw new NoMedicalRecordFoundException("No medical record found.");
    	     }
    	     return records;
     }
     public MedicalRecord fetchRecordById(Integer id) {
    	    Optional<MedicalRecord> opt = medicalRecordRepo.findById(id);
	        if(opt.isPresent()) {
	    	     return opt.get();
	          }
	        else {
	    	     throw new IdNotFoundException("Id doesn't exist in DB.");
	         }
     }
     public List<MedicalRecord> fetchRecordByPatient(Integer patientId){
            List<MedicalRecord> list = medicalRecordRepo.findByPatientPatientId(patientId);
            if(list.isEmpty()){
    	        throw new NoMedicalRecordFoundException("No medical records found for this patient");
    	    }
            return list;
    }
     public List<MedicalRecord> fetchRecordByDoctor(Integer doctorId){
            List<MedicalRecord> list = medicalRecordRepo.findByDoctorDoctorId(doctorId);
            if(list.isEmpty()){
    	        throw new NoMedicalRecordFoundException("No medical records found for this doctor");
    	    }
            return list;
    }
     public MedicalRecord fetchRecordByAppointment(Integer appointmentId){
            Optional<Appointment> opt = appointmentRepo.findById(appointmentId);

         if(opt.isEmpty()){
             throw new NoAppointmentFoundException("Appointment not found");
         }

         Appointment appointment = opt.get();

         Integer patientId = appointment.getPatient().getPatientId();
         Integer doctorId = appointment.getDoctor().getDoctorId();

         Optional<MedicalRecord> record = medicalRecordRepo.findByPatientAndDoctor(patientId, doctorId);

         if(record.isEmpty()){
             throw new NoMedicalRecordFoundException("Medical record not found for this appointment");
         }
         return record.get();
     }
     public List<MedicalRecord> fetchRecordByVisitDate(LocalDate visitDate){
            List<MedicalRecord> list = medicalRecordRepo.findByVisitDate(visitDate);
            if(list.isEmpty()){
    	        throw new NoMedicalRecordFoundException("No medical records found on this date");
    	    }
            return list;
    	}
      
      public void deleteAllRecords() {
          medicalRecordRepo.deleteAll();
      }
}

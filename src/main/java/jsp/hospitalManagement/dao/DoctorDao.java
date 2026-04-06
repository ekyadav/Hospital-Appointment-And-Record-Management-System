package jsp.hospitalManagement.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.hospitalManagement.entity.Department;
import jsp.hospitalManagement.entity.Doctor;
import jsp.hospitalManagement.exception.IdNotFoundException;
import jsp.hospitalManagement.exception.NoAppointmentFoundException;
import jsp.hospitalManagement.exception.NoDoctorFoundException;
import jsp.hospitalManagement.exception.NoPatientFoundException;
import jsp.hospitalManagement.exception.NoSpecializationFoundException;
import jsp.hospitalManagement.repository.doctorRepository;

@Repository
public class DoctorDao {
	  @Autowired
	  private doctorRepository doctorRepo;
	  
      public Doctor addDoctor(Doctor doctor) {
    	     return doctorRepo.save(doctor);
      }
      public List<Doctor> getAllDoctors(){
    	  return doctorRepo.findAll();
      }
      public Doctor fetchDoctorById(Integer id) {
    	  Optional<Doctor> opt = doctorRepo.findById(id);
 		 if(opt.isPresent()) {
 				return opt.get();
 		 }
 			else {
 				throw new IdNotFoundException("Id does not exist in DB.");	
 			} 
      }
      public List<Doctor> fetchDoctorsBySpecialization(String specialization){
             List<Doctor> spec = doctorRepo.findBySpecialization(specialization);
                if(spec.isEmpty()) {
            	  throw new NoSpecializationFoundException("Specialization does not exist.");
             }
             return spec;
      }
      public List<Doctor> fetchDoctorsInADepartment(Integer departmentId){
    	     List<Doctor> doctor = doctorRepo.findByDepartmentDepartmentId(departmentId);
    	     if(doctor.isEmpty()) {
    	    	 throw new NoDoctorFoundException("Doctor does not exist in department.");
    	     }
    	     return doctor;
      }
      public List<Doctor> fetchDoctorByPatient(Integer patientId){
    	     List<Doctor> patient = doctorRepo.findByAppointmentsPatientPatientId(patientId);
    	     if(patient.isEmpty()) {
    	    	 throw new NoPatientFoundException("Patient does not exist in DB.");
    	     }
    	     return patient;
      }
      public Doctor fetchDoctorByAppointment(Integer appointmentId){
    	     Doctor doctor = doctorRepo.findByAppointments_AppointmentId(appointmentId);
    	     if(doctor == null) {
    	    	 throw new NoAppointmentFoundException("Appointment does not exist in DB.");
    	     }
    	     return doctor;
      }
      public List<Doctor> fetchDoctorByAvailableDays(LocalDate date){
             List<Doctor> doctors = doctorRepo.findByAvailableDays(date);
             if(doctors.isEmpty()){
                  throw new NoDoctorFoundException("No doctors available on this date");
              }
             return doctors;
      }
      public Doctor updateDoctorInfo(Doctor doctor) {
    	     if(doctor.getDoctorId() == null) {
    	    	 throw new IdNotFoundException("Id does not exist in DB.");
    	     }
    	     Optional<Doctor> opt = doctorRepo.findById(doctor.getDoctorId());
    	     if(opt.isPresent()) {
    	    	 return doctorRepo.save(doctor);
    	     }
    	     else {
    	    	 throw new IdNotFoundException("Id does not exist in DB.");
    	     }
      }
      public void deleteDoctor(Integer doctorId) {
 		 Optional<Doctor> opt = doctorRepo.findById(doctorId);
 		 if(opt.isPresent()) {
 			  doctorRepo.delete(opt.get());
 		 }
 		 else {
 			 throw new IdNotFoundException("Id does not exist in DB.");
 		 }
 	 }
}

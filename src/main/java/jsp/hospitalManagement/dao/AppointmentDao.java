package jsp.hospitalManagement.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.hospitalManagement.entity.Appointment;
import jsp.hospitalManagement.entity.Doctor;
import jsp.hospitalManagement.entity.Patient;
import jsp.hospitalManagement.exception.IdNotFoundException;
import jsp.hospitalManagement.exception.InvalidAppointmentStateException;
import jsp.hospitalManagement.exception.NoAppointmentFoundException;
import jsp.hospitalManagement.repository.appointmentRepository;
import jsp.hospitalManagement.repository.doctorRepository;
import jsp.hospitalManagement.repository.patientRepository;

@Repository
public class AppointmentDao {
       @Autowired
       private appointmentRepository appointmentRepo;
       @Autowired
       private doctorRepository doctorRepo;
       @Autowired
       private patientRepository patientRepo;
       public List<Appointment> bookAppointment(List<Appointment> appointments) {
    	   for(Appointment appointment : appointments){
    		// Fetch Doctor from DB
    	        Doctor doctor = doctorRepo.findById(appointment.getDoctor().getDoctorId())
    	                .orElseThrow(() -> new RuntimeException("Doctor not found"));

    	        // Fetch Patient from DB
    	        Patient patient = patientRepo.findById(appointment.getPatient().getPatientId())
    	                .orElseThrow(() -> new RuntimeException("Patient not found"));

    	        appointment.setDoctor(doctor);
    	        appointment.setPatient(patient);

    	        // Business logic: patient cannot have two appointments in same day
    	        LocalDate date = appointment.getAppointDateTime().toLocalDate();

    	        LocalDateTime start = date.atStartOfDay();
    	        LocalDateTime end = date.atTime(23,59,59);

    	        boolean exists = appointmentRepo.existsByPatientPatientIdAndAppointDateTimeBetween(appointment.getPatient().getPatientId(),start,end);

    	        if(exists){
    	            throw new RuntimeException("Patient already has an appointment on this day.");
    	        }
    	        
    	     // Doctor validation
    	        boolean doctorExists =
    	        appointmentRepo.existsByDoctorDoctorIdAndAppointDateTime(appointment.getDoctor().getDoctorId(),appointment.getAppointDateTime());

    	        if(doctorExists){
    	            throw new RuntimeException("Doctor already has appointment at this time.");
    	        }
    	    }
    	      return appointmentRepo.saveAll(appointments);
       }
       public List<Appointment> fetchAllAppointments(){
    	      List<Appointment> apts = appointmentRepo.findAll();
    	      if(apts.isEmpty()) {
    	    	  throw new NoAppointmentFoundException("No appointment exist in DB.");
    	      }
    	     return apts;
       }
       public Appointment fetchAppointmentById(Integer id) {
    	      Optional<Appointment> opt = appointmentRepo.findById(id);
    	      if(opt.isPresent()) {
    	    	  return opt.get();
    	      }
    	      else {
    	    	  throw new IdNotFoundException("Id doesn't exist in DB.");
    	      }
       }
       public List<Appointment> fetchAppointmentByDate(LocalDateTime date){
    	      return appointmentRepo.findByAppointDateTime(date);
       }
       public List<Appointment> fetchAppointmentByDoctor(Integer doctorId){
    	      List<Appointment> apts = appointmentRepo.findByDoctorDoctorId(doctorId);
    	      if(apts.isEmpty()) {
    	    	  throw new NoAppointmentFoundException("No appointments found for this doctor.");
    	      }
    	      return apts;
       }
       public List<Appointment> fetchAppointmentByPatient(Integer patientId){
              List<Appointment> list = appointmentRepo.findByPatientPatientId(patientId);
              if(list.isEmpty()){
    	        throw new NoAppointmentFoundException("No appointments found for this patient.");
    	       }
               return list;
    	}
       public List<Appointment> fetchAppointmentByStatus(String status){
              List<Appointment> list = appointmentRepo.findByStatus(status);
              if(list.isEmpty()){
    	        throw new NoAppointmentFoundException("No appointments found with status: " + status);
    	      }
              return list;
    	}
       public Appointment cancelAppointment(Integer appointmentId){
              Optional<Appointment> optional = appointmentRepo.findById(appointmentId);
              if(optional.isEmpty()){
    	        throw new NoAppointmentFoundException("Appointment not found");
    	      }
               Appointment appointment = optional.get();
    	      if(appointment.getStatus().equals("COMPLETED")){
    	        throw new RuntimeException("Completed appointment cannot be cancelled");
    	      }
    	     if(appointment.getStatus().equals("CANCELLED")){
    	        throw new InvalidAppointmentStateException("Appointment already cancelled");
    	     }

            appointment.setStatus("CANCELLED");
            return appointmentRepo.save(appointment);
    	}
       public Appointment updateAppointmentStatus(Integer id, String status) {
              Optional<Appointment> opt = appointmentRepo.findById(id);
              if(opt.isEmpty()){
    	            throw new IdNotFoundException("Appointment not found");
    	      }
             Appointment appointment = opt.get();
    	    if(appointment.getStatus().equalsIgnoreCase("COMPLETED")){
    	        throw new InvalidAppointmentStateException("Completed appointment cannot be updated");
    	    }
    	    if(appointment.getStatus().equalsIgnoreCase("CANCELLED")){
    	        throw new InvalidAppointmentStateException("Cancelled appointment cannot be updated");
    	    }
    	    appointment.setStatus(status.toUpperCase());
            return appointmentRepo.save(appointment);
    	}
       //for correcting mistake of duplicates
       public void deleteAppointment(Integer appointmentId) {
    	      Optional<Appointment> opt = appointmentRepo.findById(appointmentId);

    	      if(opt.isEmpty()){
    	    	  appointmentRepo.delete(opt.get());
    	       }
    	      else {
    	   			 throw new IdNotFoundException("Id does not exist in DB.");
    	   		 }
    	}
     
       
}

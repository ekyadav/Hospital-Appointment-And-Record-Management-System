package jsp.hospitalManagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.hospitalManagement.dao.DoctorDao;
import jsp.hospitalManagement.entity.Doctor;
@Service
public class DoctorService {
      @Autowired
      private DoctorDao doctorDao;
      
      public ResponseEntity<ResponseStructure<Doctor>> addDoctor(Doctor doctor){
    	     ResponseStructure<Doctor> response = new ResponseStructure<>();
    	     response.setStatusCode(HttpStatus.OK.value());
    	     response.setMessage("Doctor added successfully.");
    	     response.setData(doctorDao.addDoctor(doctor));
    	     return new ResponseEntity<ResponseStructure<Doctor>>(response,HttpStatus.OK);
      }
      
      public ResponseEntity<ResponseStructure<List<Doctor>>> getAllDoctors(){
 	     ResponseStructure<List<Doctor>> response = new ResponseStructure<>();
 	     response.setStatusCode(HttpStatus.FOUND.value());
 	     response.setMessage("All Doctor fetched successfully.");
 	     response.setData(doctorDao.getAllDoctors());
 	     return new ResponseEntity<ResponseStructure<List<Doctor>>>(response,HttpStatus.FOUND);
      }
      public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorById( Integer id){
  	    ResponseStructure<Doctor> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.FOUND.value());
	        response.setMessage("Doctor by Id fetched successfully.");
	        response.setData(doctorDao.fetchDoctorById(id));
	        return new ResponseEntity<ResponseStructure<Doctor>>(response,HttpStatus.FOUND);
      }
      public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorsBySpecialization(String specialization){
  	    ResponseStructure<List<Doctor>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.FOUND.value());
	        response.setMessage("All Doctor with specialization fetched successfully.");
	        response.setData(doctorDao.fetchDoctorsBySpecialization(specialization));
	        return new ResponseEntity<ResponseStructure<List<Doctor>>>(response,HttpStatus.FOUND);
      }
      public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorsInADepartment(Integer departmentId){
         ResponseStructure<List<Doctor>> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Doctors in department fetched successfully.");
            response.setData(doctorDao.fetchDoctorsInADepartment(departmentId));
            return new ResponseEntity<>(response,HttpStatus.OK);
      }
      public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByPatient(Integer patientId){
    	  ResponseStructure<List<Doctor>> response = new ResponseStructure<>();
          response.setStatusCode(HttpStatus.OK.value());
          response.setMessage("Doctor by patient fetched successfully.");
          response.setData(doctorDao.fetchDoctorByPatient(patientId));
          return new ResponseEntity<>(response,HttpStatus.OK);
      }
      public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorByAppointment(Integer appointmentId){
    	  ResponseStructure<Doctor> response = new ResponseStructure<>();
          response.setStatusCode(HttpStatus.FOUND.value());
          response.setMessage("Doctor by patient fetched successfully.");
          response.setData(doctorDao.fetchDoctorByAppointment(appointmentId));
          return new ResponseEntity<>(response,HttpStatus.FOUND);
      }
      public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByAvailableDays(LocalDate date){
    	  ResponseStructure<List<Doctor>> response = new ResponseStructure<>();
          response.setStatusCode(HttpStatus.OK.value());
          response.setMessage("Doctor by available days fetched successfully.");
          response.setData(doctorDao.fetchDoctorByAvailableDays(date));
          return new ResponseEntity<>(response,HttpStatus.OK);
      }
      public ResponseEntity<ResponseStructure<Doctor>> updateDoctorInfo(Doctor doctor){
    	  ResponseStructure<Doctor> response = new ResponseStructure<>();
          response.setStatusCode(HttpStatus.OK.value());
          response.setMessage("Updated doctor information successfully.");
          response.setData(doctorDao.updateDoctorInfo(doctor));
          return new ResponseEntity<>(response,HttpStatus.OK);
      }
      public ResponseEntity<ResponseStructure<String>> deleteDoctor(Integer doctorId){
    	  ResponseStructure<String> response = new ResponseStructure<>();
          response.setStatusCode(HttpStatus.OK.value());
          response.setMessage("Doctor deleted successfully.");
          response.setData("Deleted");
          return new ResponseEntity<>(response,HttpStatus.OK);
      }
      
}

package jsp.hospitalManagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.hospitalManagement.dao.AppointmentDao;
import jsp.hospitalManagement.entity.Appointment;
import jsp.hospitalManagement.repository.appointmentRepository;

@Service
public class AppointmentService {
       @Autowired
       private AppointmentDao appointmentDao;
       @Autowired
       private appointmentRepository appointmentRepo;
       
       public ResponseEntity<ResponseStructure<List<Appointment>>> bookAppointment(List<Appointment> appointment){
    	      ResponseStructure<List<Appointment>> response = new ResponseStructure<>();
    	      response.setStatusCode(HttpStatus.CREATED.value());
    	      response.setMessage("Appointment booked successfully.");
    	      response.setData(appointmentDao.bookAppointment(appointment));
    	      return new ResponseEntity<ResponseStructure<List<Appointment>>>(response,HttpStatus.CREATED);    
       }
       public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAllAppointments(){
 	          ResponseStructure<List<Appointment>> response = new ResponseStructure<>();
 	          response.setStatusCode(HttpStatus.FOUND.value());
 	          response.setMessage("All Appointments fetched successfully.");
 	          response.setData(appointmentDao.fetchAllAppointments());
 	          return new ResponseEntity<ResponseStructure<List<Appointment>>>(response,HttpStatus.FOUND);
 	      
       }
       public ResponseEntity<ResponseStructure<Appointment>> fetchAppointmentById(Integer id){
	          ResponseStructure<Appointment> response = new ResponseStructure<>();
	          response.setStatusCode(HttpStatus.FOUND.value());
	          response.setMessage("Appointment fetched by Id successfully.");
	          response.setData(appointmentDao.fetchAppointmentById(id));
	          return new ResponseEntity<ResponseStructure<Appointment>>(response,HttpStatus.FOUND);
	      
      }
       public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByDate(LocalDateTime date){
	          ResponseStructure<List<Appointment>> response = new ResponseStructure<>();
	          response.setStatusCode(HttpStatus.FOUND.value());
	          response.setMessage("All Appointments by date fetched successfully.");
	          response.setData(appointmentDao.fetchAppointmentByDate(date));
	          return new ResponseEntity<ResponseStructure<List<Appointment>>>(response,HttpStatus.FOUND);
	      
      }
       public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByDoctor(Integer DoctorId){
	          ResponseStructure<List<Appointment>> response = new ResponseStructure<>();
	          response.setStatusCode(HttpStatus.FOUND.value());
	          response.setMessage("All Appointments by doctor fetched successfully.");
	          response.setData(appointmentDao.fetchAppointmentByDoctor(DoctorId));
	          return new ResponseEntity<ResponseStructure<List<Appointment>>>(response,HttpStatus.FOUND);
	      
      }
       public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByPatient(Integer patientId){
              ResponseStructure<List<Appointment>> response = new ResponseStructure<>();
              response.setStatusCode(HttpStatus.FOUND.value());
              response.setMessage("Appointments by patient fetched successfully.");
              response.setData(appointmentDao.fetchAppointmentByPatient(patientId));
              return new ResponseEntity<>(response, HttpStatus.FOUND);
    	}
       public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByStatus(String status){
              ResponseStructure<List<Appointment>> response = new ResponseStructure<>();
              response.setStatusCode(HttpStatus.FOUND.value());
    	      response.setMessage("Appointments by status fetched successfully.");
    	      response.setData(appointmentDao.fetchAppointmentByStatus(status));
              return new ResponseEntity<>(response, HttpStatus.FOUND);
    	}
       public ResponseEntity<ResponseStructure<Appointment>> cancelAppointment(Integer appointmentId){
              ResponseStructure<Appointment> response = new ResponseStructure<>();
              response.setStatusCode(HttpStatus.OK.value());
    	      response.setMessage("Appointment cancelled successfully.");
    	      response.setData(appointmentDao.cancelAppointment(appointmentId));
              return new ResponseEntity<>(response, HttpStatus.OK);
    	}
       public ResponseEntity<ResponseStructure<Appointment>> updateAppointmentStatus(Integer id, String status){
              ResponseStructure<Appointment> response = new ResponseStructure<>();
              response.setStatusCode(HttpStatus.OK.value());
    	      response.setMessage("Appointment status updated successfully");
    	      response.setData(appointmentDao.updateAppointmentStatus(id, status));
              return new ResponseEntity<>(response, HttpStatus.OK);
    	}
       public ResponseEntity<ResponseStructure<String>> deleteAppointment(Integer appointmentId){
    	    ResponseStructure<String> response = new ResponseStructure<>();
       	    response.setStatusCode(HttpStatus.OK.value());
    	    response.setMessage("Appointment deleted successfully.");
    	    response.setData("deleted");

    	    return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);
    	}
}

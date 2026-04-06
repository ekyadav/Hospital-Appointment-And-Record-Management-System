package jsp.hospitalManagement.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.hospitalManagement.dao.AppointmentDao;
import jsp.hospitalManagement.entity.Appointment;
import jsp.hospitalManagement.repository.appointmentRepository;
import jsp.hospitalManagement.service.AppointmentService;
import jsp.hospitalManagement.service.ResponseStructure;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	   @Autowired
       private appointmentRepository appointmentRepo;
       @Autowired
       private AppointmentService appointmentService;
       @PostMapping
       public ResponseEntity<ResponseStructure<List<Appointment>>> bookAppointment(@RequestBody List<Appointment> appointment){
    	      return appointmentService.bookAppointment(appointment);
       }
       @GetMapping("/all")
       public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAllAppointment(){
    	      return appointmentService.fetchAllAppointments();
    	}
       @GetMapping("/{id}")
       public ResponseEntity<ResponseStructure<Appointment>> fetchAppointmentById(@PathVariable("id") Integer id){
    	      return appointmentService.fetchAppointmentById(id);
       }
       @GetMapping("/date/{date}")
       public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByDate(@PathVariable("date") LocalDateTime date){
    	      return appointmentService.fetchAppointmentByDate(date);
       }
       @GetMapping("/doctor/{doctorId}")
       public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByDoctor(@PathVariable("doctorId") Integer doctorId){
    	      return appointmentService.fetchAppointmentByDoctor(doctorId);
      }
       @GetMapping("/patient/{patientId}")
       public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByPatient(@PathVariable Integer patientId){
              return appointmentService.fetchAppointmentByPatient(patientId);
       }
       @GetMapping("/status/{status}")
       public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByStatus(@PathVariable String status){
              return appointmentService.fetchAppointmentByStatus(status);
       }
       @PutMapping("/cancel/{appointmentId}")
       public ResponseEntity<ResponseStructure<Appointment>> cancelAppointment(@PathVariable Integer appointmentId){
              return appointmentService.cancelAppointment(appointmentId);
       }
       @PutMapping("/status/{id}/{status}")
       public ResponseEntity<ResponseStructure<Appointment>> updateAppointmentStatus(@PathVariable Integer id, @PathVariable String status){
              return appointmentService.updateAppointmentStatus(id, status);
       }
       @DeleteMapping("/{appointmentId}")
       public ResponseEntity<ResponseStructure<String>> deleteAppointment(@PathVariable Integer appointmentId){
              return appointmentService.deleteAppointment(appointmentId);
       }
}
       

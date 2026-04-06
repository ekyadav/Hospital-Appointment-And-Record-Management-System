package jsp.hospitalManagement.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {
     @Id
     @GeneratedValue( strategy = GenerationType.IDENTITY)
     private Integer appointmentId;
     private LocalDateTime appointDateTime;
     private String status;
     
     public Doctor getDoctor() {
		return doctor;
	}
	 public void setDoctor(Doctor doctor) {
		 this.doctor = doctor;
	 }
	 public Patient getPatient() {
		 return patient;
	 }
	 public void setPatient(Patient patient) {
		 this.patient = patient;
	 }
	 @ManyToOne
     @JoinColumn(name = "doctorId")
     private Doctor doctor;
     
     @ManyToOne
     @JoinColumn(name = "patientId")
     private Patient patient;

     
	 public Integer getAppointmentId() {
		 return appointmentId;
	 }
	 public void setAppointmentId(Integer appointmentId) {
		 this.appointmentId = appointmentId;
	 }
	 public LocalDateTime getAppointDateTime() {
		 return appointDateTime;
	 }
	 public void setAppointDateTime(LocalDateTime appointDateTime) {
		 this.appointDateTime = appointDateTime;
	 }
	 public String getStatus() {
		 return status;
	 }
	 public void setStatus(String status) {
		 this.status = status;
	 }
     
}

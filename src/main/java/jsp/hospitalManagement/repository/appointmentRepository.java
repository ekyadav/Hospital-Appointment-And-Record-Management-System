package jsp.hospitalManagement.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.hospitalManagement.entity.Appointment;
import jsp.hospitalManagement.entity.Doctor;

public interface appointmentRepository extends JpaRepository<Appointment,Integer> {
	   boolean existsByPatientPatientIdAndAppointDateTimeBetween(Integer patientId,LocalDateTime start,LocalDateTime end);
	   boolean existsByDoctorDoctorIdAndAppointDateTime(Integer doctorId,LocalDateTime appointDateTime);
	   List<Appointment> findByAppointDateTime(LocalDateTime appointDateTime);
	   List<Appointment> findByDoctorDoctorId(Integer doctorId);
	   List<Appointment> findByPatientPatientId(Integer patientId);
	   List<Appointment> findByStatus(String status);
}

package jsp.hospitalManagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.hospitalManagement.entity.Doctor;

public interface doctorRepository extends JpaRepository<Doctor,Integer> {
       
	List<Doctor> findBySpecialization(String specialization);
	List<Doctor> findByDepartmentDepartmentId(Integer departmentId);//findby+parent field + child field
	List<Doctor> findByAppointmentsPatientPatientId(Integer patientId);
	Doctor findByAppointments_AppointmentId(Integer appointmentId);
	List<Doctor> findByAvailableDays(LocalDate availableDays);
}

package jsp.hospitalManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import jsp.hospitalManagement.entity.MedicalRecord;
import jsp.hospitalManagement.entity.Patient;

public interface patientRepository extends JpaRepository<Patient,Integer>{
       Optional<Patient> findByPhone(String phone);
       List<Patient> findByAgeIsGreaterThan(Integer age);
       Optional<Patient> findByAppointments_AppointmentId(Integer appointmentId);
       @Query("SELECT m.patient FROM MedicalRecord m WHERE m.recordId = :recordId")
       Patient findPatientByMedicalRecordId(Integer recordId);
}

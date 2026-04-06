package jsp.hospitalManagement.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jsp.hospitalManagement.entity.MedicalRecord;

public interface medicalRecordRepository extends JpaRepository<MedicalRecord,Integer> {
	//to saveAll medical records
	/*@Query("SELECT m FROM MedicalRecord m JOIN FETCH m.doctor JOIN FETCH m.patient")
	List<MedicalRecord> findAllRecordsWithDoctorPatient();*/
	List<MedicalRecord> findByPatientPatientId(Integer patientId);
	
	List<MedicalRecord> findByDoctorDoctorId(Integer doctorId);
	
	@Query("SELECT m FROM MedicalRecord m WHERE m.patient.patientId = :patientId AND m.doctor.doctorId = :doctorId")
	Optional<MedicalRecord> findByPatientAndDoctor(@Param("patientId") Integer patientId, @Param("doctorId") Integer doctorId);
	
	List<MedicalRecord> findByVisitDate(LocalDate visitDate);
}

package jsp.hospitalManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.hospitalManagement.entity.Prescription;

public interface prescriptionRepository extends JpaRepository<Prescription,Integer> {
	   Optional<Prescription> findByMedicalRecordRecordId(Integer recordId);
	   List<Prescription> findByMedicalRecordPatientPatientId(Integer patientId);
}

package jsp.hospitalManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.hospitalManagement.entity.MedicalRecord;
import jsp.hospitalManagement.entity.Prescription;
import jsp.hospitalManagement.exception.NoMedicalRecordFoundException;
import jsp.hospitalManagement.exception.NoPatientFoundException;
import jsp.hospitalManagement.exception.NoPrescriptionFoundException;
import jsp.hospitalManagement.repository.medicalRecordRepository;
import jsp.hospitalManagement.repository.prescriptionRepository;

@Repository
public class PrescriptionDao {
     @Autowired
     private prescriptionRepository prescriptionRepo;
     @Autowired
     private medicalRecordRepository medicalRecordRepo;

     public Prescription createPrescription(Prescription prescription){

            Integer recordId = prescription.getMedicalRecord().getRecordId();
            // 1️⃣ Check Medical Record exists
            Optional<MedicalRecord> recordOpt = medicalRecordRepo.findById(recordId);
            if(recordOpt.isEmpty()){
                   throw new NoMedicalRecordFoundException("Medical record not found");
             }

             // 2️⃣ Check if already prescription exists
              Optional<Prescription> existing =
              prescriptionRepo.findByMedicalRecordRecordId(recordId);

             if(existing.isPresent()){
                    throw new RuntimeException("Prescription already exists for this medical record");
              }

              // 3️⃣ Set managed entity
               prescription.setMedicalRecord(recordOpt.get());
               // 4️⃣ Save
              return prescriptionRepo.save(prescription);
      }
     public List<Prescription> fetchAllPrescription() {
            List<Prescription> list = prescriptionRepo.findAll();
            if(list.isEmpty()) {
                  throw new RuntimeException("No prescriptions found");
             }
            return list;
     }
     public Prescription fetchPrescriptionById(Integer id) {
           Optional<Prescription> opt = prescriptionRepo.findById(id);
           if(opt.isPresent()) {
                return opt.get();
            } else {
                 throw new RuntimeException("Prescription ID not found");
         }
     }
     public Prescription fetchPrescriptionByMedicalRecord(Integer recordId) {
    	    Optional<Prescription> optional = prescriptionRepo.findByMedicalRecordRecordId(recordId);
            if(optional.isPresent()) {
             return optional.get();
             }
            throw new NoPrescriptionFoundException("Prescription not found for given medical record");
     }
     public List<Prescription> fetchPrescriptionByPatient(Integer patientId){
    	    List<Prescription> list = prescriptionRepo.findByMedicalRecordPatientPatientId(patientId);
    	    if(list.isEmpty()) {
    	    	throw new NoPatientFoundException("No prescription found for this patient.");
    	    }
    	    return list;
     }
     
}

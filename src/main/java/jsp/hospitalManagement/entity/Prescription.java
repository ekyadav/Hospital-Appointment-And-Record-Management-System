package jsp.hospitalManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Prescription {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer prescriptionId;
   private String medicine;
   private Integer dosage;
   private String instructions;
   

   @OneToOne
   @JoinColumn(name = "recordId")
   private MedicalRecord medicalRecord;
   
   public Integer getPrescriptionId() {
	return prescriptionId;
   }
   public void setPrescriptionId(Integer prescriptionId) {
	this.prescriptionId = prescriptionId;
   }
   public String getMedicine() {
	return medicine;
   }
   public void setMedicine(String medicine) {
	this.medicine = medicine;
   }
   public MedicalRecord getMedicalRecord() {
	return medicalRecord;
}
   public void setMedicalRecord(MedicalRecord medicalRecord) {
	this.medicalRecord = medicalRecord;
   }
   public Integer getDosage() {
	return dosage;
   }
   public void setDosage(Integer dosage) {
	this.dosage = dosage;
   }
   public String getInstructions() {
	return instructions;
   }
   public void setInstructions(String instructions) {
	this.instructions = instructions;
   }
   
}

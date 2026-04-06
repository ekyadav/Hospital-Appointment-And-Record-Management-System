package jsp.hospitalManagement.dto;

import java.time.LocalDate;

public class DoctorDto {
	private Integer doctorId;
    private String doctorName;
    private String specialization;
    private LocalDate availableDays;
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public LocalDate getAvailableDays() {
		return availableDays;
	}
	public void setAvailableDays(LocalDate availableDays) {
		this.availableDays = availableDays;
	}
    
}

package jsp.hospitalManagement.dto;

import java.time.LocalDateTime;

public class AppointmentDto {
	private Integer appointmentId;
    private LocalDateTime appointDateTime;
    private String status;
    
    private Integer doctorId;     
    public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	private Integer patientId; 
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

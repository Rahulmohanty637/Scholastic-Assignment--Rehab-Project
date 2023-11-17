package Model;

public class Appointment {
   String appointment_id, counselor_id, patient_name, date, time, duration, status;

public String getAppointment_id() {
	return appointment_id;
}

public void setAppointment_id(String appointment_id) {
	this.appointment_id = appointment_id;
}

public Appointment(String appointment_id, String counselor_id, String patient_name, String date, String time, String duration, String status) {
	super();
	this.appointment_id = appointment_id;
	this.counselor_id = counselor_id;
	this.patient_name = patient_name;
	this.date = date;
	this.time = time;
	this.duration = duration;
	this.status = status;
}

public String getCounselor_id() {
	return counselor_id;
}

public void setCounselor_id(String counselor_id) {
	this.counselor_id = counselor_id;
}

public String getPatient_name() {
	return patient_name;
}

public void setPatient_name(String patient_id) {
	this.patient_name = patient_id;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

public String getDuration() {
	return duration;
}

public void setDuration(String duration) {
	this.duration = duration;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
   
   
}

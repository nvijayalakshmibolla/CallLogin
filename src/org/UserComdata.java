package org;

public class UserComdata 
{
	private String 	Username;				//Username
	private String 	LoginId;				//LoginId
	private String 	CallEntryId;			//Call details entry code
	private String District;
	private String IncidentPlace;
	private String FromSubstation;
	private String ToSubstation;
	private String Vendor;
	private String Coordinator;
	private String Status;
	private long TicketNo;
	private String date;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getLoginId() {
		return LoginId;
	}
	public void setLoginId(String loginId) {
		LoginId = loginId;
	}
	
	
	public String getCallEntryId() {
		return CallEntryId;
	}
	public void setCallEntryId(String callEntryId) {
		CallEntryId = callEntryId;
	}
	
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	
	
	public String getIncidentPlace() {
		return IncidentPlace;
	}
	public void setIncidentPlace(String incidentPlace) {
		IncidentPlace = incidentPlace;
	}
	public String getFromSubstation() {
		return FromSubstation;
	}
	public void setFromSubstation(String fromSubstation) {
		FromSubstation = fromSubstation;
	}
	public String getToSubstation() {
		return ToSubstation;
	}
	public void setToSubstation(String toSubstation) {
		ToSubstation = toSubstation;
	}
	public long getTicketNo() {
		return TicketNo;
	}
	public void setTicketNo(long ticketNo) {
		TicketNo = ticketNo;
	}
	public String getVendor() {
		return Vendor;
	}
	public void setVendor(String vendor) {
		Vendor = vendor;
	}
	public String getCoordinator() {
		return Coordinator;
	}
	public void setCoordinator(String coordinator) {
		Coordinator = coordinator;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
}

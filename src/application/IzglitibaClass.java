package application;

import java.time.LocalDate;

public class IzglitibaClass {
	private String qualification;
	private String studyPlaceName;
	private String knowladge;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	
	public IzglitibaClass() {
	}
	
	public IzglitibaClass(String qualification, String studyPlaceName, String knowladge, LocalDate dateFrom,
			LocalDate dateTo) {
			setDateFrom(dateFrom);
			setDateTo(dateTo);
			setKnowladge(knowladge);
			setQualification(qualification);
			setStudyPlaceName(studyPlaceName);
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < qualification.length(); i++) {
	        char c = qualification.charAt(i);
	        if (Character.isAlphabetic(c)) {
	            builder.append(c);
	        }
	    }
	    qualification= builder.toString();
	    qualification=qualification.substring(0,1).toUpperCase()+qualification.substring(1).toLowerCase();
	this.qualification = qualification;
	}
	public String getStudyPlaceName() {
		return studyPlaceName;
	}
	public void setStudyPlaceName(String studyPlaceName) {
		this.studyPlaceName = studyPlaceName;
	}
	
	public String getKnowladge() {
		return knowladge;
	}
	public void setKnowladge(String knowladge) {
		
	this.knowladge = knowladge;
		
	}
	public LocalDate getDateFrom() {
		
		return dateFrom;
	}
	public void setDateFrom(LocalDate dateFrom) {
		
		this.dateFrom = dateFrom;
	}
	public LocalDate getDateTo() {
		return dateTo;
	}
	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}
	

}

package application;

import java.time.LocalDate;
import java.util.Date;

public class DarbaPieredzeClass {
	private int id;
	private String profession;
	private String workPlaceName;
	private String city;
	private String workDuties;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	
	
	public DarbaPieredzeClass() {
		
	}
	public DarbaPieredzeClass(String profession, String workPlaceName, String city, String workDuties, LocalDate dateFrom,
			LocalDate dateTo) {
		setProfession(profession);
		setCity(city);
		setDateFrom(dateFrom);
		setDateTo(dateTo);
		setWorkDuties(workDuties);
		setWorkPlaceName(workPlaceName);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < profession.length(); i++) {
	        char c = profession.charAt(i);
	        if (Character.isAlphabetic(c)) {
	            builder.append(c);
	        }
	    }
	    profession= builder.toString();
	  profession=profession.substring(0,1).toUpperCase()+profession.substring(1).toLowerCase();
	this.profession = profession;
	}
	public String getWorkPlaceName() {
		return workPlaceName;
	}
	public void setWorkPlaceName(String workPlaceName) {
		this.workPlaceName = workPlaceName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		StringBuilder builder = new StringBuilder();
	    for (int i = 0; i <city.length(); i++) {
	        char c = city.charAt(i);
	        if (Character.isAlphabetic(c)) {
	            builder.append(c);
	        }
	    }
	    city= builder.toString();
	  city=city.substring(0,1).toUpperCase()+city.substring(1).toLowerCase();
	this.city = city;
	}
	public String getWorkDuties() {
		return workDuties;
	}
	public void setWorkDuties(String workDuties) {
	this.workDuties = workDuties;
		
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

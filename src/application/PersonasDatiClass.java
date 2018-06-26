package application;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public  class PersonasDatiClass {
	
	int ID;
	String username;
	String password;
	String name;
	String surname;
	String address;
	String post_index;
	String city;
    String number;
	String mail;
	String country;
	String phoneType;
	
	
	
	
	public PersonasDatiClass() {
		setName("");
		setSurname("");
		setAddress("");
		setPost_index("");
		setCity("");
		setNumber("");
		setMail("");
		
	}
	
	public PersonasDatiClass(int ID,String username,String password,String name, String surname, String address, String post_index, String city, String number,
			String mail, String country, String phoneType) 
	{
		setID(ID);
		setUsername(username);
		setPassword(password);
		setName(name);
		setSurname(surname);
		setAddress(address);
		setPost_index(post_index);
		setCity(city);
		setNumber(number);
		setMail(mail);
		setCountry(country);
		setPhoneType(phoneType);
		
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		StringBuilder builder = new StringBuilder();
		if(name.length()>0) {
	    for (int i = 0; i <name.length(); i++) {
	        char c = name.charAt(i);
	        if (Character.isAlphabetic(c)) {
	            builder.append(c);
	        }
	    }
	    name= builder.toString();
	    name=name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
		}
	    this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		if(surname.length()>0) {
			StringBuilder builder = new StringBuilder();
		    for (int i = 0; i <surname.length(); i++) {
		        char c = surname.charAt(i);
		        if (Character.isAlphabetic(c)) {
		            builder.append(c);
		        }
		    }
		    surname= builder.toString();
		    surname=surname.substring(0,1).toUpperCase()+surname.substring(1).toLowerCase();
	}
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPost_index() {
		return post_index;
	}
	public void setPost_index(String post_index) {
		this.post_index = post_index;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		if(city.length()>0) {
			StringBuilder builder = new StringBuilder();
		    for (int i = 0; i <city.length(); i++) {
		        char c = city.charAt(i);
		        if (Character.isAlphabetic(c)) {
		            builder.append(c);
		        }
		    }
		    city= builder.toString();
		  city=city.substring(0,1).toUpperCase()+city.substring(1).toLowerCase();
		}
	  this.city = city;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}

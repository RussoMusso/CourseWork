package application;

import javafx.collections.ObservableList;

public class User {
	
	String username;
	String password;
	int ID;
	PersonasDatiClass personasDatiClass;
	ObservableList<IzglitibaClass> izglitibaList;
	ObservableList<DarbaPieredzeClass>pieredzeList;
	ObservableList<ValodasPrasmesClass>valodasList;
	CitasPrasmes1Class citasPrasmes1Class;
	CitasPrasmes2Class citasPrasmes2Class;
	
	public User() {
	}
	public User(String username, String password) {
		setPassword(password);
		setUsername(username);
		
	}
	
	
	
	public User(int ID,String username, String password, PersonasDatiClass personasDatiClass,
			ObservableList<IzglitibaClass> izglitibaList, ObservableList<DarbaPieredzeClass> pieredzeList,
			ObservableList<ValodasPrasmesClass> valodasList, CitasPrasmes1Class citasPrasmes1Class,
			CitasPrasmes2Class citasPrasmes2Class) {
		
		setID(ID);
		setCitasPrasmes1Class(citasPrasmes1Class);
		setCitasPrasmes2Class(citasPrasmes2Class);
		setIzglitibaList(izglitibaList);
		setPassword(password);
		setPersonasDatiClass(personasDatiClass);
		setPieredzeList(pieredzeList);
		setUsername(username);
		setValodasList(valodasList);
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public PersonasDatiClass getPersonasDatiClass() {
		return personasDatiClass;
	}
	public void setPersonasDatiClass(PersonasDatiClass personasDatiClass) {
		this.personasDatiClass = personasDatiClass;
	}
	
	public CitasPrasmes1Class getCitasPrasmes1Class() {
		return citasPrasmes1Class;
	}
	public void setCitasPrasmes1Class(CitasPrasmes1Class citasPrasmes1Class) {
		this.citasPrasmes1Class = citasPrasmes1Class;
	}
	public CitasPrasmes2Class getCitasPrasmes2Class() {
		return citasPrasmes2Class;
	}
	public void setCitasPrasmes2Class(CitasPrasmes2Class citasPrasmes2Class) {
		this.citasPrasmes2Class = citasPrasmes2Class;
	}
	public ObservableList<IzglitibaClass> getIzglitibaList() {
		return izglitibaList;
	}
	public void setIzglitibaList(ObservableList<IzglitibaClass> izglitibaList) {
		this.izglitibaList = izglitibaList;
	}
	public ObservableList<DarbaPieredzeClass> getPieredzeList() {
		return pieredzeList;
	}
	public void setPieredzeList(ObservableList<DarbaPieredzeClass> pieredzeList) {
		this.pieredzeList = pieredzeList;
	}
	public ObservableList<ValodasPrasmesClass> getValodasList() {
		return valodasList;
	}
	public void setValodasList(ObservableList<ValodasPrasmesClass> valodasList) {
		this.valodasList = valodasList;
	}
	
	
	
	
	
	/*
	String username;
	String password;
	String name;
	String surname;
	String address;
	String post_index;
	String city;
	*/
}

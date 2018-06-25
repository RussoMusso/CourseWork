package application;

public class CitasPrasmes1Class {
	String komunikacijasPrasmes;
	String organizatoriskasPrasmes;
	
	public CitasPrasmes1Class() {
		
	}
	public CitasPrasmes1Class(String komunikacijasPrasmes, String organizatoriskasPrasmes) {
		setKomunikacijasPrasmes(komunikacijasPrasmes);
		setOrganizatoriskasPrasmes(organizatoriskasPrasmes);
	}
	public String getKomunikacijasPrasmes() {
		return komunikacijasPrasmes;
	}
	public void setKomunikacijasPrasmes(String komunikacijasPrasmes) {
		this.komunikacijasPrasmes = komunikacijasPrasmes;
	}
	public String getOrganizatoriskasPrasmes() {
		return organizatoriskasPrasmes;
	}
	public void setOrganizatoriskasPrasmes(String organizatoriskasPrasmes) {
		this.organizatoriskasPrasmes = organizatoriskasPrasmes;
	}
	
	
}

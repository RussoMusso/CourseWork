package application;

public class ValodasPrasmesClass {

	public enum Marks {
	    A1,A2,B1,B2,C1,C2;
	}
	private String valoda,veids,klausisanas,lasisana,dialogs,monologs,rakstisana,diplomi;
	private int id;
	public ValodasPrasmesClass() {
		
	}
	
	
	
	public ValodasPrasmesClass(String valoda, String veids, String klausisanas, String lasisana, String dialogs,
			String monologs, String rakstisana,String diplomi) {
		setValoda(valoda);
		setDialogs(dialogs);
		setKlausisanas(klausisanas);
		setLasisana(lasisana);
		setMonologs(monologs);
		setRakstisana(rakstisana);
		setVeids(veids);
		setDiplomi(diplomi);
		
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDiplomi() {
		return diplomi;
	}

	public void setDiplomi(String diplomi) {
		this.diplomi = diplomi;
	}

	public String getValoda() {
		return valoda;
	}
	public void setValoda(String valoda) {
		StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < valoda.length(); i++) {
	        char c = valoda.charAt(i);
	        if (Character.isAlphabetic(c)) {
	            builder.append(c);
	        }
	    }
	    valoda= builder.toString();
	    valoda=valoda.substring(0,1).toUpperCase()+valoda.substring(1).toLowerCase();
		this.valoda = valoda;
	}
	public String getVeids() {
		return veids;
	}
	public void setVeids(String veids) {
		StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < veids.length(); i++) {
	        char c = veids.charAt(i);
	        if (Character.isAlphabetic(c)) {
	            builder.append(c);
	        }
	    }
	    veids= builder.toString();
	    veids=veids.substring(0,1).toUpperCase()+veids.substring(1).toLowerCase();
		this.veids = veids;
	}
	public String getKlausisanas() {
		return klausisanas;
	}
	public void setKlausisanas(String klausisanas) {
		for (Marks c : Marks.values()) {
	        if (c.name().equals(klausisanas)) {
	        	this.klausisanas = klausisanas;
	        	break;
	        }
	    }
		
		this.klausisanas = klausisanas;
	}
	public String getLasisana() {
		return lasisana;
	}
	public void setLasisana(String lasisana) {
		for (Marks c : Marks.values()) {
	        if (c.name().equals(lasisana)) {
	        	this.lasisana = lasisana;
	        	break;
	        }
	    }
		
		this.lasisana=lasisana;
	}
	public String getDialogs() {
		return dialogs;
	}
	public void setDialogs(String dialogs) {
		for (Marks c : Marks.values()) {
	        if (c.name().equals(dialogs)) {
	        	this.dialogs = dialogs;
	        	break;
	        }
	    }
	
		
		this.dialogs = dialogs;
	}
	public String getMonologs() {
		return monologs;
	}
	public void setMonologs(String monologs) {
		for (Marks c : Marks.values()) {
	        if (c.name().equals(monologs)) {
	        	this.monologs = monologs;
	        	break;
	        }
	    }
		
		
		this.monologs = monologs;
	}
	public String getRakstisana() {
		return rakstisana;
	}
	public void setRakstisana(String rakstisana) {
		for (Marks c : Marks.values()) {
	        if (c.name().equals(rakstisana)) {
	        	this.rakstisana = rakstisana;
	        	break;
	        }
	    }
		
		this.rakstisana = rakstisana;
	}
	
	
	
	
}

package application;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase implements Serializable{
	
	static Connection con = null;
	static Statement stmt = null;

	
	public  DataBase() throws ClassNotFoundException, SQLException {
		createConnection();
		stmt = con.createStatement();		   
	}
	
	public  static void createConnection() throws ClassNotFoundException, SQLException {
		//Ielade SQL un izveido connection
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:mydatabase.sqlite");
		//createAndInsertDB();
		//con.close();
	}
	
	//set Personal Data from database to system
	public static void getPersonalData(String username) throws SQLException, ClassNotFoundException {
		
		createConnection();
		stmt = con.createStatement();
		
		//stmt.executeUpdate("SELECT * FROM PersonalData WHERE username='"  +username+ "'");
		ResultSet rs=stmt.executeQuery("SELECT * FROM PersonalData WHERE username='"  +username+ "'");
		String usern="",password="",name="",surname="",address="",mail="",city="",number="",phoneType="",country="",post_index="";
		List<String> details = new ArrayList<>(Arrays.asList(usern,password,name,surname,address,mail,city,number,phoneType,country,post_index));
		int ID;
		if(rs.next()) {
			ID=rs.getInt(1);
			for(int i=2;i<13;i++) {
				if(rs.getString(i)==null) {
					System.out.println(i);
					
				}else {
					details.set(i-2, rs.getString(i));
					System.out.println(details.get(i-2));
				}
			}
		
		PersonasDatiController.persona.setID(ID);
		PersonasDatiController.persona.setUsername(details.get(0));
		PersonasDatiController.persona.setPassword(details.get(1));
		PersonasDatiController.persona.setName(details.get(2));
		PersonasDatiController.persona.setSurname(details.get(3));
		PersonasDatiController.persona.setAddress(details.get(4));
		PersonasDatiController.persona.setMail(details.get(5));
		PersonasDatiController.persona.setCity(details.get(6));
		PersonasDatiController.persona.setNumber(details.get(7));
		PersonasDatiController.persona.setPhoneType(details.get(8));
		PersonasDatiController.persona.setCountry(details.get(9));	
		PersonasDatiController.persona.setPost_index(details.get(10));
		
		con.close();
		
		}
	}
	
	//set personal data from system into database
public static void setPersonalData(String user) throws SQLException, ClassNotFoundException {
	
		createConnection();
		stmt = con.createStatement();
		
		String query="" ;
		String sql = "SELECT * FROM PersonalData where username='"+user+"';";
		 
		 ResultSet rs = stmt.executeQuery(sql);
		 if(!rs.next()) {
	    	  query=" INSERT INTO PersonalData(name, surname,address,mail,city,"
	    	  		+ "number,phoneType,country,post_index)" + 
	    	  		") VALUES(?,?,?,?,?,?,?,?,?);";
	      }
	      else {
	    	  query = "UPDATE PersonalData SET name=?, surname=?,address=?,mail=?,city=?,number=?,phoneType=?,country=?,post_index=?  WHERE username=?;";
	 		 
	  		
	      }
	
		 PreparedStatement pstmt = con.prepareStatement(query);
            // set the corresponding param
            pstmt.setString(1,PersonasDatiController.persona.getName() );
            pstmt.setString(2,PersonasDatiController.persona.getSurname() );
            pstmt.setString(3,PersonasDatiController.persona.getAddress() );
            pstmt.setString(4,PersonasDatiController.persona.getMail() );
            pstmt.setString(5,PersonasDatiController.persona.getCity() );
            pstmt.setString(6,PersonasDatiController.persona.getNumber() );
            pstmt.setString(7,PersonasDatiController.persona.getPhoneType() );
            pstmt.setString(8,PersonasDatiController.persona.getCountry() );
            pstmt.setString(9,PersonasDatiController.persona.getPost_index() );
            pstmt.setString(10,user);
 
            // update 
            pstmt.executeUpdate();
            con.close();
			
}	
//get citasPrasmes1 from database into system
public static void getCitasPrasmes1Data(int user_ID) throws SQLException, ClassNotFoundException {
	createConnection();
	stmt = con.createStatement();
	
	//stmt.executeUpdate("SELECT * FROM PersonalData WHERE username='"  +username+ "'");
	ResultSet rs=stmt.executeQuery("SELECT * FROM CitasPrasmes1 WHERE userID='"  +user_ID+ "'");
	String komunikacija="",organizacija="";
	List<String> details = new ArrayList<>(Arrays.asList(komunikacija,organizacija));
	if(rs.next()) {
		
		for(int i=2;i<4;i++) {
			if(rs.getString(i)==null) {
				System.out.println(i);
				
			}else {
				details.set(i-2, rs.getString(i));
				System.out.println(details.get(i-2));
			}
		}
	}
	CitasPrasmes1Controller.prasmes1.setKomunikacijasPrasmes(details.get(0));
	CitasPrasmes1Controller.prasmes1.setOrganizatoriskasPrasmes(details.get(1));
	
	con.close();
}
//set citasPrasmes1 from system into database
public static void setCitasPrasmes1(int user_ID) throws SQLException, ClassNotFoundException {
		
	createConnection();
	stmt = con.createStatement();
	String query="";
	 String sql = "SELECT * FROM CitasPrasmes1 where userID="+user_ID+";";
	 
      ResultSet rs = stmt.executeQuery(sql);
      if(!rs.next()) {
    	  query=" INSERT INTO CitasPrasmes1(komunikacija,organizacija,userID) VALUES(?,?,?);";
      }
      else {
    	  query = "UPDATE CitasPrasmes1 SET komunikacija=?, organizacija=? WHERE userID=?;";
  		
      }
      PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,CitasPrasmes1Controller.prasmes1.getKomunikacijasPrasmes());
        pstmt.setString(2,CitasPrasmes1Controller.prasmes1.getOrganizatoriskasPrasmes());
        pstmt.setInt(3,user_ID);
        pstmt.executeUpdate();
        con.close();
			
}	
//set citasPrasmes2 from database into system
public static void getCitasPrasmes2Data(int user_ID) throws SQLException, ClassNotFoundException {
	createConnection();
	stmt = con.createStatement();
	
	ResultSet rs=stmt.executeQuery("SELECT * FROM CitasPrasmes2 WHERE userID='"  +user_ID+ "'");
	String datora="",saistitas="";
	List<String> details = new ArrayList<>(Arrays.asList(datora,saistitas));
	if(rs.next()) {
		
		for(int i=2;i<4;i++) {
			if(rs.getString(i)==null) {
				System.out.println(i);
				
			}else {
				details.set(i-2, rs.getString(i));
				System.out.println(details.get(i-2));
			}
		}
	}
	CitasPrasmes2Controller.prasmes2.setDatorprasmes(details.get(0));
	CitasPrasmes2Controller.prasmes2.setSaistitasPrasmes(details.get(1));
	
	con.close();
}
//set citasPrasmes2 from system into database
public static void setCitasPrasmes2(int user_ID) throws SQLException, ClassNotFoundException {
		
		createConnection();
		stmt = con.createStatement();
		String query="";
		 String sql = "SELECT * FROM CitasPrasmes2 where userID="+user_ID+";";
		 
	      ResultSet rs = stmt.executeQuery(sql);
	      if(!rs.next()) {
	    	  query=" INSERT INTO CitasPrasmes2(datora,saistitas,userID) VALUES(?,?,?);";
	      }
	      else {
	    	  query = "UPDATE CitasPrasmes2 SET datora=?, saistitas=? WHERE userID=?;";
	  		
	      }
	      PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1,CitasPrasmes2Controller.prasmes2.getDatorprasmes());
	        pstmt.setString(2,CitasPrasmes2Controller.prasmes2.getSaistitasPrasmes());
	        pstmt.setInt(3,user_ID);
	        pstmt.executeUpdate();
	        con.close();
}	
//set Izglitiba from database into system
public static void getIzglitiba(int user_ID) throws SQLException, ClassNotFoundException {
	createConnection();
	stmt = con.createStatement();
	
	ResultSet rs=stmt.executeQuery("SELECT * FROM Izglitiba WHERE userID='"  +user_ID+ "';");
	
	LocalDate date;
	while(rs.next()) {
		IzglitibaClass obj= new IzglitibaClass();
		obj.setID(rs.getInt(1));
		obj.setStudyPlaceName(rs.getString(2));
		obj.setQualification(rs.getString(3));
		obj.setKnowladge(rs.getString(4));
		obj.setDateFrom(Instant.ofEpochMilli(rs.getDate(5).getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
		//obj.setDateFrom(rs.getDate(5).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		obj.setDateTo(Instant.ofEpochMilli(rs.getDate(6).getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
		IzglitibaAizpildiController.study.add(obj);
	}
	con.close();
}

//set Izglitiba from system into database
public static void setIzglitiba(int user_ID) throws SQLException, ClassNotFoundException {
	createConnection();
	stmt = con.createStatement();
	String query=" INSERT INTO Izglitiba(place,qualification,knowladge,dateFrom,dateTo,userID) VALUES(?,?,?,?,?,?);";
	PreparedStatement pstmt = con.prepareStatement(query);
	Date date;
	int len=IzglitibaAizpildiController.study.size()-1;
	pstmt.setString(1,IzglitibaAizpildiController.study.get(len).getStudyPlaceName());
    pstmt.setString(2,IzglitibaAizpildiController.study.get(len).getQualification());
    pstmt.setString(3,IzglitibaAizpildiController.study.get(len).getKnowladge());
    pstmt.setDate(4,date = java.sql.Date.valueOf(IzglitibaAizpildiController.study.get(len).getDateFrom()));
    pstmt.setDate(5,date = java.sql.Date.valueOf(IzglitibaAizpildiController.study.get(len).getDateTo()));
    System.out.println(java.sql.Date.valueOf(IzglitibaAizpildiController.study.get(len).getDateTo()));
    pstmt.setInt(6,user_ID);
    
    pstmt.executeUpdate();
    con.close();
	
}
//set Pieredze from database into system
public static void getPieredze(int user_ID) throws SQLException, ClassNotFoundException {
	createConnection();
	stmt = con.createStatement();
	
	ResultSet rs=stmt.executeQuery("SELECT * FROM Pieredze WHERE userID='"  +user_ID+ "';");
	
	LocalDate date;
	while(rs.next()) {
		DarbaPieredzeClass obj= new DarbaPieredzeClass();
		obj.setId(rs.getInt(1));
		obj.setProfession(rs.getString(2));
		obj.setWorkPlaceName(rs.getString(3));
		obj.setCity(rs.getString(4));
		obj.setWorkDuties(rs.getString(5));
		obj.setDateFrom(Instant.ofEpochMilli(rs.getDate(6).getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
		//obj.setDateFrom(rs.getDate(5).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		obj.setDateTo(Instant.ofEpochMilli(rs.getDate(7).getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
		DarbaPieredzeAizpildiController.experience.add(obj);
	}
	con.close();
}
//set Pieredze from system into database
public static void setPieredze(int user_ID) throws SQLException, ClassNotFoundException {
	createConnection();
	stmt = con.createStatement();
	String query=" INSERT INTO Pieredze(profession,place,city,duties,dateFrom,dateTo,userID) VALUES(?,?,?,?,?,?,?);";
	PreparedStatement pstmt = con.prepareStatement(query);
	Date date;
	int len=DarbaPieredzeAizpildiController.experience.size()-1;
	pstmt.setString(1,DarbaPieredzeAizpildiController.experience.get(len).getProfession());
    pstmt.setString(2,DarbaPieredzeAizpildiController.experience.get(len).getWorkPlaceName());
    pstmt.setString(3,DarbaPieredzeAizpildiController.experience.get(len).getCity());
    pstmt.setString(4,DarbaPieredzeAizpildiController.experience.get(len).getWorkDuties());
    pstmt.setDate(5,date = java.sql.Date.valueOf(DarbaPieredzeAizpildiController.experience.get(len).getDateFrom()));
    pstmt.setDate(6,date = java.sql.Date.valueOf(DarbaPieredzeAizpildiController.experience.get(len).getDateTo()));
    System.out.println(java.sql.Date.valueOf(DarbaPieredzeAizpildiController.experience.get(len).getDateTo()));
    pstmt.setInt(7,user_ID);
    
    pstmt.executeUpdate();
    con.close();
	
}

public static void getValodas(int user_ID) throws SQLException, ClassNotFoundException {
	createConnection();
	stmt = con.createStatement();
	
	ResultSet rs=stmt.executeQuery("SELECT * FROM Valodas WHERE userID='"  +user_ID+ "';");
	
	LocalDate date;
	while(rs.next()) {
		ValodasPrasmesClass obj= new ValodasPrasmesClass();
		obj.setId(rs.getInt(1));
		obj.setValoda(rs.getString(2));
		obj.setVeids(rs.getString(3));
		obj.setKlausisanas(rs.getString(4));
		obj.setLasisana(rs.getString(5));
		obj.setDialogs(rs.getString(6));
		obj.setMonologs(rs.getString(7));
		obj.setRakstisana(rs.getString(8));
		obj.setDiplomi(rs.getString(9));
		ValodasPrasmesAizpildiController.valodas.add(obj);
	}
	con.close();
}
//set Valodas from system into database
public static void setValodas(int user_ID) throws SQLException, ClassNotFoundException {
	createConnection();
	stmt = con.createStatement();
	String query=" INSERT INTO Valodas(valoda,veids,klausisanas,lasisana,dialogs,monologs,rakstisana,diplomi,userID) VALUES(?,?,?,?,?,?,?,?,?);";
	PreparedStatement pstmt = con.prepareStatement(query);
	int len=ValodasPrasmesAizpildiController.valodas.size()-1;
	pstmt.setString(1,ValodasPrasmesAizpildiController.valodas.get(len).getValoda());
    pstmt.setString(2,ValodasPrasmesAizpildiController.valodas.get(len).getVeids());
    pstmt.setString(3,ValodasPrasmesAizpildiController.valodas.get(len).getKlausisanas());
    pstmt.setString(4,ValodasPrasmesAizpildiController.valodas.get(len).getLasisana());
    pstmt.setString(5,ValodasPrasmesAizpildiController.valodas.get(len).getDialogs());
    pstmt.setString(6,ValodasPrasmesAizpildiController.valodas.get(len).getMonologs());
    pstmt.setString(7,ValodasPrasmesAizpildiController.valodas.get(len).getRakstisana());
    pstmt.setString(8,ValodasPrasmesAizpildiController.valodas.get(len).getDiplomi());
    pstmt.setInt(9,user_ID);
    
    pstmt.executeUpdate();
    con.close();
	
}

///Delete objects from database
public static void deleteIzglitiba(int id) throws SQLException, ClassNotFoundException {
	createConnection();
	stmt = con.createStatement();
	String query=" DELETE FROM Izglitiba WHERE ID=?;";
	PreparedStatement pstmt = con.prepareStatement(query);
	pstmt.setInt(1,id );
    pstmt.executeUpdate();
    con.close();
}
public static void deletePieredze(int id) throws SQLException, ClassNotFoundException {
	createConnection();
	stmt = con.createStatement();
	String query=" DELETE FROM Pieredze WHERE ID=?;";
	PreparedStatement pstmt = con.prepareStatement(query);
	pstmt.setInt(1,id );
    pstmt.executeUpdate();
    con.close();
}
public static void deleteValodas(int id) throws SQLException, ClassNotFoundException {
	createConnection();
	stmt = con.createStatement();
	String query=" DELETE FROM Valodas WHERE ID=?;";
	PreparedStatement pstmt = con.prepareStatement(query);
	pstmt.setInt(1,id );
    pstmt.executeUpdate();
    con.close();
}
	
public static void insertLoginData(String name, String pass) throws SQLException, ClassNotFoundException {
		createConnection();
		stmt = con.createStatement();
		stmt.executeUpdate("INSERT INTO PersonalData (username , password)" + 
				" VALUES ('"+name+"', '"+pass+"');");
	}

	
//checks if database have given username and password at same row 
public static boolean verifyUser(String username, String pass) throws SQLException, ClassNotFoundException {
	createConnection();
	stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM PersonalData WHERE username='"+username+"'AND password='"+pass+"'");
		if(rs.next()) {
			return true;
			
		}else {
			return false;
		}
	
	}
//check if given username is in database
public static boolean checkUsername(String username) throws SQLException, ClassNotFoundException {
	createConnection();
	stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM PersonalData WHERE username='"+username+"';");
		if(rs.next()) {
			con.close();
			return true;
		}else {
			con.close();
			return false;
		}
	
	}
	
}




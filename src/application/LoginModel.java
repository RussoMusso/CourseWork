package application;

import java.sql.*;

public class LoginModel {
	public static Connection connection;
	/*
	public LoginModel() {
		connection=DataBase.Connector();
		if(connection==null) {
			System.exit(1);
		}
	}
	public boolean isDbConnected() {
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	*/
	public boolean isLogin(String user, String pass) throws SQLException {
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String query="SELECT * FROM employee WHERE username=? AND password=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				//String q="SELECT * FROM employee WHERE password=?";
				//resultSet=preparedStatement.executeQuery();
				PersonasDatiController.persona.setName("RRRRRRRRRRR");;
		
				
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		finally {
			preparedStatement.close();
			resultSet.close();
		}
	}
	public void set() throws SQLException {
		Statement st=null ;
		ResultSet results = st.executeQuery("SELECT * FROM employee WHERE password=?");
		String res="";
		String query="SELECT * FROM employee WHERE password=?";
		while (results.next()) {
			String nameR = results.getString("name");
			String surnameR = results.getString("surname");
			
			System.out.println(nameR + " " + surnameR );
		}

		
	}
	
}

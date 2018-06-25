package application;

import java.sql.SQLException;
import java.util.ArrayList;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class KryoServerListener extends Listener {
	public static ArrayList<Connection> connections = new ArrayList();
	
	public void connected(Connection connection) {
		System.out.println("SERVER>>Someone is connected " + connection.getID());
		connections.add(connection);
		System.out.println("SERVER>>Sending students to "+connection.getID());
		//KryoServer.getAndSendStudents(connection);
	}
	
	public void disconnected(Connection connection) {
		System.out.println("SERVER>>Someone disconnected " + connection.getID());
		connections.remove(connection);
	}
	
	public void received(Connection connection, Object object) {
		
	}
}


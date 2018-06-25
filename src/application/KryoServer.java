package application;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;



public class KryoServer {
	static DataBase db;
	public void configureAndStartServer() throws IOException {
		//1. create server
		Server server = new Server();
		//2. open port
		server.bind(8000);
		//3.add listener
		KryoServerListener kServListener = new KryoServerListener();
		server.addListener(kServListener);
		//4. register classes
		Kryo kryo = server.getKryo();
		kryo.register(ArrayList.class);
		server.start();
	}
	
	public void insertStudents() throws ClassNotFoundException, SQLException {
		
		db = new DataBase();
		
	}
	
}

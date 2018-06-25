package application;

import java.util.ArrayList;
import java.util.Scanner;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;


public class KryoClientListener extends Listener{
	public void connected(Connection connection) {
		System.out.println("CLIENT>>Someone is connected " + connection.getID());
	}
	public void disconnected(Connection connection) {
		System.out.println("CLIENT>>Someone disconnected " + connection.getID());
	}
	public void received(Connection connection, Object object) {
		/*(object instanceof Packet) {
			System.out.println("CLIENT>>Recieved packet");
			Packet res = (Packet) object;
			System.out.println("CLIENT>>Making packet");
			ArrayList<Student> studentList = res.studentList;
			System.out.println("CLIENT>>Getting stud list");
			//System.out.println("CLIENT>>"+ res);
			Packet pack = new Packet();
			pack.studentList=fillGrades(studentList);
			connection.sendTCP(pack);
			System.out.println("CLIENT>>Sending stud list back to server");
		}*/
	}
	
}


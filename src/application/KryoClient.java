package application;

import java.io.IOException;
import java.util.ArrayList;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;



public class KryoClient {
	public void configureAndStartClient() throws IOException, InterruptedException {
		//1. client
		Client client = new Client();
		//2. add listener
		KryoClientListener kClientListener = new KryoClientListener();
		client.addListener(kClientListener);
		//3. register classes
		Kryo kryo = client.getKryo();
		//kryo.register(Packet.class);
		//kryo.register(ArrayList.class);
		//kryo.register(Student.class);
		//4. start client
		client.start();
		//5. connect to server
		client.connect(5000, "127.0.0.1", 8000);
		while (true) {
			Thread.sleep(100);
		}
	}
}


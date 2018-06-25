package application;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PersonasDatiController implements Initializable{
	
	
	public static PersonasDatiClass persona = new PersonasDatiClass();
	public static PersonasDatiClass retrievePersona() {
		return persona;
	}
	
	
	 ObservableList<String> phoneTypes = FXCollections.observableArrayList(
				"Mobilais",
				"Darba",
				"Mājas"
				);
		 ObservableList<String> countries = Stream.of(Locale.getISOCountries())
		        .map(locales -> new Locale("", locales))
		        .map(Locale::getDisplayCountry)
		        .collect(Collectors.toCollection(FXCollections::observableArrayList));
		 
		 ObservableList<String> LatvianCities = FXCollections.observableArrayList();
		 
		@FXML
		public TextField name;
		@FXML
		private TextField surname;
		@FXML
		private  TextField address;
		@FXML
		private  TextField post_index;
		@FXML
		private  TextField city;
		@FXML
		private  ChoiceBox<String> cityChoice = new ChoiceBox<>() ;
		
		@FXML
		private  TextField number;
		@FXML
		private  TextField mail;
		@FXML
		private  Label PersonasDatiWarningText;
		@FXML
		private  ChoiceBox<String> country = new ChoiceBox<>() ;
		@FXML
		private  ChoiceBox<String>phoneType = new ChoiceBox<>();
		@FXML
		private Button nextPage = new Button();
		@FXML
		private Button but = new Button();
		
		
		
		@FXML
		public String returnInput(){
			ArrayList<String> arr = new ArrayList<>();
			arr.add(name.getText());
			System.out.println(name.getText());
			return name.getText();
		}
		
		
		
		
	
	public void initialize(URL url, ResourceBundle rb) {
		
		
		//name.setText(persona.getUsername());
		System.out.println("lll");
		//System.out.println(DataBase.getPersonalData("S").getName());
		//name.setText(DataBase.getPersonalData("S").getName().toString());
		//name.setText(MainController.user1.getPersonasDatiClass().getName());
		
		name.setText(persona.getName());
		surname.setText(persona.getSurname());
		address.setText(persona.getAddress());
		mail.setText(persona.getMail());
		city.setText(persona.getCity());
		cityChoice.setValue((persona.getCity()));
	
		number.setText(persona.getNumber());
		phoneType.setValue(persona.getPhoneType());
		country.setValue(persona.getCountry());
		post_index.setText(persona.getPost_index());
		
		try {
			initializeCountries();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			readIntoList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		} 
	public void use() throws ClassNotFoundException, SQLException {
		
	}

	
	
	
	
	@FXML
	private void readIntoList() throws IOException {
		
		try {
			FileReader reader = new FileReader(new File("pilsetas.txt"));
			Scanner scan = new Scanner(reader);
			while(scan.hasNextLine()){
				System.out.println(scan.nextLine());
				LatvianCities.add(scan.nextLine());
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error Reading File");
			e.printStackTrace();
		}


		
	}
	@FXML
	private boolean checkIfLatvia() throws IOException {
	
		if(country.getValue().contains("Austria")) {
			city.setText("");
			city.setVisible(false);
			cityChoice.setVisible(true);
			return true;
			
		}else {
			city.setVisible(true);
			cityChoice.setVisible(false);
			return false;
		}
		
	}
	@FXML
	private void initializeCountries() throws IOException {
		cityChoice.setItems(LatvianCities);
		phoneType.setItems(phoneTypes);
		country.setItems(countries);	
	}
	
	
	
	

	@FXML
	private  void getPersonasDati(ActionEvent event) throws IOException, ClassNotFoundException, SQLException  {
		int count=0;
		for(int i=0; i<number.getText().length();i++) {
			char c =number.getText().toString().charAt(i);
			if(!Character.isDigit(c)) {
				count++;
			}
		}
		
		PersonasDatiWarningText.setText("");
		if(name.getText().equals("") || surname.getText().equals("")  || (city.getText().equals("")&& cityChoice.getValue()==null) || address.getText().equals("") || post_index.getText().equals("") || mail.getText().equals("")|| number.getText().equals("") || country.getValue()==null|| phoneType.getValue()==null )
		{
			PersonasDatiWarningText.setText("*Lūdzu aizpildiet visus laukus");
		}
		else if(!mail.getText().contains("@")) {
			PersonasDatiWarningText.setText("*Lūdzu ievadiet korektu e-mailu");
		}
		else if(number.getText().length()!=8 || count>0) {
			PersonasDatiWarningText.setText("*Lūdzu ievadiet korektu telefona numuru");
		}
		else {
			persona.setSurname(surname.getText());
			persona.setPost_index(post_index.getText());
			persona.setPhoneType(phoneType.getValue().toString());
			persona.setNumber(number.getText());
			persona.setName(name.getText());
			persona.setMail(mail.getText());
			persona.setCountry(country.getValue().toString());
			if(checkIfLatvia()==false) {
				persona.setCity(city.getText());
			}else {
				persona.setCity(cityChoice.getValue().toString());
			}
			persona.setAddress(address.getText());
			MainController.user1.setPersonasDatiClass(persona);
			System.out.println(persona.getUsername());
			DataBase.setPersonalData(persona.getUsername());
			DataBase.getCitasPrasmes1Data(persona.getID());
			DataBase.getCitasPrasmes2Data(persona.getID());
			DataBase.getIzglitiba(persona.getID());
			DataBase.getPieredze(persona.getID());
			DataBase.getValodas(persona.getID());
			System.out.println(IzglitibaAizpildiController.study);
			MainController.counter++;
			Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
			Scene _scene = new Scene(_page);
			Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(_scene);
			app_stage.show();
			
			
			//PersonasDatiClass persona = new PersonasDatiClass(name.getText(), surname.getText(), address.getText(), post_index.getText(), city.getText(), Integer.parseInt(number.getText()), mail.getText(), country.getValue().toString(), phoneType.getValue().toString());
		}

		/*
		writtenAddress+=address.getText();
		writtenCity=city.getText();
		writtenCountry= country.getValue().toString();
		writtenMail=mail.getText();
		writtenNumber=number.getText();
		writtenPhoneType=phoneType.getValue().toString();
		writtenPostIndex=post_index.getText();
		writtenSurname=surname.getText();
		System.out.println(writtenAddress+writtenCity+writtenCountry+writtenMail+writtenName+writtenNumber+writtenPhoneType+writtenPostIndex+writtenSurname);
		*/
	}
	
	/*
	public static void setValues() {
		name.setText(persona.getName());
		surname.setText(persona.getSurname());
		address.setText(persona.getAddress());
		mail.setText(persona.getMail());
		city.setText(persona.getCity());
		String num=""+persona.getNumber();
		number.setText(num);
		//phoneType.setValue(persona.getPhoneType());
		//country.setValue(persona.getCountry());
		post_index.setText(persona.getPost_index());
		
	}
	*/

	
}

package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CitasPrasmes2Controller implements Initializable {
	
public static CitasPrasmes2Class prasmes2= new CitasPrasmes2Class("","");

public static CitasPrasmes2Class retrieveCitasPrasmes2() {
	return prasmes2;
}
//initialize all fields  with written parameters
//when user leaves page and later comes back to the page these fields will be filled with previously given values
	
public void initialize(URL url, ResourceBundle rb) {
	datorPrasmes.setText(prasmes2.getDatorprasmes());
	saistitasPrasmes.setText(prasmes2.getSaistitasPrasmes());
	} 


	@FXML
	private Button NextPage = new Button();
	@FXML
	private Button PreviousPage = new Button();
	
	@FXML
	private TextArea datorPrasmes;
	@FXML
	private TextArea saistitasPrasmes;
	@FXML
	private Label CitasPrasmes2WarningText;
	
	
	//checks if all fields are filled and if they are filled then it set given values to object and goes to next page
	//if all fields are not filled then it shows error text under all fields
		
	@FXML
	private  void getCitasPrasmes2(ActionEvent event) throws IOException  {
		CitasPrasmes2WarningText.setText("");
		if(datorPrasmes.getText().equals("") || saistitasPrasmes.getText().equals("")) {
			CitasPrasmes2WarningText.setText("*Lūdzu aizpildiet visus laukus");
		}
		else {
			prasmes2.setDatorprasmes(datorPrasmes.getText());
			prasmes2.setSaistitasPrasmes(saistitasPrasmes.getText());
			System.out.println(prasmes2.getDatorprasmes());
			try {
				DataBase.setCitasPrasmes2(PersonasDatiController.persona.getID());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MainController.user1.setCitasPrasmes2Class(prasmes2);
			MainController.counter++;
			Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
			Scene _scene = new Scene(_page);
			Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(_scene);
			app_stage.show();
		}
	}
	//goes to prevoius page
	@FXML
	private  void goToCitasPrasmes(ActionEvent event) throws IOException  {
		prasmes2.setDatorprasmes(datorPrasmes.getText());
		prasmes2.setSaistitasPrasmes(saistitasPrasmes.getText());
		System.out.println(prasmes2.getDatorprasmes());
		try {
			DataBase.setCitasPrasmes2(PersonasDatiController.persona.getID());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainController.user1.setCitasPrasmes2Class(prasmes2);
		MainController.counter--;
		Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
		Scene _scene = new Scene(_page);
		Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(_scene);
		app_stage.show();
	}
}

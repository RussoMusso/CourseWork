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
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CitasPrasmes1Controller implements Initializable {
	
	public static CitasPrasmes1Class prasmes1= new CitasPrasmes1Class("","");
	
	public static CitasPrasmes1Class retrieveCitasPrasmes1() {
		return prasmes1;
	}
	
	//initialize all fields  with written parameters
	//when user leaves page and later comes back to the page these fields will be filled with previously given values
	public void initialize(URL url, ResourceBundle rb) {
		orgPrasmes.setText(prasmes1.getOrganizatoriskasPrasmes());
		komPrasmes.setText(prasmes1.getKomunikacijasPrasmes());
		} 
	
	
	@FXML
	private Button NextPage = new Button();
	@FXML
	private Button PreviousPage = new Button();
	@FXML
	private TextArea komPrasmes;
	@FXML
	private TextArea orgPrasmes;
	@FXML
	private Label CitasPrasmes1WarningText;
	
	//checks if all fields are filled and if they are filled then it set given values to object and goes to next page
	//if all fields are not filled then it shows error text under all fields
	@FXML
	private  void getCitasPrasmes1(ActionEvent event) throws IOException  {
		CitasPrasmes1WarningText.setText("");
		if(komPrasmes.getText().equals("") || orgPrasmes.getText().equals("")) {
			CitasPrasmes1WarningText.setText("*Lūdzu aizpildiet visus laukus");
		}
		else {
			prasmes1.setKomunikacijasPrasmes(komPrasmes.getText());
			prasmes1.setOrganizatoriskasPrasmes(orgPrasmes.getText());
			MainController.user1.setCitasPrasmes1Class(prasmes1);
			try {
			
				DataBase.setCitasPrasmes1(PersonasDatiController.persona.getID());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	private  void goToValodasPrasmes(ActionEvent event) throws IOException  {
		prasmes1.setKomunikacijasPrasmes(komPrasmes.getText());
		prasmes1.setOrganizatoriskasPrasmes(orgPrasmes.getText());
		//MainController.user1.setCitasPrasmes1Class(prasmes1);
		System.out.println(PersonasDatiController.persona.getID());
		try {
			DataBase.setCitasPrasmes1(PersonasDatiController.persona.getID());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainController.counter--;
		MainController.counter--;
		Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
		Scene _scene = new Scene(_page);
		Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(_scene);
		app_stage.show();
	}
}

package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController {
	
	
	@FXML
	private Button loginButton = new Button();
	@FXML
	private Hyperlink register = new Hyperlink();
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Label LoginWarningText;
	
	@FXML
	private void goToRegister(ActionEvent event) throws IOException, SQLException, ClassNotFoundException  {
		MainController.counter++;
		FXMLLoader loader = new FXMLLoader();
		Pane _page= loader.load(getClass().getResource(Main.pages.get(MainController.counter)));
		Scene _scene = new Scene(_page);
		Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(_scene);
		app_stage.show();
	}
	
	
	@FXML
	private void LoginCheck(ActionEvent event) throws IOException, SQLException, ClassNotFoundException  {
		LoginWarningText.setText("");
		
		try {
			if(DataBase.verifyUser(username.getText(), password.getText())) {
				
				DataBase.getPersonalData(username.getText());
				//PersonasDatiController.persona.setUsername(username.getText());
				MainController.counter++;
				MainController.counter++;
				FXMLLoader loader = new FXMLLoader();
				Pane _page= loader.load(getClass().getResource(Main.pages.get(MainController.counter)));
				Scene _scene = new Scene(_page);
				Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
				app_stage.setScene(_scene);
				app_stage.show();
			}
			else if(username.getText().equals("") || password.getText().equals("") ){
				LoginWarningText.setText("*Lūdzu aizpildiet visus laukus");
			}else {
				LoginWarningText.setText("*Nepareizs lietotājvārds un/vai parole");
			}
		} catch (Exception e) {
			// TODO: handle exception
			LoginWarningText.setText("*Nepareizs lietotājvārds un/vai parole");
		}
		
		
		
	}
}

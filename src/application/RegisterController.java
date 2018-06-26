package application;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
	
	@FXML
	private Button registerButton = new Button();
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private PasswordField passwordRepeat;
	@FXML
	private Label RegisterWarningText;

	
	
@FXML
private void RegisterCheck(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
	RegisterWarningText.setText("");
	if(username.getText().equals("") || password.getText().equals("") || passwordRepeat.getText().equals("")){
		RegisterWarningText.setText("*Lūdzu aizpildiet visus laukus");
	}
	else if(!password.getText().equals(passwordRepeat.getText())) {
		RegisterWarningText.setText("*Jūsu paroles nesakrīt!!");
	}
	else if(DataBase.checkUsername(username.getText())) {
		RegisterWarningText.setText("*Lietotājvārds ir jau aizņemts!!");
	}
		
	else {
			//DataBase db= new DataBase();
			//DataBase.createAndInsertDB();
			DataBase.insertLoginData(username.getText(),password.getText());
			MainController.user1.setPassword(password.getText());
			MainController.user1.setUsername(username.getText());
			System.out.println(MainController.user1.getUsername());
			MainController.counter--;
			Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
			Scene _scene = new Scene(_page);
			Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(_scene);
			app_stage.show();
			
		}
}
}

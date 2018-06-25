package application;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DarbaPieredzeAizpildiController {
	public static ObservableList<DarbaPieredzeClass> experience = FXCollections.observableArrayList();
	
	@FXML
	private TextField PieredzeWorkPlaceName;
	@FXML
	private TextField PieredzeCity;
	@FXML
	private TextField PieredzeProffession;
	@FXML
	private TextArea PieredzeDuties;
	@FXML
	private DatePicker PieredzeDateFrom;
	@FXML
	private DatePicker PieredzeDateTo;
	@FXML
	private Label PieredzeWarningText;
	
	
	//checks if all fields are filled and if they are filled then it set given values to object and goes to next page
	//if all fields are not filled then it shows error text under all fields	
	@FXML
	private void makePieredzeDatiObject(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
		PieredzeWarningText.setText("");
		if(PieredzeCity.getText().equals("") || PieredzeDuties.getText().equals("") || PieredzeProffession.getText().equals("") || PieredzeWorkPlaceName.getText().equals("") ||PieredzeDateFrom.getValue()==null|| PieredzeDateTo.getValue()==null )
		{
			PieredzeWarningText.setText("*Lūdzu aizpildiet visus laukus");
		}
		else if(PieredzeDateFrom.getValue().isAfter(PieredzeDateTo.getValue()) ||  PieredzeDateFrom.getValue().isAfter(LocalDate.now()) ||  PieredzeDateTo.getValue().isAfter(LocalDate.now()) ) {
			PieredzeWarningText.setText("*Lūdzu ievadiet pareizi datuma laukus");
		}
		else {
			DarbaPieredzeClass obj = new DarbaPieredzeClass(PieredzeProffession.getText(), PieredzeWorkPlaceName.getText(), PieredzeCity.getText(),PieredzeDuties.getText(), PieredzeDateFrom.getValue(), PieredzeDateTo.getValue());
			experience.add(obj);
			DataBase.setPieredze(PersonasDatiController.persona.getID());
			MainController.user1.setPieredzeList(experience);
			System.out.println(experience);
			
			MainController.counter--;
			Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
			Scene _scene = new Scene(_page);
			Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(_scene);
			app_stage.show();
			
		}
		
	}
	//goes to prevoius page
	@FXML
	private void goBack(ActionEvent event) throws IOException {
		MainController.counter--;
		Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
		Scene _scene = new Scene(_page);
		Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(_scene);
		app_stage.show();
	}
	
	
}

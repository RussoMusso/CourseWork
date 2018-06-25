package application;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.util.Calendar;

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

public class IzglitibaAizpildiController {
	
	public static ObservableList<IzglitibaClass> study = FXCollections.observableArrayList();
	
	@FXML
	private TextField IzglitibaStudyPlaceName;
	@FXML
	private TextField IzglitibaQualification;
	@FXML
	private TextArea IzglitibaKnowladge;
	@FXML
	private DatePicker IzglitibaDateFrom;
	@FXML
	private DatePicker IzglitibaDateTo;
	@FXML
	private Label IzglitibaWarningText;
	
	
	
	
	
	@FXML
	private void makeIzglitibaDatiObject(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
		IzglitibaWarningText.setText("");
		if(IzglitibaQualification.getText().equals("") || IzglitibaStudyPlaceName.getText().equals("") || IzglitibaKnowladge.getText().equals("") || IzglitibaDateTo.getValue()==null|| IzglitibaDateFrom.getValue()==null )
		{
			IzglitibaWarningText.setText("*Lūdzu aizpildiet visus laukus");
		}
		else if(IzglitibaDateFrom.getValue().isAfter(IzglitibaDateTo.getValue()) ||  IzglitibaDateFrom.getValue().isAfter(LocalDate.now()) ||  IzglitibaDateTo.getValue().isAfter(LocalDate.now()) ) {
			IzglitibaWarningText.setText("*Lūdzu ievadiet pareizi datuma laukus");
		}
		else {
			IzglitibaClass obj = new IzglitibaClass(IzglitibaQualification.getText(), IzglitibaStudyPlaceName.getText(), IzglitibaKnowladge.getText(), IzglitibaDateFrom.getValue(), IzglitibaDateTo.getValue());
			study.add(obj);
			DataBase.setIzglitiba(PersonasDatiController.persona.getID());
			MainController.user1.setIzglitibaList(study);
			System.out.println(study);
			
			MainController.counter--;
			Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
			Scene _scene = new Scene(_page);
			Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(_scene);
			app_stage.show();
			
		}
		
	}
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

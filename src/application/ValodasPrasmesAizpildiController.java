package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ValodasPrasmesAizpildiController {

	public static ObservableList<ValodasPrasmesClass> valodas= FXCollections.observableArrayList();
	
	ObservableList<String> Marks = FXCollections.observableArrayList(
			  "A1","A2","B1","B2","C1","C2"
			);
	ObservableList<String> LanguageType = FXCollections.observableArrayList(
			  "Dzimtā","Cita"
			);
	
	@FXML
	private  TextField valoda;
	@FXML
	private  TextArea diplomi;
	@FXML
	private  ChoiceBox<String> veids = new ChoiceBox<>() ;
	@FXML
	private  ChoiceBox<String> klausisanas = new ChoiceBox<>() ;
	@FXML
	private  ChoiceBox<String> lasisana = new ChoiceBox<>() ;
	@FXML
	private  ChoiceBox<String>dialogs = new ChoiceBox<>() ;
	@FXML
	private  ChoiceBox<String> monologs= new ChoiceBox<>() ;
	@FXML
	private  ChoiceBox<String> rakstisana= new ChoiceBox<>() ;
	@FXML
	private Label ValodasPrasmesWarningText= new Label();
	
	@FXML
	private void initializeAll() {
		veids.setItems(LanguageType);
		klausisanas.setItems(Marks);
		lasisana.setItems(Marks);
		dialogs.setItems(Marks);
		monologs.setItems(Marks);
		rakstisana.setItems(Marks);
	}
	
	
	@FXML
	private  void getValodasPrasmes(ActionEvent event) throws IOException, ClassNotFoundException, SQLException  {
	
		ValodasPrasmesWarningText.setText("");
		if(  veids.getValue()==null || klausisanas.getValue()==null || lasisana.getValue()==null || dialogs.getValue()==null || monologs.getValue()==null || rakstisana.getValue()==null || valoda.getText().equals("")  )
		{
			ValodasPrasmesWarningText.setText("*Lūdzu aizpildiet visus laukus");
		}
		
		else {
			ValodasPrasmesClass obj = new ValodasPrasmesClass(valoda.getText(),veids.getValue().toString(),klausisanas.getValue().toString(),lasisana.getValue().toString(),dialogs.getValue().toString(),monologs.getValue().toString(),rakstisana.getValue().toString(),diplomi.getText());
			valodas.add(obj);
			DataBase.setValodas(PersonasDatiController.persona.getID());
			MainController.user1.setValodasList(valodas);
			System.out.println(valodas);
			MainController.counter--;
			Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
			Scene _scene = new Scene(_page);
			Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(_scene);
			app_stage.show();
			
			
			//PersonasDatiClass persona = new PersonasDatiClass(name.getText(), surname.getText(), address.getText(), post_index.getText(), city.getText(), Integer.parseInt(number.getText()), mail.getText(), country.getValue().toString(), phoneType.getValue().toString());
		}
	}
	@FXML
	private  void goBack(ActionEvent event) throws IOException  {
		MainController.counter--;
		Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
		Scene _scene = new Scene(_page);
		Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(_scene);
		app_stage.show();
	}
	
	
	
	
	
	
}

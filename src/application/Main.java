package application;
	

import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class Main extends Application  {
	static ArrayList<String>pages = new ArrayList<>();
	public static Stage st;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			 ObservableList<String> allPages = FXCollections.observableArrayList(
					 "/application/Login.fxml",
					 "/application/Register.fxml",
					 "/application/PersonasDati.fxml",
					 "/application/Izglitiba.fxml",
					 "/application/IzglitibaAizpildi.fxml",
					 "/application/DarbaPieredze.fxml",
					 "/application/DarbaPieredzeAizpildi.fxml",
					 "/application/ValodasPrasmes.fxml",
					 "/application/ValodasPrasmesAizpildi.fxml",
					 "/application/CitasPrasmes1.fxml",
					 "/application/CitasPrasmes2.fxml",
					 "/application/Download.fxml"
						);
			pages.addAll(allPages);
			
			
			
			Parent root = FXMLLoader.load(getClass().getResource(pages.get(MainController.counter)));
			/*
			GridPane WorkExperiencePane= new GridPane();
			Text tFrom = new Text("No:");
			Text tTo = new Text("Līdz:");
			Text tProfession= new Text("Ieņemamais amats:");
			Text tWorkPlaceName= new Text("Darbavietas nosaukums:");
			Text tCity= new Text("Pilsēta:");
			Text tWorkDuties=new Text("Darba pienākumi:");
			
			
			
			WorkExperiencePane.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
			        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
			        + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
			
			DatePicker iFrom = new DatePicker();
			DatePicker iTo = new DatePicker();
			TextField iProfession= new TextField();
			TextField iWorkPlaceName= new TextField();
			TextField iCity= new TextField();
			TextArea iWorkDuties=new TextArea();
			Button submitExperience = new Button("Iesniegt");
			
			WorkExperiencePane.add(tFrom, 0, 0);
			WorkExperiencePane.add(iFrom,1 , 0);
			WorkExperiencePane.add(tTo, 0,1 );
			WorkExperiencePane.add(iTo, 1, 1);
			WorkExperiencePane.add(tProfession, 0, 2);
			WorkExperiencePane.add(iProfession, 1, 2);
			WorkExperiencePane.add(tWorkPlaceName, 0, 3);
			WorkExperiencePane.add(iWorkPlaceName, 1, 3);
			WorkExperiencePane.add(tWorkDuties, 0, 4);
			WorkExperiencePane.add(iWorkDuties, 1, 4);
			WorkExperiencePane.add(submitExperience,1,5);
			
			WorkExperiencePane.setAlignment(Pos.CENTER);
			*/
			
			
			
			
			Scene scene = new Scene(root,700,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

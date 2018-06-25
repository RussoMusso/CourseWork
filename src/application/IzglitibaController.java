package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.sun.javafx.scene.control.TableColumnSortTypeWrapper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class IzglitibaController implements Initializable {
	
	@FXML
	private Button addNewIzglitiba = new Button();
	@FXML
	private Button deleteIzglitiba = new Button();
	
	
	@FXML
	private TableView<IzglitibaClass> IzglitibaTable;
	@FXML
	private TableColumn<IzglitibaClass, LocalDate>IzglitibaDateFromCol;
	@FXML
	private TableColumn<IzglitibaClass, LocalDate>IzglitibaDateToCol;
	@FXML
	private TableColumn<IzglitibaClass, String>IzglitibaQualificationCol;
	@FXML
	private TableColumn<IzglitibaClass, String>IzglitibaStudyPlaceNameCol;
	
	public void initialize(URL url, ResourceBundle rb) {
		
		
		IzglitibaDateFromCol.setCellValueFactory(new PropertyValueFactory<IzglitibaClass, LocalDate>("dateFrom"));
		IzglitibaDateToCol.setCellValueFactory(new PropertyValueFactory<IzglitibaClass, LocalDate>("dateTo"));
		IzglitibaQualificationCol.setCellValueFactory(new PropertyValueFactory<IzglitibaClass, String>("qualification"));
		IzglitibaStudyPlaceNameCol.setCellValueFactory(new PropertyValueFactory<IzglitibaClass, String>("studyPlaceName"));
		//load data
		IzglitibaTable.setItems(IzglitibaAizpildiController.study);
	
	}
	public void goToAizpildi(ActionEvent event) throws IOException {
		MainController.counter++;
		Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
		Scene _scene = new Scene(_page);
		Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(_scene);
		app_stage.show();
	}
	
	public void deleteIzglitibaRow() {
		IzglitibaAizpildiController.study.remove(IzglitibaTable.getSelectionModel().getSelectedItems());
		IzglitibaTable.getItems().removeAll(IzglitibaTable.getSelectionModel().getSelectedItems());
		System.out.println(IzglitibaAizpildiController.study);
	}
	public void goToDarbaPieredze(ActionEvent event) throws IOException{
		MainController.counter++;
		MainController.counter++;
		Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
		Scene _scene = new Scene(_page);
		Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(_scene);
		app_stage.show();
	}
	public void goToPersonasDati(ActionEvent event) throws IOException {
		MainController.counter--;
		Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
		Scene _scene = new Scene(_page);
		Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(_scene);
		app_stage.show();
	}
	
}

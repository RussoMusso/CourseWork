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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ValodasPrasmesController implements Initializable{
	@FXML
	private Button addNewValoda = new Button();
	@FXML
	private Button deleteValoda = new Button();
	
	@FXML
	private Button NextPage = new Button();
	@FXML
	private Button PreviousPage = new Button();
	
	
	
	@FXML
	private TableView<ValodasPrasmesClass> ValodasTable;
	@FXML
	private TableColumn<ValodasPrasmesClass, String>ValodaCol;
	@FXML
	private TableColumn<ValodasPrasmesClass, String>VeidsCol;
	
	
	
	public void initialize(URL url, ResourceBundle rb) {
		
		ValodaCol.setCellValueFactory(new PropertyValueFactory<ValodasPrasmesClass, String>("valoda"));
		VeidsCol.setCellValueFactory(new PropertyValueFactory<ValodasPrasmesClass, String>("veids"));
		//load data
		ValodasTable.setItems(ValodasPrasmesAizpildiController.valodas);
	
	}
	public void goToAizpildi(ActionEvent event) throws IOException {
		MainController.counter++;
		Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
		Scene _scene = new Scene(_page);
		Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(_scene);
		app_stage.show();
	}
	//delete function , deletes object from array
	public void deleteValodasPrasmesRow() throws ClassNotFoundException, SQLException {
		int index= ValodasTable.getSelectionModel().getSelectedIndex();
		DataBase.deleteValodas(ValodasPrasmesAizpildiController.valodas.get(index).getId());
		ValodasTable.getItems().removeAll(ValodasTable.getSelectionModel().getSelectedItems());
		
		
	}
	public void goToCitasPrasmes1(ActionEvent event) throws IOException{
		MainController.counter++;
		MainController.counter++;
		Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
		Scene _scene = new Scene(_page);
		Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(_scene);
		app_stage.show();
	}
	public void goToDarbaPieredze(ActionEvent event) throws IOException {
		MainController.counter--;
		MainController.counter--;
		Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
		Scene _scene = new Scene(_page);
		Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(_scene);
		app_stage.show();
	}
	
}

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

public class DarbaPieredzeController implements Initializable {
		
	@FXML
	private Button addNewPieredze= new Button();
	@FXML
	private Button deletePieredze = new Button();
	
	@FXML
	private Button NextPage= new Button();
	@FXML
	private Button PreviousPage= new Button();
	
	//Variables for DarbaPieredze Table
		@FXML
		protected TableView<DarbaPieredzeClass> DarbaPieredzeTable;
		@FXML
		protected TableColumn<DarbaPieredzeClass, LocalDate>dateFrom;
		@FXML
		protected TableColumn<DarbaPieredzeClass, LocalDate>dateTo;
		@FXML
		protected  TableColumn<DarbaPieredzeClass, String>proffession;
		@FXML
		protected TableColumn<DarbaPieredzeClass, String>workPlaceName;
		
	
		public void initialize(URL url, ResourceBundle rb) {
			if(DarbaPieredzeAizpildiController.experience.size()!=0) {
				dateFrom.setCellValueFactory(new PropertyValueFactory<DarbaPieredzeClass, LocalDate>("dateFrom"));
				dateTo.setCellValueFactory(new PropertyValueFactory<DarbaPieredzeClass, LocalDate>("dateTo"));
				proffession.setCellValueFactory(new PropertyValueFactory<DarbaPieredzeClass, String>("profession"));
				workPlaceName.setCellValueFactory(new PropertyValueFactory<DarbaPieredzeClass, String>("workPlaceName"));
				//load data
				DarbaPieredzeTable.setItems(DarbaPieredzeAizpildiController.experience);
			}
		}
		public void goToAizpildi(ActionEvent event) throws IOException {
			MainController.counter++;
			Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
			Scene _scene = new Scene(_page);
			Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(_scene);
			app_stage.show();
		}
		//delete function , deletes object from array and table view
		public void deletePieredzeRow() throws ClassNotFoundException, SQLException {
			//DarbaPieredzeAizpildiController.experience.remove(DarbaPieredzeTable.getSelectionModel().getSelectedItems());
			//DarbaPieredzeTable.getItems().removeAll(DarbaPieredzeTable.getSelectionModel().getSelectedItems());
			int index= DarbaPieredzeTable.getSelectionModel().getSelectedIndex();
			DataBase.deletePieredze(DarbaPieredzeAizpildiController.experience.get(index).getId());
			DarbaPieredzeTable.getItems().removeAll(DarbaPieredzeTable.getSelectionModel().getSelectedItems());
			System.out.println(DarbaPieredzeAizpildiController.experience);
		}
		//goes to previous page
		public void goToIzglitiba(ActionEvent event) throws IOException {
			MainController.counter--;
			MainController.counter--;
			Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
			Scene _scene = new Scene(_page);
			Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(_scene);
			app_stage.show();
		}
		//goes to next page
		public void goToValodasPrasmes(ActionEvent event) throws IOException {
			
			MainController.counter++;
			MainController.counter++;
			Parent _page= FXMLLoader.load(getClass().getResource(Main.pages.get(MainController.counter)));
			Scene _scene = new Scene(_page);
			Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(_scene);
			app_stage.show();
		}
		
		
		
}
